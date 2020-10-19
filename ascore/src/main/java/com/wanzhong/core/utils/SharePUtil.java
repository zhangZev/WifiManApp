package com.wanzhong.core.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @time:{2020/9/11}
 * @auhor:{ZhangXW}
 */
public class SharePUtil {

    public static final String LANGUAGE = "language";
    public static final String TOKEN = "TOKEN_ID";
    public static final String ASWAP_PWD = "ASWAP_PWD";
    public static final String WMNEMONICS = "mnemonics";
    public static final String WPRIVATEKEY = "privateKey";
    public static final String WADDRESS = "address";
    public static final String ACTIVE = "active";
    public static final int WALLET_NET = 2;//1正式、2测试
    private static final String SP_NAME = "poemTripSpref";
    private static SharePUtil spUtil;
    private static SharedPreferences hmSpref;
    private static SharedPreferences.Editor editor;

    private SharePUtil(Context context) {
        hmSpref = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = hmSpref.edit();
    }

    public static SharePUtil getInstance(Context context) {
        if (spUtil == null) {
            synchronized (SharePUtil.class) {
                if (spUtil == null) {
                    spUtil = new SharePUtil(context);
                }
            }
        }
        return spUtil;
    }

    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public String getString(String key) {
        return hmSpref.getString(key, "");
    }

    public Boolean getBoolean(String key) {
        return hmSpref.getBoolean(key, false);
    }


    public void clearAllData() {
        putString(ASWAP_PWD, "");
        putString(WMNEMONICS, "");
        putString(WPRIVATEKEY, "");
        putString(WADDRESS, "");
        putString(LANGUAGE, "");
    }
}