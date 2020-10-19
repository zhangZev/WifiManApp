package com.wanzhong.core.view.webview;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.widget.Scroller;

@SuppressLint("ClickableViewAccessibility")
public class CtWebView extends WebView {
	
	private Scroller mScroller;

	public CtWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public CtWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CtWebView(Context context) {
		super(context);
		init();
	}
	
	private void init(){
		mScroller=new Scroller(getContext(), new DecelerateInterpolator());
	}
	
	private int mScrollY;
	
	private int height=0;

	@Override
	public void computeScroll() {
		
		if (mScroller.computeScrollOffset()) {
			scrollBy(0,mScroller.getCurrY() - mUnboundedScrollY);
			postInvalidate();
		}
		super.computeScroll();
		
		if(mListener==null) return;
		int tempScrollY=getScrollY();
		if(height==0){
			height=getHeight()*3;
		}
		if(mScrollY<height && tempScrollY>height){
			mListener.onChange(true);
		}else if(mScrollY>height && tempScrollY<height){
			mListener.onChange(false);
		}
		mScrollY=getScrollY();
	}

	private static final String bearer = "bearer ";
	@Override
	public void loadUrl(String url) {
		// TODO Auto-generated method stub

		/*Map<String,String> extraHeaders = new HashMap<String, String>();

		extraHeaders.put("Referer", "http://www.google.com");
		if(BaseApp.getInstance().getToken() == null){

		} else {
			Util.err("toek  "+new StringBuffer(bearer).append(App.getInstance().getToken()).toString());
			extraHeaders.put(Consts.Authorization, new StringBuffer(bearer).append(App.getInstance().getToken()).toString());
		}*/
		super.loadUrl(url);
		
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub
		super.reload();
	}

	public void scrollToTop(){
		h.sendEmptyMessage(0);
		//mScroller.startScroll(0,getScrollY(),0,-getScrollY(),600);
		//postInvalidate(); 
	}
	/**
	 * Fix bug,scrollToTop do not work in meizu
	 * */
	Handler h = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			MotionEvent e = null;
			Activity activity  = null;
			if(CtWebView.this.getContext() instanceof Activity){
				activity = (Activity)CtWebView.this.getContext();
			} else {
				mScroller.startScroll(0,getScrollY(),0,-getScrollY(),600);
				postInvalidate();
				return;
			}
			final int x = CtWebView.this.getWidth() / 2;
			final int y = CtWebView.this.getHeight() / 2;
			if(msg.what ==0){
				e = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, x, y, 0);
				activity.dispatchTouchEvent(e);
				h.sendEmptyMessageDelayed(1, 10);
			} else if(msg.what ==1){
				e = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_MOVE, x, y + y / 10, 0);
				activity.dispatchTouchEvent(e);
				h.sendEmptyMessageDelayed(2, 10);
			} else {
				e = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_UP, x, y + y / 10, 0);
				activity.dispatchTouchEvent(e);
				mScroller.startScroll(0,getScrollY(),0,-getScrollY(),600);
				postInvalidate();
			}
		}
	};
	
	private int mUnboundedScrollY;

	@Override
	public void scrollTo(int x, int y) {
		mUnboundedScrollY = y;
		super.scrollTo(x, y);
		
	}
	
	private OnStateChangeTopListener mListener;
	
	public void setOnShowTopListener(OnStateChangeTopListener listener){
		mListener=listener;
	}
	
	public interface OnStateChangeTopListener{
		public void onChange(boolean state);
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		// TODO Auto-generated method stub
		super.onScrollChanged(l, t, oldl, oldt);
	}
	

	
}
