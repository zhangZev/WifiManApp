package com.allenliu.versionchecklib.utils;

import android.os.Environment;

import com.wanzhong.core.BaseApp;

import java.io.File;

public class FileHelper {

	public static String getDownloadApkCachePath() {

		String appCachePath = null;


		if (checkSDCard()) {
			appCachePath = BaseApp.getInstance().getApplicationContext().getExternalCacheDir()/*Environment.getExternalStorageDirectory()*/ + "/AllenVersionPath/" ;
		} else {
			appCachePath = Environment.getDataDirectory().getPath() + "/AllenVersionPath/" ;
		}
		File file = new File(appCachePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		return appCachePath;
	}



	/**
	 *
	 */
	public static boolean checkSDCard() {
		boolean sdCardExist = Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED);

		return sdCardExist;

	}



}