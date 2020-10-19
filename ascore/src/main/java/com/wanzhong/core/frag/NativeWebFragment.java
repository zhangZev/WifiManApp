package com.wanzhong.core.frag;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.ValueCallback;
import android.webkit.WebView;

import com.wanzhong.core.R;
import com.wanzhong.core.utils.CtWebChromeClient;
import com.wanzhong.core.utils.ImageUtil;
import com.wanzhong.core.utils.JsInterface;
import com.wanzhong.core.utils.NativeWebViewClient;
import com.wanzhong.core.utils.ParentJsInterface;
import com.wanzhong.core.view.webview.NativeLoadWebView;

import java.io.File;


/**通用加载url的Fragment*/
public class NativeWebFragment extends BaseWebFragment implements OnClickListener, CtWebChromeClient.CtChromeClientListener,CtWebChromeClient.OpenFileChooserCallBack {

	
	protected NativeLoadWebView mWebView;
	protected JsInterface mJsInterface ;
	protected String mRightText;
	protected String mRightFunc;
	protected NativeWebViewClient mBaseWebViewClient;
    private static final int REQUEST_CODE_PICK_IMAGE = 0;  
    private static final int REQUEST_CODE_IMAGE_CAPTURE = 1;  
    private ValueCallback<Uri> mUploadMsg;  
    private ValueCallback<Uri[]> mUploadMsg5Plus;  
    private Intent mSourceIntent;  
    private static final String TAG = "ImgPick"; 


	@Override
	protected int getLayoutId() {
		return R.layout.native_fragment_webview;
	}

	public void back() {
		getActivity().finish();
	}
	protected void initView(){
		mWebView = (NativeLoadWebView) mRootView.findViewById(R.id.activty_wb_content);
		mWebView.mWebView.setTag(this);
		mJsInterface = new JsInterface(getContext(),mWebView.mWebView);
		
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.requestFocus();
		mWebView.getSettings().setDefaultTextEncodingName("utf-8");
		mWebView.addJavascriptInterface(mJsInterface, ParentJsInterface.HomeJsNamespace);
		mBaseWebViewClient = new NativeWebViewClient();
		mWebView.setWebViewClient(mBaseWebViewClient);
		mWebView.setWebChromeClient(new CtWebChromeClient(this,this));

		mWebView.setRef(true);
		
		if(this.getArguments() == null){
			//do nothing
			return;
		}
		fillContent(this.getArguments());

	}

	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
	}


	private void fillContent(Bundle bundle){
		if(bundle == null){
			return;
		}
		String title = bundle.getString(JsInterface.EXT_TITLE);
		String url = bundle.getString(JsInterface.EXT_URL);
		if(url != null && url.equals(mWebView.mWebView.getUrl())){
			//url is the same ,do not fill
			//LogUtil.d("cx","----  url is the same ,do not fill ");
			return;
		}
		mRightText = bundle.getString(JsInterface.EXT_RTEXT);
		mRightFunc = bundle.getString(JsInterface.EXT_RCALLBACK);
		mTitleTv.setText(title == null ? ""  : title);
		if(!TextUtils.isEmpty(mRightText) && !TextUtils.isEmpty(mRightFunc)){
			mTitleRightTv.setText(mRightText);
		}

		mWebView.loadUrl(url,true);
	}

	
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){

		}

	}
	
	public JsInterface getJsInterface(){
		return mJsInterface;
	}


	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		try{
			mWebView.mWebView.removeAllViews();
			mWebView.mWebView.destroy();
		} catch (Exception e){
			
		}
	}
	
	@Override
	public void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		if(intent != null && intent.getExtras() != null){
			final Bundle bundle = intent.getExtras();
			if(!TextUtils.isEmpty(bundle.getString(JsInterface.EXT_URL))){
				fillContent(bundle);
				return;
			}
		}
		
		if(mWebView != null){
			mWebView.reload();
		}
	}


	@Override
	public void urlBackClicked() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onReceivedTitle(WebView view, String title) {
		if(getActivity()!= null && mTitleTv != null && TextUtils.isEmpty(mTitleTv.getText())){
			mTitleTv.setText(title);
		}
		
	}




	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode != Activity.RESULT_OK) {  
            return;  
        }  
        switch (requestCode) {  
            case REQUEST_CODE_IMAGE_CAPTURE:  
            case REQUEST_CODE_PICK_IMAGE: {  
                try {  
                    if (mUploadMsg == null && mUploadMsg5Plus == null) {  
                        return;  
                    }  
                    String sourcePath = ImageUtil.retrievePath(getContext(), mSourceIntent, data);
                    if (TextUtils.isEmpty(sourcePath) || !new File(sourcePath).exists()) {  
                        Log.w(TAG, "sourcePath empty or not exists.");  
                        break;  
                    }  
                    Uri uri = Uri.fromFile(new File(sourcePath));  
                    if (mUploadMsg != null) {  
                        mUploadMsg.onReceiveValue(uri);  
                        mUploadMsg = null;  
                    } else {  
                        mUploadMsg5Plus.onReceiveValue(new Uri[]{uri});  
                        mUploadMsg5Plus = null;  
                    }  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
                break;  
            }  
        }  
		super.onActivityResult(requestCode, resultCode, data);
	}
	 @Override  
	    public void openFileChooserCallBack(ValueCallback<Uri> uploadMsg, String acceptType) {  
	        mUploadMsg = uploadMsg;  
	        showOptions();  
	    }  
	  
	  
	    @Override  
	    public void showFileChooserCallBack(ValueCallback<Uri[]> filePathCallback) {  
	        mUploadMsg5Plus = filePathCallback;  
	        showOptions();  
	    }  
	  
	  
	    public void showOptions() {  
	        /*AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
	        alertDialog.setOnCancelListener(new ReOnCancelListener());  
	        alertDialog.setTitle(this.getResources().getString(R.string.msg_check_select));
	        alertDialog.setItems(R.array.options, new DialogInterface.OnClickListener() {
	            @Override  
	            public void onClick(DialogInterface dialog, int which) {  
	                if (which == 0) {  
	                    mSourceIntent = ImageUtil.choosePicture();
	                    startActivityForResult(mSourceIntent, REQUEST_CODE_PICK_IMAGE);  
	                } else {  
	                    mSourceIntent = ImageUtil.takeBigPicture();  
	                    startActivityForResult(mSourceIntent, REQUEST_CODE_IMAGE_CAPTURE);  
	                }  
	            }  
	        });  
	        alertDialog.show();  */
	    }  
	  
	  
	    private void fixDirPath() {  
	        String path = ImageUtil.getDirPath();  
	        File file = new File(path);  
	        if (!file.exists()) {  
	            file.mkdirs();  
	        }  
	    }  
	  
	  
	    private class ReOnCancelListener implements DialogInterface.OnCancelListener {  
	  
	  
	        @Override  
	        public void onCancel(DialogInterface dialogInterface) {  
	            if (mUploadMsg != null) {  
	                mUploadMsg.onReceiveValue(null);  
	                mUploadMsg = null;  
	            }  
	            if (mUploadMsg5Plus != null) {  
	                mUploadMsg5Plus.onReceiveValue(null);  
	                mUploadMsg5Plus = null;  
	            }  
	        }  
	    }


	@Override
	public void onBackPressed() {
		if(getActivity() != null){
			getActivity().finish();
		}

	}
}
