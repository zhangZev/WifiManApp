package com.wanzhong.core.view.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wanzhong.core.R;
import com.wanzhong.core.utils.CommonUtil;

import java.lang.reflect.Field;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


@SuppressLint("ClickableViewAccessibility")
public class LoadWebView extends RelativeLayout implements OnClickListener, SwipeRefreshLayout.OnRefreshListener {
	
	public CtWebView mWebView;
	LinearLayout lay_loading;
	
	private CtSwipeRefreshLayout swipeRefreshLayout;
	
	View loadwebview_error_layout;
	
	TextView loadwebview_tv_error;
	
	boolean loading;
	
	public boolean isLoading(){
		return loading;
	}

	public LoadWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public LoadWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public LoadWebView(Context context) {
		super(context);
		init();
	}
	
	@SuppressLint({ "NewApi", "SetJavaScriptEnabled" })
	private void init(){
		final int layoutId = R.layout.loadwebview;
		View view=LayoutInflater.from(getContext()).inflate(layoutId,null);
		addView(view,new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		mWebView=(CtWebView) view.findViewById(R.id.loadwebview_wb);
		swipeRefreshLayout=(CtSwipeRefreshLayout) view.findViewById(R.id.loadwebview_swipe_ly);
		//initWebView();
		if(android.os.Build.VERSION.SDK_INT >= 11){
			mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		}
		swipeRefreshLayout.setOnRefreshListener(this);
		
		lay_loading=(LinearLayout) view.findViewById(R.id.loadwebview_lay_loading);
		loadwebview_error_layout = view.findViewById(R.id.loadwebview_error_layout);
		loadwebview_error_layout.setOnClickListener(this);
		//view.findViewById(ThemeUtil.getRemoteId(this.getContext(), "loadwebview_btn_error_refresh", ThemeUtil.RESOURCES_TYPE_ID, R.id.loadwebview_btn_error_refresh)).setOnClickListener(this);
		loadwebview_tv_error = (TextView) view.findViewById(R.id.loadwebview_tv_error);
		
//		try{
//			change();
//		}catch(Exception ex){
//			
//		}
		
//		swipeRefreshLayout.setWebView(mWebView);
		getSettings().setJavaScriptEnabled(true);
		getSettings().setDomStorageEnabled(true);
		getSettings().setLoadWithOverviewMode(true);
		getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		//此方法不支持4.4以后
		getSettings().setUseWideViewPort(true);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
		}

		//final String ua = getSettings().getUserAgentString();
		//getSettings().setUserAgentString(ua+"-BJSF");
		
	}

	
	private void initWebView(){
		mWebView = new CtWebView(this.getContext());
		//mWebView.setScrollBarSize(0);
		mWebView.setScrollBarStyle(WebView.SCROLLBARS_INSIDE_OVERLAY);
		mWebView.setVerticalScrollBarEnabled(false);
		final ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		swipeRefreshLayout.addView(mWebView,params);
		
	}
	public WebSettings getSettings(){
		return mWebView.getSettings();
	}
	
	@SuppressLint("NewApi")
	private void change(){
		ViewTreeObserver vto = swipeRefreshLayout.getViewTreeObserver();
		vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
		    public void onGlobalLayout() {

		        final DisplayMetrics metrics = getResources().getDisplayMetrics();
		        Float mDistanceToTriggerSync = Math.min(((View) swipeRefreshLayout.getParent()).getHeight() * 0.4f, 500 * metrics.density);
		        try {
		            Field field = SwipeRefreshLayout.class.getDeclaredField("mDistanceToTriggerSync");
		            field.setAccessible(true);
		            field.setFloat(swipeRefreshLayout, mDistanceToTriggerSync);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }

		        ViewTreeObserver obs = swipeRefreshLayout.getViewTreeObserver();
		        obs.removeOnGlobalLayoutListener(this);
		    }
		});

	}
	
	public void setWebViewClient(WebViewClient client){
		mWebView.setWebViewClient(client);
	}
	
	public void setWebChromeClient(WebChromeClient client){
		mWebView.setWebChromeClient(client);
	}

	public void addJavascriptInterface(Object object, String name){
		mWebView.addJavascriptInterface(object, name);
	}
	
	public void scrollTop(){
		mWebView.scrollToTop();
	}
	
	public boolean canGoBack(){
		return mWebView.canGoBack();
	}
	
	public void goBack(){
		mWebView.goBack();
	}
	
	public void setOnShowTopListener(CtWebView.OnStateChangeTopListener listener){
		mWebView.setOnShowTopListener(listener);
	}
	
	public void hiddenLoading(){
		swipeRefreshLayout.setRefreshing(false);  
		postDelayed(new Runnable() {
			
			@Override
			public void run() {
				lay_loading.setVisibility(View.GONE);
				loading = false;
			}
		},20);
	}
	
	public void showError(String value){
		mWebView.stopLoading();
		loadwebview_error_layout.setVisibility(View.VISIBLE);
		loadwebview_tv_error.setBackgroundResource(R.drawable.loadwebview_error_tv_bg);
		//loadwebview_tv_error.setText(value);
	}
	
	public void showNoNetWork(String value){
		mWebView.stopLoading();
		loadwebview_error_layout.setVisibility(View.VISIBLE);
		loadwebview_tv_error.setBackgroundResource(R.drawable.loadwebview_error_no_net_bg);
		//loadwebview_tv_error.setText(value);
	}
	@SuppressLint("NewApi")
	public void loadUrl(String url,boolean ref){
		if(ref){
			if(mWebView.getProgress()<100) return;
			lay_loading.setVisibility(View.VISIBLE);
			loading = true;
		}
		final String turl= CommonUtil.getUrl(getContext(), url);
		mWebView.loadUrl(turl);
	}
	
	public void reload(){
		loadwebview_error_layout.setVisibility(View.GONE);
		if(mWebView.getProgress()<100) return;
		lay_loading.setVisibility(View.VISIBLE);
		loading = true;
		final String turl=CommonUtil.getUrl(getContext(), mWebView.getUrl());
		mWebView.loadUrl(turl);
	}

	@Override
	public void onClick(View v) {
		reload();
	}
	
	public void setRef(boolean ref){
		swipeRefreshLayout.setRef(ref);
	}
	
	@Override
	public void onRefresh() {
		reload();
	}
}
