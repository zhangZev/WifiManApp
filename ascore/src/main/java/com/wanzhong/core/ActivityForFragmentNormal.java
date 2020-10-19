package com.wanzhong.core;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.wanzhong.core.utils.BaseConsts;
import com.wanzhong.core.utils.CommonUtil;

import androidx.fragment.app.Fragment;

/**
 * 只加载一个Fragment的Activity，只需继承ActivityForFragmentNormal，并重写initFragment()方法即可
 * 或者直接通过Intent传Fragment名
 * Intent intent = new Intent();
    		intent.setClass(this, ActivityForFragmentNormal.class);
    		intent.putExtra("frag", "au.com.luben.clerk.frag.MainFrag");
    		startActivity(intent);
 * */
public class ActivityForFragmentNormal extends CoreBaseActivity{

	Fragment mFragment;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		this.setContentView(R.layout.activity_for_fragment_normal);
		initViews();
	}
	@Override
	protected boolean isStatusBarDarkFont() {
		return false;
	}

	@Override
	protected int getThemeId() {
		return R.style.MultiThemeMain;
	}

	private void initViews(){
		mFragment = initFragment();
		if(mFragment == null){
			CommonUtil.toastUser(this, R.string.frag_init_failed);
			finish();
			return;
		}
		if(this.getIntent() != null && this.getIntent().getExtras() != null){
			mFragment.setArguments(this.getIntent().getExtras());
		}		
		this.getSupportFragmentManager().beginTransaction().add(R.id.main_container, mFragment).commit();
	}
	public static void startFrag(Context context, String title, String fragName){
		Intent intent = new Intent(context,ActivityForFragmentNormal.class);
		intent.putExtra("frag",fragName);
		intent.putExtra(BaseConsts.EXT_TITLE,title);
		context.startActivity(intent);
	}

	public static void startFrag(Activity activity, String title, String fragName, int requestCode){
		Intent intent = new Intent(activity,ActivityForFragmentNormal.class);
		intent.putExtra("frag",fragName);
		intent.putExtra(BaseConsts.EXT_TITLE,title);
		activity.startActivityForResult(intent,requestCode);
	}
	public static void startFrag(Fragment fragment, String title, String fragName, int requestCode){
		Intent intent = new Intent(fragment.getContext(),ActivityForFragmentNormal.class);
		intent.putExtra("frag",fragName);
		intent.putExtra(BaseConsts.EXT_TITLE,title);
		fragment.startActivityForResult(intent,requestCode);
	}
	
	public Fragment initFragment(){
		if(this.getIntent() != null && this.getIntent().getExtras() != null && getIntent().hasExtra("frag")){
			final String clsName = (String)getIntent().getStringExtra("frag");
			try{
    			final Class cls = Class.forName(clsName);
    			final Fragment frag = (Fragment )cls.newInstance();
        		return frag;
    		} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	


	
	
	


	
	

}
