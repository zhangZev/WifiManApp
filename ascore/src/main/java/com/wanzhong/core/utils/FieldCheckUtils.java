package com.wanzhong.core.utils;

import android.text.TextUtils;

import com.wanzhong.common.util.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldCheckUtils {

    /**登录名是否合法*/
    public static boolean isValidLoginId(String filed){
        if(TextUtils.isEmpty(filed)){
            return false;
        }
        return 11 == filed.length();
    }
    /**密码是否合法*/
    public static boolean isValidPassword(String filed){
        if(TextUtils.isEmpty(filed)){
            return false;
        }
        return filed.length() > 5 && filed.length() < 17;
    }

    /**检测手机号*/
    public static boolean isPhoneNum(String phone){
        if(StringUtil.isNullOrSpace(phone)){
            return false;
        }
        String regExp = "^1\\d{10}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phone);
        return m.matches();
    }
    public static Boolean checkLicencePlate(String str){
        return Pattern.compile("^[\\u4e00-\\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$").matcher(str).matches();
    }
}
