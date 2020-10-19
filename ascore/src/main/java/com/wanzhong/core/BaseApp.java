package com.wanzhong.core;


import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Vibrator;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.view.CropImageView;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.core.utils.BadgerUtil;
import com.wanzhong.core.utils.BaseConsts;
import com.wanzhong.core.utils.GlideImageLoader;
import com.wanzhong.core.utils.WZExceptionHandler;

public  class BaseApp extends Application {

	/**屏幕高度*/
	public int mScreenHeight;
	/**屏幕宽度*/
	public int mScreenWidth;

	protected String mToken;
	protected String mUserId;
	private GlideImageLoader mImageLoader;


	/*public BaseApp() {
		super(ShareConstants.TINKER_ENABLE_ALL, "com.wanzhong.core.CoreApplicationLike",
				"com.tencent.tinker.loader.TinkerLoader", false);
	}*/

	@Override
	public void onCreate() {
		super.onCreate();
		try{
			WZExceptionHandler.getInstence(this);
			initGallery();
			initUmeng();
			//initBugly();
		} catch (Exception e){
			e.printStackTrace();
		}
		mBaseApp = this;
	}

	protected  static BaseApp mBaseApp;
	
	public static BaseApp getInstance(){
		if(mBaseApp == null){
			mBaseApp = new BaseApp();
		}
		return mBaseApp;
	}


	public <T>T getBeanFromJson(String ret, Class<T> c){
		T bean = null;
		try{
			bean = new Gson().fromJson(ret,c);
		} catch (Exception e) {
			//format json error
			e.printStackTrace();
		}
		if(bean == null){
			try {
				bean = c.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bean;
	}
	
	/*private String getStartLogCacheFolder(){
		String path = MUtil.getCacheFolder(this) + "startLogo";
		MUtil.createFolder(path);
		return path;
	}*/

	
	public void callPhone(Context context, String phone){
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel://"+phone));
		try{
			context.startActivity(intent);
		} catch(ActivityNotFoundException e){
			
		}
	}
	
	public void callUs(Context context){
		callPhone(context,"10086");
	}
	public void vibrate(){
		Vibrator vibrator = (Vibrator)this.getSystemService(this.VIBRATOR_SERVICE);
		
        vibrator.vibrate(1000);
	}



	public void toast(int strRes){
		toast(getResources().getString(strRes));
	}
	public void toast(String msg){
		//RxBus.get().post(BaseConsts.BusAction.TOAST,msg);
		if(msg == null){
			return;
		}
		Intent intent = new Intent(BaseConsts.Intent.ACTION_TOAST);
		intent.putExtra(BaseConsts.EXT_DATA,msg);
		intent.addCategory(getPackageName());
		intent.setPackage(getPackageName());
		sendOrderedBroadcast(intent,null);
	}
	public void closeActivity(Intent data){
		Intent intent = new Intent(BaseConsts.Intent.ACTION_CLOSE_ACTIVITY);
		intent.putExtra(BaseConsts.EXT_DATA,data);
		intent.addCategory(getPackageName());
		intent.setPackage(getPackageName());
		sendOrderedBroadcast(intent,null);
	}

	public void showLoading(boolean show){
		Intent intent = new Intent(BaseConsts.Intent.ACTION_SHOW_LOADING);
		intent.putExtra(BaseConsts.EXT_DATA,show);
		intent.addCategory(getPackageName());
		intent.setPackage(getPackageName());
		sendOrderedBroadcast(intent,null);
	}

	private void initGallery() {
		mImageLoader = new GlideImageLoader();
		ImagePicker imagePicker = ImagePicker.getInstance();
		imagePicker.setImageLoader(mImageLoader);   //设置图片加载器
		imagePicker.setShowCamera(true);  //显示拍照按钮
		imagePicker.setCrop(false);        //允许裁剪（单选才有效）
		imagePicker.setSaveRectangle(true); //是否按矩形区域保存
		imagePicker.setSelectLimit(9);    //选中数量限制
		imagePicker.setStyle(CropImageView.Style.CIRCLE);  //裁剪框的形状
		imagePicker.setFocusWidth(900);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
		imagePicker.setFocusHeight(180);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
		imagePicker.setOutPutX(900);//保存文件的宽度。单位像素
		imagePicker.setOutPutY(180);//保存文件的高度。单位像素
	}
	private void initUmeng(){
		final String appKey = getResources().getString(R.string.umeng_key);
		if(StringUtil.isNotNullAndSpace(appKey)){
			UMConfigure.init(getApplicationContext(), appKey, "WZ", UMConfigure.DEVICE_TYPE_PHONE, null);
			MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
		}
	}
	/*private void initBugly(){
		final String buglyId = BaseApp.getInstance().getResources().getString(R.string.bugly_id);
		CommonUtil.err("===========bugly_id  "+buglyId);
		if(StringUtil.isNotNullAndSpace(buglyId)) {
			CommonUtil.err("Bugly.init===========  "+buglyId);
			Bugly.init(BaseApp.getInstance().getApplicationContext(), buglyId, BuildConfig.DEBUG);
		}
	}*/

	public void setImg(Context context, ImageView imageView,String path,int defaultImg){
		if(mImageLoader == null){
			initGallery();
		}
		mImageLoader.setImageurl(context,path,imageView,defaultImg);
	}
	public void setImgWithBad(Context context, ImageView imageView,String path,int defaultImg){
		if(mImageLoader == null){
			initGallery();
		}
		mImageLoader.setImageurlWithbad(context,path,imageView,defaultImg);
	}
	public void setImgCircle(Context context, ImageView imageView,String path,int defaultImg){
		if(mImageLoader == null){
			initGallery();
		}
		mImageLoader.setCircleImageurl(context,path,imageView,defaultImg);
	}
	public void setImgRoundedCorners(Context context, ImageView imageView,String path,int defaultImg){
		if(mImageLoader == null){
			initGallery();
		}
		mImageLoader.setRoundedCornersImageurl(context,path,imageView,defaultImg);
	}

	public Bitmap downloadBitmap(Context context,String url,int width,int height){
		if(mImageLoader == null){
			initGallery();
		}
		return mImageLoader.downloadBitmap(context,url,width,height);
	}

	public String getToken(){
	    return mToken;
    }
	public String getUserId(){
		return mUserId;
	}

	public boolean hasLogin(){
		return StringUtil.isNotNullAndSpace(getToken()) && StringUtil.isNotNullAndSpace(getUserId());
	}
	public void setBadge(int count){
        BadgerUtil.addBadger(getApplicationContext(),count);
	}
	public void setLogOut(){};
}
