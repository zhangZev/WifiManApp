package com.wanzhong.core.utils;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;

public class NativeWebViewClient extends CtWebViewClient {

	private static final String HTTP = "http";
	private static final String HTTPS = "https";
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		if(url == null){
			return false;
		}
		
		final Uri uri = Uri.parse(url);
		final String scheme = uri.getScheme();
		if(HTTP.equalsIgnoreCase(scheme) || HTTPS.equalsIgnoreCase(scheme)){
			//view.loadUrl(url);
			return false;
		} else {
			Intent intent = new Intent(Intent.ACTION_VIEW,uri);
			try{
				view.getContext().startActivity(intent);
			} catch(ActivityNotFoundException e){
				
			}
		}
		return true;
	}

	
}
