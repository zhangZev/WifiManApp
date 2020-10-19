package com.wanzhong.core.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

import com.hwangjr.rxbus.RxBus;
import com.wanzhong.core.view.webview.LoadWebView;
import com.wanzhong.core.webview.WebViewActivity;

import java.util.HashMap;
import java.util.Map;

import androidx.fragment.app.Fragment;


/**
 * WebViewClient,不要直接new
 * 通过RemoteManager获取:
 * RemoteManager.getInstance().getWebViewClient()
 * */
public class CtWebViewClient extends BaseWebViewClient {

	private boolean mUrlOpenNewActivity = false;
	private Map<String,Integer> mUrlMaps = new HashMap<>();
	@Override
	public void onPageFinished(WebView view, String url) {
		
		super.onPageFinished(view, url);
		
		if(view.getParent().getParent().getParent() instanceof LoadWebView){
			LoadWebView loadWebView=(LoadWebView) view.getParent().getParent().getParent();
			loadWebView.hiddenLoading();
		}
		if(mWebViewClientListener != null){
			mWebViewClientListener.onPageFinished(url);
		}
		
	}

	@Override
	public void onPageStarted(WebView view, String url, Bitmap favicon) {
		super.onPageStarted(view, url, favicon);
		/*
		if(!mUrlMaps.containsKey(url)){
			mUrlMaps.put(url,1);
		}*/
		RxBus.get().post("onLoadResource",url);
	}

	@Override
	public void onLoadResource(WebView view, String url) {
		super.onLoadResource(view, url);
	/*	if(mUrlMaps.containsKey(url)){
			RxBus.get().post("onLoadResource",url);
		}*/
	}

	@Override
	public void onReceivedError(WebView view, int errorCode,String description, String failingUrl) {
		super.onReceivedError(view, errorCode, description, failingUrl);
		if(view.getParent().getParent().getParent() instanceof LoadWebView){
			LoadWebView loadWebView=(LoadWebView) view.getParent().getParent().getParent();
			loadWebView.showError("加载失败");

			/*if(!ConnectionUtil.getInstance().isNetworkConnected(view.getContext())){
				loadWebView.showNoNetWork(view.getContext().getString(ThemeUtil.getRemoteId(view.getContext(), "loadwebview_no_net", ThemeUtil.RESOURCES_TYPE_STRING, R.string.loadwebview_no_net)));
			} else {
				loadWebView.showError(view.getContext().getString(ThemeUtil.getRemoteId(view.getContext(), "loadwebview_error", ThemeUtil.RESOURCES_TYPE_STRING, R.string.loadwebview_error)));
			}*/
			
		}
	}
	
	private String mTitle;
	private String mRightText;
	private String mRFuction;
	private String mTheme;
	public void setGotoUrlInfo(String title,final String rightText,final String rFuncation,final String theme){
		mTitle = title;
		mRightText = rightText;
		mRFuction = rFuncation;
		mTheme = theme;
	}
	private static final String TEL = "tel:";
	private static final String SMS = "sms:";

	private static final String HTTP = "http:";
	private static final String HTTPS = "https:";
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		if (!url.startsWith(HTTP) && !url.startsWith(HTTPS)){
			Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
			try{
				view.getContext().startActivity(intent);
			} catch(ActivityNotFoundException e){
				
			}
		} else {
			if(url != null && view.getUrl() != null && url.equals(view.getUrl())){
				//view.loadUrl(CommonUtil.getUrl(view.getContext(), url));
				return false;
			} else if(mUrlOpenNewActivity){
				Intent mi=new Intent(view.getContext(), WebViewActivity.class);
				mi.putExtra(JsInterface.EXT_URL,url);
				mi.putExtra(JsInterface.EXT_TITLE,TextUtils.isEmpty(mTitle) ? "" :mTitle);
				mi.putExtra(JsInterface.EXT_OPEN_BY_WEB_CLIENT,true);
				appendGotoUrlExtras(mi);
				if(view.getTag() != null && view.getTag() instanceof Fragment){
					((Fragment)view.getTag()).startActivityForResult(mi,JsInterface.JSINTERFACE_REQUEST);
				} else {
					((Activity)view.getContext()).startActivityForResult(mi,JsInterface.JSINTERFACE_REQUEST);
				}
			}  else {
				//view.loadUrl(CommonUtil.getUrl(view.getContext(), url));
				return false;
			}
			
		}
		return true;
	}
	
	protected void appendGotoUrlExtras(Intent intent){
		if(mRightText != null){
			intent.putExtra(JsInterface.EXT_RTEXT, mRightText);
		}
		if(mRFuction != null){
			intent.putExtra(JsInterface.EXT_RCALLBACK, mRFuction);
		}
		if(!TextUtils.isEmpty(mTheme)){
			intent.putExtra(JsInterface.EXT_THEME, mTheme);
		}
		mRightText = null;
		mRFuction = null;
		mTheme = null;
	}

	@Override
	public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
		//handler.cancel(); // Android默认的处理方式
		handler.proceed();  // 接受所有网站的证书
		//handleMessage(Message msg); // 进行其他处理
	}
	
}
