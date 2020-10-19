package com.wanzhong.core.utils;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class CtWebChromeClient extends WebChromeClient {

	
	private CtChromeClientListener mCtChromeClientListener;
	public CtWebChromeClient(CtChromeClientListener listener,OpenFileChooserCallBack openFileChooserCallBack){
		mCtChromeClientListener = listener;
		mOpenFileChooserCallBack = openFileChooserCallBack;  
	}
	@Override
	public void onReceivedTitle(WebView view, String title) {
		super.onReceivedTitle(view, title);
		if(mCtChromeClientListener != null){
			mCtChromeClientListener.onReceivedTitle(view, title);
		}
		
	}

	
	public interface CtChromeClientListener {
		public void onReceivedTitle(WebView view, String title);
	}
	
	
	 @Override
     public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
         AlertDialog.Builder b = new AlertDialog.Builder(view.getContext());
         b.setTitle("提示");
         b.setMessage(message);
         b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 result.confirm();
             }
         });
         b.setCancelable(false);
         b.create().show();
         return true;
     }
     //设置响应js 的Confirm()函数
     @Override
     public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
         AlertDialog.Builder b = new AlertDialog.Builder(view.getContext());
         b.setTitle("提示");
         b.setMessage(message);
         b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 result.confirm();
             }
         });
         b.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 result.cancel();
             }
         });
         b.create().show();
         return true;
     }
     
     
     private OpenFileChooserCallBack mOpenFileChooserCallBack;  
     
     

   
   
     //For Android 3.0+  
     public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {  
         mOpenFileChooserCallBack.openFileChooserCallBack(uploadMsg, acceptType);  
     }  
   
   
     // For Android < 3.0  
     public void openFileChooser(ValueCallback<Uri> uploadMsg) {  
         openFileChooser(uploadMsg, "");  
     }  
   
   
     // For Android  > 4.1.1  
     public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {  
         openFileChooser(uploadMsg, acceptType);  
     }  
   
   
     // For Android 5.0+  
     @Override  
     public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {  
         mOpenFileChooserCallBack.showFileChooserCallBack(filePathCallback);  
         return true;  
     }  
   
   
     public interface OpenFileChooserCallBack {  
         void openFileChooserCallBack(ValueCallback<Uri> uploadMsg, String acceptType);  
   
   
         void showFileChooserCallBack(ValueCallback<Uri[]> filePathCallback);  
     }  
   
   
}
