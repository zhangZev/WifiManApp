package com.wanzhong.data.utils;

import android.content.Context;

import com.wanzhong.common.util.StringUtil;
import com.wanzhong.data.R;

public class NetUtils {
    private static String mBaseUrl;
    private NetUtils(){};
    private static NetUtils mNetUtils;
    public static NetUtils getInstance(){
        if(mNetUtils == null){
            mNetUtils = new NetUtils();
        }
        return mNetUtils;
    }

    public String getWebPath(Context context,String path){
        if(StringUtil.isNullOrSpace(mBaseUrl)){
            mBaseUrl = context.getResources().getString(R.string.web_base_url);
        }
        return new StringBuffer(mBaseUrl).append(path).toString();
    }
}
