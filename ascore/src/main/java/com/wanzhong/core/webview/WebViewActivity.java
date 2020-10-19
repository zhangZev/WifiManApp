package com.wanzhong.core.webview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;

import com.wanzhong.core.ActivityForFragmentTitleWhite;
import com.wanzhong.core.frag.BaseWebFragment;
import com.wanzhong.core.frag.NativeWebFragment;
import com.wanzhong.core.frag.WebFragment;
import com.wanzhong.core.utils.JsInterface;

import java.lang.reflect.Field;

import androidx.fragment.app.Fragment;


/**
 * 通用加载WebView的Activity
 * */
public class WebViewActivity extends ActivityForFragmentTitleWhite {

	protected BaseWebFragment mFragment;
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setConfigCallback((WindowManager)getApplicationContext().getSystemService(Context.WINDOW_SERVICE));
	}
	public static void start(Context context,String title,String url){
		start(context,title,url,false);
	}
	public static void start(Fragment fragment, String title, String url){
		start(fragment,title,url,false);
	}
	public static void start(Fragment fragment,String title,String url,boolean nativeWeb){
		Intent intent = new Intent(fragment.getContext(),WebViewActivity.class);
		if(title != null){
			intent.putExtra(JsInterface.EXT_TITLE,title);
		}
		if(url != null){
			intent.putExtra(JsInterface.EXT_URL,url);
		}
		intent.putExtra(JsInterface.EXT_NATIVE_WEB,nativeWeb);
		fragment.startActivityForResult(intent, JsInterface.JSINTERFACE_REQUEST);
	}
	public static void start(Context context,String title,String url,boolean nativeWeb){
		Intent intent = new Intent(context,WebViewActivity.class);
		if(title != null){
			intent.putExtra(JsInterface.EXT_TITLE,title);
		}
		if(url != null){
			intent.putExtra(JsInterface.EXT_URL,url);
		}
		intent.putExtra(JsInterface.EXT_NATIVE_WEB,nativeWeb);
		context.startActivity(intent);
	}



	@Override
	public Fragment initFragment() {
		// TODO Auto-generated method stub
		if(this.getIntent() != null && this.getIntent().getBooleanExtra(JsInterface.EXT_NATIVE_WEB, false)){
			mFragment = new NativeWebFragment();
		} else {
			mFragment = new WebFragment();
		}

		if(this.getIntent() != null && this.getIntent().getExtras() != null){
			mFragment.setArguments(this.getIntent().getExtras());
		}
		return mFragment;
	}


/*	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if(mFragment != null && mFragment.getJsInterface() != null){
			if(!mFragment.getJsInterface().handleBackAction()){
				super.onBackPressed();
			}
		}
	} */
	
	
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		setConfigCallback(null);
	}


	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		if(mFragment != null){
			mFragment.onNewIntent(intent);
		}
	}
	
	/**
	 * 强制释放webview的引用，从而能释放内存
	 * 4.0会导致crash，暂不用
	 * */
	public void setConfigCallback(WindowManager windowManager) {
		if(true){
			return;
		}
	    try {
	        Field field = WebView.class.getDeclaredField("mWebViewCore");
	        field = field.getType().getDeclaredField("mBrowserFrame");
	        field = field.getType().getDeclaredField("sConfigCallback");
	        field.setAccessible(true);
	        Object configCallback = field.get(null);
	 
	        if (null == configCallback) {
	            return;
	        }
	 
	        field = field.getType().getDeclaredField("mWindowManager");
	        field.setAccessible(true);
	        field.set(configCallback, windowManager);
	    } catch(Exception e) {
	    }
	}

	@Override
	public void onBackPressed() {
		//super.onBackPressed();
		mFragment.onBackPressed();
	}
}
