package com.wanzhong.core.utils;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.wanzhong.core.view.webview.GotoUrlWebView;
import com.wanzhong.core.webview.WebViewActivity;

import androidx.fragment.app.Fragment;


/**
 * 与JS交互,不要直接new. <br/>
 * 通过RemoteManager获取:<br/>
 * RemoteManager.getInstance().getJsInterface(root.getContext(), mWebView.mWebView)
 * */
public class JsInterface extends ParentJsInterface /*implements OnClickListener*/{
	
	public static final int VERSION_CODE = 2;
	protected Activity mContext;
	private WebView mWebView;
	private PostAgentJsLoadEndListener mPostAgentJsLoadEndListener;

	/**startActivity from JsInterface,setRequestCode to JSINTERFACE_REQUEST*/
	public final static int JSINTERFACE_REQUEST=100;
	/**result code set to RESULT_RUN_BACK_FUN when setPageResult called*/
	public final static int RESULT_RUN_BACK_FUN = 11;

	/**关闭栈内所有WebActivity*/
	public final static int RESULT_BACK_ALL_WEBVIEW = 12;
	
	
	public static final String EXT_RESULT = "ext_result";
	public static final String EXT_FUNCTION = "ext_function";
	public static final String EXT_PARAM = "ext_param";
	public static final String EXT_TITLE = "ext_title";
	public static final String EXT_URL = "ext_url";
	public static final String EXT_RTEXT = "ext_r_text";
	public static final String EXT_RCALLBACK = "ext_r_callback";
	public static final String EXT_PAGE_INDEX = "ext_page_index";
	public static final String EXT_THEME = "ext_theme";
	public static final String EXT_NATIVE_WEB = "ext_native_web";
	public static final String EXT_OPEN_BY_WEB_CLIENT = "open_by_web_client";


	private String mBackAction;
	public WebView getWeb(){
		return mWebView;
	}
	
	
	
	public JsInterface(Context context,WebView webView){
		super(context,webView);
		mContext=(Activity) context;
		mWebView = webView;
		mPostAgentJsLoadEndListener = new PostAgentJsLoadEndListener();
	}


	@Deprecated
	@JavascriptInterface
	public void gotoUrl(final String url,final String title,final String rightText,final String rFuncation,String theme){
    	go(url, title, rightText, rFuncation,theme);
	}

    @Deprecated
	@JavascriptInterface
	public void gotoUrl(final String url,final String title,final String rightText,final String rFuncation){
    	gotoUrl(url, title, rightText, rFuncation,"");
	}

    /**
     * 打开第三方页面
     * 所有url不再追加version和passport
     * 允许处理自定义的Uri
     * 
     * */
    @JavascriptInterface
	public void gotoWeb(final String url,final String title,final String rightText,final String rFuncation){
    	mContext.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent mi=new Intent(mContext,WebViewActivity.class);
				mi.putExtra(JsInterface.EXT_URL,url);
				mi.putExtra(JsInterface.EXT_TITLE,TextUtils.isEmpty(title) ? "" :title);
				mi.putExtra(JsInterface.EXT_RTEXT, rightText);
				mi.putExtra(JsInterface.EXT_RCALLBACK, rFuncation);
				mi.putExtra(JsInterface.EXT_NATIVE_WEB, true);
				mContext.startActivity(mi);
			}
		});
		
	}


	private class PostAgentJsLoadEndListener implements OnJsLoadEndListener{

		@Override
		public void onLoadEnd(String arg0, String arg1) {
			// TODO Auto-generated method stub
			mContext.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					//DialogUtil.getInstant(mContext).dismissWait();
				}
			});
		}

	}


	public interface OnJsLoadEndListener{
		public void onLoadEnd(String jsCode, String result);
	}




	//分享方式 0：未设置 1：微信朋友圈，2.微信好友 3：QQ空间，4：QQ好友
	/*private int mShareWay = 0;
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.dialog_share_weixin_friend:
				mShareWay = 1;
				WXShareManager.getInstant(v.getContext()).shareImg(v.getContext(),mWord, mWord, mUrl, mPic, WXShareManager.FGROUP, this);
				break;
			case R.id.dialog_share_weixin_group:
				mShareWay = 2;
				WXShareManager.getInstant(v.getContext()).shareImg(v.getContext(),mTitle, mWord, mUrl, mPic, WXShareManager.FRIEND, this);
				break;
			case R.id.dialog_share_qq:
				mShareWay = 4;
				QQShareManager.getInstant().shareToQQ(mContext,mTitle, mPic,mUrl, mWord,mTitle,this);
				break;
			case R.id.dialog_share_qzone:
				mShareWay = 3;
				QQShareManager.getInstant().shareQzone(mContext,mTitle, mPic,mUrl, mWord,mTitle,this);
				break;
		}
	}*/

	/**
	 * 打开新页面
	 * @param url 新页面加载的Url
	 * @param title 新页面的标题
	 * @param rightText 新页面顶部右侧按钮显示内容
	 * @param rFuncation 新页面点击顶部右侧按钮时调用的js
	 * */
	@JavascriptInterface
	public void go(final String url,final String title,final String rightText,final String rFuncation,final String theme){
		mContext.runOnUiThread(new Runnable() {

			@Override
			public void run() {
				final CtWebViewClient dkwebClient = new CtWebViewClient();
				WebView tmpWebView = new GotoUrlWebView(mContext);
				if(mWebView != null && mWebView.getTag() != null){
					tmpWebView.setTag(mWebView.getTag());
				}
				dkwebClient.setGotoUrlInfo(title, rightText, rFuncation,theme);
				dkwebClient.shouldOverrideUrlLoading(tmpWebView, url);
				tmpWebView = null;
			}
		});
	}

	/**
	 * 关闭当前页面后到上一个页面调用setPageResult(func,result)
	 *  func为空不调用，直接关闭
	 *
	 * */
	@JavascriptInterface
	public void back(final String func,final String result){
		mContext.runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				setPageResult(func,result);
				mContext.finish();
			}
		});
	}

	/**
	 * 设置回传内容,返回上一个页面后会回调
	 *	func为空不执行
	 *	用户关闭本页面，回到上一页时调用func(‘result’)
	 *
	 * */
	@JavascriptInterface
	public void setPageResult(final String func,final String result){
		mContext.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if(TextUtils.isEmpty(func)){
					return;
				}
				String tresult="('"+result+"')";
				Intent intent=new Intent();
				intent.putExtra(EXT_FUNCTION,func);
				intent.putExtra(EXT_PARAM,tresult);
				mContext.setResult(RESULT_RUN_BACK_FUN,intent);
			}
		});

	}

	/**
	 * 设置用户按返回按钮时的调用方法
	 * */
	@JavascriptInterface
	public void setBackAction(String func){
		mBackAction = func;
	}

	public boolean handleBackAction(){
		if(TextUtils.isEmpty(mBackAction)){
			return false;
		}
		runJsFunction(mWebView, mBackAction, null);
		return true;
	}



	
	private JsInterfaceListene mJsInterfaceListene;
	public void setJsInterfaceListener(JsInterfaceListene listener){
		mJsInterfaceListene = listener;
	}
	public interface JsInterfaceListene{		
		public void onTitleSeted(String title);
		public void onTitleRightSeted(String text, String function);
		
	}
	
	/**
	 * 设置标题
	 * */
	@JavascriptInterface
	public void setTitle(final String title){
		mContext.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(mJsInterfaceListene != null){
					mJsInterfaceListene.onTitleSeted(title);
				}
			}
		});
	}
	/**
	 * 设置标题
	 * */
	@JavascriptInterface
	public void setTitleRight(final String text,final String func){
		mContext.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(mJsInterfaceListene != null){
					mJsInterfaceListene.onTitleRightSeted(text,func);
				}
			}
		});
	}

	private void startActivityForResult(Intent intent,int requestCode){
		if(mWebView != null && mWebView.getTag() != null && mWebView.getTag() instanceof Fragment){
			((Fragment)mWebView.getTag()).startActivityForResult(intent, requestCode);
		} else {
			mContext.startActivityForResult(intent, requestCode);
		}
	}


	@JavascriptInterface
	public void postMessage(String msg) {
		if(mWebView != null && mWebView.getContext() instanceof WebViewActivity){
			((WebViewActivity)mWebView.getContext()).finish();
		}
	}

	private void showLoadingDialog(){
		DialogUtil.getInstant(mContext).showWait();
	}
	private void hideLoadingDialog(){
		DialogUtil.getInstant(mContext).dismissWait();
	}




	private void setJsResult(String func,String result){
		runJsFunction(mWebView, func+"('"+result+"')", null);
	}

	
	/**
	 * 分享
	 * @param reason 分享成功之后原样返回
	 * @param type 分享方式 weixinfriends:微信,weixinpublic:微信朋友圈,qq:QQ好友,qzone:QQ空间,其他值弹出选择对话框
	 * @param title 标题,最长30个字符
	 * @param word 内容,最长40个字
	 * @param tip 选择分享方式对话框的提示信息
	 * @param pic 图片地址，图片大小不超过32k
	 * @param url 跳转页面的Url
	 * */
	@JavascriptInterface
	public void doUserShare(final String reason,final String type,final String title,final String word,final String tip,final String pic,final String url){
		mContext.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				share(reason, type, title, word, tip, pic, url);
			}
		});
	}

	
	private String mReason="",mTitle="",mWord="",mPic="",mUrl="";
	public void share(final String reason,String type,String title,String word,String tip,String pic,String url){
		/*mReason=reason;mTitle=title;mWord=word;mPic=pic;mUrl=url;
		try{
			if(type.equals("weixinfriends")){
				WXShareManager.getInstant(mContext).shareImg(mContext,title, word, url, pic, WXShareManager.FRIEND, this);
			}else if(type.equals("weixinpublic")){
				WXShareManager.getInstant(mContext).shareImg(mContext,word, word, url, pic, WXShareManager.FGROUP, this);
			}else if(type.equals("qq")){
				QQShareManager.getInstant().shareToQQ(mContext, mTitle, mPic, mUrl, mWord,"", this);
			}else if(type.equals("qzone")){
				QQShareManager.getInstant().shareQzone(mContext,mTitle, mPic,mUrl, mWord,"", this);
			} else {
				DialogUtil.getInstant(mContext).showShare(null,this,tip);
			}
		}catch(Exception ex){
			DialogUtil.getInstant(mContext).showMsg(ThemeUtil.getRemoteId(mContext, "share_init_failed", ThemeUtil.RESOURCES_TYPE_STRING, R.string.share_init_failed));
		}*/
	}

	/**
	 * 取消QQ分享回调
	 * */
//	@Override
//	public void onCancel() {
//		// TODO Auto-generated method stub
//
//	}

	/**
	 * QQ分享完成回调
	 * */
//	@Override
//	public void onComplete(Object arg0) {
//		// TODO Auto-generated method stub
//		handleShareSucc();
//	}

	/**
	 * QQ分享失败回调
	 * */
//	@Override
//	public void onError(final UiError arg0) {
//		// TODO Auto-generated method stub
//		mContext.runOnUiThread(new Runnable() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				DialogUtil.getInstant(mContext).showMsg(""+arg0.errorMessage);
//			}
//		});
//	}


	/**
	 * 微信分享完成
	 * */
//	@Override
//	public void onShareEnd(int code) {
//		// TODO Auto-generated method stub
//		switch(code){
//			case BaseResp.ErrCode.ERR_OK:
//				handleShareSucc();
//				break;
//			case BaseResp.ErrCode.ERR_USER_CANCEL:
//				break;
//			case BaseResp.ErrCode.ERR_AUTH_DENIED:
//				DialogUtil.getInstant(mContext).showMsg(R.string.share_failed);
//				break;
//		}
//	}
//	private void handleShareSucc(){
//		LogUtil.d("cx","handleShareSucc============ ");
//		ConnectionManager.getInstance().postShareResult(mContext, mShareWay,mReason,  new OnDataLoadEndListener() {
//
//			@Override
//			public void OnLoadEnd(final String ret) {
//				LogUtil.d("cx","ret============ "+ret);
//				BaseBean bean = App.getInstance().getBeanFromJson(ret, BaseBean.class);
//				if(bean.isResultSuccess()){
//					if(mReason.startsWith("1|1") && mContext != null && !mContext.isFinishing() && mWebView != null){
//						try{
//							mContext.runOnUiThread(new Runnable() {
//
//								@Override
//								public void run() {
//									mWebView.reload();
//								}
//							});
//						} catch (Exception e){
//
//						}
//					}
//				}
//
//
//			}
//		});
//
//		if(mContext != null && !mContext.isFinishing()){
//			try{
//				mContext.runOnUiThread(new Runnable() {
//
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						DialogUtil.getInstant(mContext).dismiss();
//					}
//				});
//			} catch (Exception e){
//
//			}
//		}
//	}
	
}
