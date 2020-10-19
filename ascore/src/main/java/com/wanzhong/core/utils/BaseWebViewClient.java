package com.wanzhong.core.utils;


import android.webkit.WebViewClient;

public class BaseWebViewClient extends WebViewClient {

	public interface WebViewClientListener {
		public void onPageFinished(String url);
	}
	
	protected WebViewClientListener mWebViewClientListener;
	public void setWebViewClientListener(WebViewClientListener listener){
		mWebViewClientListener = listener;
	}
}
