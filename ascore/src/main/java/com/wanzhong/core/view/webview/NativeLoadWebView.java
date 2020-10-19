package com.wanzhong.core.view.webview;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class NativeLoadWebView extends LoadWebView {
	public NativeLoadWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public NativeLoadWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public NativeLoadWebView(Context context) {
		super(context);
	}

	@Override
	public void loadUrl(String url, boolean ref) {
		// TODO Auto-generated method stub
		if(ref){
			if(mWebView.getProgress()<100) return;
			lay_loading.setVisibility(View.VISIBLE);
			loading = true;
		}
		mWebView.loadUrl(url);
	}

	@Override
	public void reload() {
		loadwebview_error_layout.setVisibility(View.GONE);
		if(mWebView.getProgress()<100) return;
		lay_loading.setVisibility(View.VISIBLE);
		loading = true;
		mWebView.reload();
	}
	
	
}
