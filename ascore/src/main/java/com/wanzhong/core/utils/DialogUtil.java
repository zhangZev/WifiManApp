package com.wanzhong.core.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.wanzhong.core.dialog.LoadingDialog;

import androidx.appcompat.app.AlertDialog;

public class DialogUtil implements OnClickListener {
	private static DialogUtil mDialogUtil;
	
	private DialogUtil() {}
	
	private static Context mContext;
	
	public static DialogUtil getInstant(Context context){
		if(mDialogUtil==null){
			mDialogUtil=new DialogUtil();
		}
		mContext=context;
		return mDialogUtil;
	}
	
	public Dialog mDialog;
	
	public Dialog waitDialog;
	
	
	/**
	 * 显示等待弹出框
	 */
	public void showWait(){
		try{
			showWait(-1);
		} catch (Exception e){

		}

	}
	public void showWait(int msgID){
		//Log.e("f", "DialogUtil showWait");
//		if(mDialog != null){
//			mDialog.dismiss();
//		}
		if(waitDialog != null && waitDialog.isShowing() ){
			waitDialog.dismiss();
		}
		waitDialog = new LoadingDialog(mContext);
		waitDialog.setCancelable(false);
		tryShowDialog(waitDialog);
		
	}
	
	
	/**
	 * 彈出消息框
	 * @param value
	 */
	TextView tv_toast;
	Toast toast;

	public void showMsg(int stringID){
		showMsg(mContext.getString(stringID));
	}
	public void showMsg(String value) {
		CommonUtil.toastUser(mContext,value);
	}
	
	
	public void dismiss(){
		//Log.e("f", "DialogUtil dismiss");
		if(mDialog!=null && mDialog.isShowing()){
			try {
				mDialog.dismiss();
			} catch (Exception e){

			}
		}

		dismissWait();
	}
	
	public void dismissWait(){
		if(waitDialog!=null && waitDialog.isShowing())
			try{
				waitDialog.dismiss();
			} catch (Exception e){

			}
	}
	
	public boolean isShowing(){
		if(mDialog!=null){
			return mDialog.isShowing();
		}
		return false;
	}
	
	
	

	public AlertDialog alert(Context context, String msg, boolean cancelable){
		AlertDialog dlg = new AlertDialog.Builder(context).setMessage(msg).setCancelable(cancelable).create();
		return dlg;
	};
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	private void tryShowDialog(Dialog dialog){
		try{
			dialog.show();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
}
