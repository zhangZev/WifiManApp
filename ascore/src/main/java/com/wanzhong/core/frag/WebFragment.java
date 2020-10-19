package com.wanzhong.core.frag;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.hwangjr.rxbus.RxBus;
import com.wanzhong.core.R;
import com.wanzhong.core.utils.BaseWebViewClient;
import com.wanzhong.core.utils.CommonUtil;
import com.wanzhong.core.utils.CtWebChromeClient;
import com.wanzhong.core.utils.CtWebViewClient;
import com.wanzhong.core.utils.ImageUtil;
import com.wanzhong.core.utils.JsInterface;
import com.wanzhong.core.utils.ParentJsInterface;
import com.wanzhong.core.view.bottombar.UIUtils;
import com.wanzhong.core.view.webview.LoadWebView;

import java.io.File;


/**通用加载url的Fragment*/
public class WebFragment extends BaseWebFragment implements OnClickListener, JsInterface.JsInterfaceListene, CtWebChromeClient.CtChromeClientListener,CtWebChromeClient.OpenFileChooserCallBack {

	private static final String PATH_WEIDIAN_INDEX = "/wzweb/wd/index";
	private static final String PATH_WEIDIAN_MAICHE = "/wzweb/wd/maiche";
	protected LoadWebView mWebView;
	protected JsInterface mJsInterface ;
	protected String mRightText;
	protected String mRightFunc;
	protected SensorManager mSensorManager;
	protected BaseWebViewClient mBaseWebViewClient;
    private static final int REQUEST_CODE_PICK_IMAGE = 0;
    private static final int REQUEST_CODE_IMAGE_CAPTURE = 1;
    private ValueCallback<Uri> mUploadMsg;
    private ValueCallback<Uri[]> mUploadMsg5Plus;
    private Intent mSourceIntent;
    private static final String TAG = "ImgPick";

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_webview;
	}

	@Override
	protected boolean isStatusBarDarkFont(){
		return true;
	}


	public void back() {
		getActivity().finish();
	}


	@Override
	public void initView(View root){
		RxBus.get().register(this);
		initLeftListener();
		//mTitleView.setTitleRightText("分享");
		mWebView = (LoadWebView) root.findViewById(R.id.activty_wb_content);
		mWebView.mWebView.setTag(this);
		mJsInterface = new JsInterface(getContext(),mWebView.mWebView);

		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.requestFocus();
		mWebView.getSettings().setDefaultTextEncodingName("utf-8");
		mWebView.addJavascriptInterface(mJsInterface, ParentJsInterface.HomeJsNamespace);
		mBaseWebViewClient = new CtWebViewClient();
		mWebView.setWebViewClient(mBaseWebViewClient);
		mWebView.setWebChromeClient(new CtWebChromeClient(this,this));

		mWebView.setRef(true);
		mJsInterface.setJsInterfaceListener(this);
		if(this.getArguments() == null){
			//do nothing
			return;
		}
		fillContent(this.getArguments());

		/*if(this.getActivity() instanceof MainActivity){

		} else {
			//mJsInterface.sendSMS("15116997977", reason, func)
		}*/
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

	}


	boolean rightCloseAllWebs = false;
	private void fillContent(Bundle bundle){
		if(bundle == null){
			return;
		}
		String title = bundle.getString(JsInterface.EXT_TITLE);
		String url = bundle.getString(JsInterface.EXT_URL);
		boolean openByWebClient = bundle.getBoolean(JsInterface.EXT_OPEN_BY_WEB_CLIENT);
		if(url != null && CommonUtil.getUrl(mWebView.getContext(), url).equals(mWebView.mWebView.getUrl())){
			//url is the same ,do not fill
			return;
		}
		mRightText = bundle.getString(JsInterface.EXT_RTEXT);
		mRightFunc = bundle.getString(JsInterface.EXT_RCALLBACK);
		setTitle(title == null ? ""  : title);
		if(!TextUtils.isEmpty(mRightText) && !TextUtils.isEmpty(mRightFunc)){
			mTitleRightTv.setText(mRightText);

		} else if(openByWebClient) {
			mTitleRightTv.setText(this.getResources().getString(R.string.button_close));
			rightCloseAllWebs = true;
		}
		mTitleRightTv.setOnClickListener(this);
		mWebView.loadUrl(url,true);
	}

	public void backAllWebViews(){
		getActivity().setResult(JsInterface.RESULT_BACK_ALL_WEBVIEW);
		getActivity().finish();
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == JsInterface.JSINTERFACE_REQUEST){
			if(resultCode == JsInterface.RESULT_RUN_BACK_FUN){
				String function =data.getStringExtra(JsInterface.EXT_FUNCTION);
				String parems=data.getStringExtra(JsInterface.EXT_PARAM);
				if(!TextUtils.isEmpty(function) && !TextUtils.isEmpty(parems)){
					mJsInterface.runJsFunction(mWebView.mWebView,function+parems, null);
				}
			} else if(resultCode == JsInterface.RESULT_BACK_ALL_WEBVIEW){
				backAllWebViews();
			}
		} else if (requestCode == REQUEST_CODE_IMAGE_CAPTURE || requestCode == REQUEST_CODE_PICK_IMAGE){
			if (resultCode == Activity.RESULT_OK) {
				switch (requestCode) {
	            case REQUEST_CODE_IMAGE_CAPTURE:
	            case REQUEST_CODE_PICK_IMAGE: {
	                try {
	                    if (mUploadMsg == null && mUploadMsg5Plus == null) {
	                    	break;
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
	        }  else {
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
		callPageDisplay();
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

	private boolean mIsDestoryed = false;
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		RxBus.get().unregister(this);
		try{
			mWebView.mWebView.removeAllViews();
			mWebView.mWebView.destroy();
		} catch (Exception e){

		}
		mIsDestoryed = true;
	}





	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		// TODO Auto-generated method stub
		super.setUserVisibleHint(isVisibleToUser);
		if(isVisibleToUser){
			callPageDisplay();
		}

	}

	/**
	 * 尝试调用_phone_pageDisplay
	 * */
	private void callPageDisplay(){
		/*if(mWebView != null && mWebView.mWebView != null && mJsInterface != null){
			final String passport = SPUtil.getInstant(mWebView.getContext()).get(Constant.PASSPORT, "").toString();
			StringBuilder jsCode = new StringBuilder("_phone_pageDisplay(\""+passport+"\")");
			mJsInterface.runJsFunction(mWebView.mWebView, jsCode.toString(), null);
		}*/
	}




	@Override
	public void onTitleSeted(String title) {
		// TODO Auto-generated method stub
		/*if(mTitleTv != null){
			mTitleTv.setText(title);
		}*/
		setTitle(title);


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
		if(mWebView != null){
			if(mWebView.canGoBack()){
				mWebView.goBack();
			} else if(getActivity() != null){
				getActivity().finish();
			}
		} else {
			getActivity().finish();
		}

	}


	@Override
	public void onReceivedTitle(WebView view, String title) {
		/*if(getActivity()!= null && mTitleTv != null && TextUtils.isEmpty(mTitleTv.getText())){
			mTitleTv.setText(title);
		}*/
		/*if(StringUtil.isNullOrSpace(mTitleTv.getText().toString())) {
			setTitle(title);
		}*/
	}


	@Override
	public void onTitleRightSeted(String text, String function) {
		mRightText = text;
		mRightFunc = function;
		if(!TextUtils.isEmpty(mRightText) && !TextUtils.isEmpty(mRightFunc)){
			mTitleRightTv.setText(mRightText);
			mTitleRightTv.setOnClickListener(this);
		}

	}


	@Override
	public void openFileChooserCallBack(ValueCallback<Uri> uploadMsg,
			String acceptType) {
		mUploadMsg = uploadMsg;
		showOptions();
	}

	@Override
	public void showFileChooserCallBack(ValueCallback<Uri[]> filePathCallback) {
		mUploadMsg5Plus = filePathCallback;
		showOptions();
	}


	private int TYPE_REQUEST_PERMISSION = 100;
	public void showOptions() {
		mSourceIntent = ImageUtil.choosePicture();
		startActivityForResult(mSourceIntent, REQUEST_CODE_PICK_IMAGE);
	/*    AlertDialog.Builder alertDialog = new AlertDialog.Builder(mTitleView.getContext());
		alertDialog.setOnCancelListener(new ReOnCancelListener());
		alertDialog.setTitle(R.string.options);
		alertDialog.setItems(R.array.options, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (which == 0) {
					mSourceIntent = ImageUtil.choosePicture();
					startActivityForResult(mSourceIntent, REQUEST_CODE_PICK_IMAGE);
				} else {
					 if (ContextCompat.checkSelfPermission(mTitleView.getContext(),
								Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
							// 申请WRITE_EXTERNAL_STORAGE权限
							ActivityCompat
									.requestPermissions(
											(Activity) mTitleView.getContext(),
											new String[] { Manifest.permission.CAMERA },
											TYPE_REQUEST_PERMISSION);
						} else {
							mSourceIntent = ImageUtil.takeBigPicture();
							startActivityForResult(mSourceIntent, REQUEST_CODE_IMAGE_CAPTURE);

						}

				}
			}
		});
		alertDialog.show();  */
	}

	@Override
	public void onRequestPermissionsResult(int requestCode,  String[] permissions,  int[] grantResults) {

		switch (requestCode) {
			case REQUEST_CODE_IMAGE_CAPTURE: {
				// If request is cancelled, the result arrays are empty.
				if (grantResults.length > 0
						&& grantResults[0] == PackageManager.PERMISSION_GRANTED) {


				} else {

				}

			}
		}

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



	protected boolean isHome(Uri uri){
		return PATH_WEIDIAN_INDEX.equals(uri.getPath());
	}
	protected boolean isMaiche(Uri uri){
		return PATH_WEIDIAN_MAICHE.equals(uri.getPath());
	}

	/*@Subscribe(thread = EventThread.MAIN_THREAD, tags = {@Tag("onLoadResource")})
	public void onUrlChanged(String url){
		if(canShowToolBar(url)){
			showToolBar(true);
		} else {
			showToolBar(false);
		}
	}*/
	private int mToolBarHeight = -1 ;
	protected void showToolBar(boolean show){
		LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)toolbar.getLayoutParams();
		if(mToolBarHeight == -1 && params.height > 0){
			mToolBarHeight = params.height;
		}
		if(show){
			params.height = mToolBarHeight;
			params.bottomMargin = 1;
		} else {
			params.height = mToolBarHeight - UIUtils.dip2Px(getContext(),45);
			params.bottomMargin = 0;
		}
		toolbar.setLayoutParams(params);
	}

	@Override
	public void onBackPressed() {
		urlBackClicked();
	}
}
