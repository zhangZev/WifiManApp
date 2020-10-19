package com.wanzhong.core.utils;

import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import java.util.HashMap;

public class ParentJsInterface {
	
	public static final String HomeJsNamespace = "WzJs";
	private Activity mContext;
	private WebView mWebView;
	
	public ParentJsInterface(Context context, WebView webView) {
		mContext=(Activity) context;
		mWebView=webView;
	}
	
	
	
	private static final String QUOTE = "\"";
	private static final String SINGLE_QUOTE ="\'";
	private static final String EMPTY = "";
	private static final String LEFT_BRACKET = "(";
	private String removeQuotes(String jsCode){
		jsCode = jsCode.replaceAll(QUOTE, EMPTY).replaceAll(SINGLE_QUOTE, EMPTY);
		if(jsCode.indexOf(LEFT_BRACKET) > 0){
			jsCode = jsCode.substring(0, jsCode.indexOf(LEFT_BRACKET));
		}
		return jsCode;
	}
	
	private HashMap<String,Item> tags=new HashMap<String, Item>();
	
	public synchronized void runJsFunction(WebView webview,String jsCode,JsInterface.OnJsLoadEndListener listener){
		tags.put(removeQuotes(jsCode), new Item(jsCode, listener));
		String js = "javascript:"+HomeJsNamespace+".onJSEnd("+jsCode+",'"+removeQuotes(jsCode)+"')";
		webview.loadUrl(js);
	}
	
	@JavascriptInterface
	public synchronized void onJSEnd(final String value,final String key){
		final Item item=tags.get(key);
		if(item!=null && item.mListener!=null){
			mContext.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					item.mListener.onLoadEnd(item.mJsName,value);
				}
			});
		}
	}
	
	private class Item{
		public Item(String jsName,JsInterface.OnJsLoadEndListener listener){
			mJsName=jsName;
			mListener=listener;
		}
		public String mJsName;
		public JsInterface.OnJsLoadEndListener mListener;
	}
	
}
