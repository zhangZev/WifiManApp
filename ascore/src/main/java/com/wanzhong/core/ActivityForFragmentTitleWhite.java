package com.wanzhong.core;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.wanzhong.core.utils.BaseConsts;

import androidx.fragment.app.Fragment;

/**
 * 只加载一个Fragment的Activity，只需继承ActivityForFragmentNormal，并重写initFragment()方法即可
 * 或者直接通过Intent传Fragment名
 * Intent intent = new Intent();
    		intent.setClass(this, ActivityForFragmentNormal.class);
    		intent.putExtra("frag", "au.com.luben.clerk.frag.MainFrag");
    		startActivity(intent);
 * */
public class ActivityForFragmentTitleWhite extends ActivityForFragmentNormal{


	@Override
	protected boolean isStatusBarDarkFont() {
		return true;
	}

	@Override
	protected int getThemeId() {
		return R.style.MultiThemeWhite;
	}
	public static void startFrag(Context context, String title, String fragName){
		Intent intent = new Intent(context,ActivityForFragmentTitleWhite.class);
		intent.putExtra("frag",fragName);
		intent.putExtra(BaseConsts.EXT_TITLE,title);
		context.startActivity(intent);
	}

	public static void startFrag(Activity activity, String title, String fragName, int requestCode){
		Intent intent = new Intent(activity,ActivityForFragmentTitleWhite.class);
		intent.putExtra("frag",fragName);
		intent.putExtra(BaseConsts.EXT_TITLE,title);
		activity.startActivityForResult(intent,requestCode);
	}
	public static void startFrag(Fragment fragment, String title, String fragName, int requestCode){
		Intent intent = new Intent(fragment.getContext(),ActivityForFragmentTitleWhite.class);
		intent.putExtra("frag",fragName);
		intent.putExtra(BaseConsts.EXT_TITLE,title);
		fragment.startActivityForResult(intent,requestCode);
	}



}
