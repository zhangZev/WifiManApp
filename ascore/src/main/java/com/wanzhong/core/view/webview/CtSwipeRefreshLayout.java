package com.wanzhong.core.view.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

@SuppressLint({ "ClickableViewAccessibility", "NewApi" })
public class CtSwipeRefreshLayout extends SwipeRefreshLayout {

	public CtSwipeRefreshLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CtSwipeRefreshLayout(Context context) {
		super(context);
	}

/*	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if(!mRef) return false;
		boolean value= super.onInterceptTouchEvent(ev);
		if(value){
			MotionEvent event=MotionEvent.obtain(ev);
			event.setAction(MotionEvent.ACTION_UP);
			mWebView.onTouchEvent(event);
		}
		return value;
	}
	
	public WebView mWebView;
	
	public void setWebView(WebView webView){
		mWebView=webView;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		if(null!=mWebView){
			if(mWebView.getScrollY()> 1){
				//直接截断时间传播
				return false;
			}else{
				return super.onTouchEvent(arg0);
			}
		}
		return super.onTouchEvent(arg0);
	}*/
	
	boolean mRef=false;
	
	public void setRef(boolean ref){
		mRef=ref;
		this.setEnabled(ref);
	}

}
