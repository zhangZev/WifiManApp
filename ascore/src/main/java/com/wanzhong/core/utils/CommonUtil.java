package com.wanzhong.core.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.wanzhong.core.BaseApp;
import com.wanzhong.core.BuildConfig;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;


public class CommonUtil {

    public static void Call(Activity a, String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        a.startActivity(intent);
    }

    public static String md5(String key) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md5.update(key.getBytes());
        //important: use Base64.URL_SAFE flag to avoid "+" and "/"
        return new String(Base64.encode(md5.digest(), Base64.URL_SAFE));
    }

    private static float sDensity = 0;

    public static int dipToPixel( int nDip) {
        if (sDensity == 0) {
            final WindowManager wm = (WindowManager) BaseApp.getInstance()
                    .getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics dm = new DisplayMetrics();
            wm.getDefaultDisplay().getMetrics(dm);
            sDensity = dm.density;
        }
        return (int) (sDensity * nDip);
    }


    public static int pixelToDip( int px) {
        if (sDensity == 0) {
            final WindowManager wm = (WindowManager) BaseApp.getInstance()
                    .getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics dm = new DisplayMetrics();
            wm.getDefaultDisplay().getMetrics(dm);
            sDensity = dm.density;
        }
        return (int) (px/sDensity );
    }

    public static BitmapFactory.Options getBitmapOpt(String path) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        //设置为true,表示解析Bitmap对象，该对象不占内存
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(path, options);
        return  options;
    }

    /**
     * 不同的类型要区别获取，以下是String类型的
     * @param context  上下午
     * @param metaName  meta-data定义的名字
     * @param defaultValue  默认值
     * @return
     */
    public static String getAppMetaDataString(Context context, String metaName, String defaultValue) {
        try {
            //BaseApplication标签下用getApplicationinfo，如果是activity下的用getActivityInfo
            //Sting类型的用getString，Boolean类型的getBoolean，其他具体看api
            String value = context.getPackageManager()
                    .getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA)
                    .metaData.getString(metaName, defaultValue);
            return value;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return defaultValue;
        }
    }
    /**
     * 取得当前版本号
     *
     * @return
     */
    public static int getVersionCode(Context context) {

        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return 0;
    }

    /*public static String getUrl(Context context, String url){
        if(TextUtils.isEmpty(url)){
            return url;
        }

        String pass= BaseApp.getInstance().getToken();
        if(!TextUtils.isEmpty(pass)){
            String BaseAppendInfo= "token="+pass;
            if(!url.contains("?")){
                url+="?"+BaseAppendInfo;
            }if(!url.endsWith("&"+BaseAppendInfo) && !url.endsWith("?"+BaseAppendInfo)){
                url+="&"+BaseAppendInfo;
            }
        }
        return url;
    }*/



    /**

     * 从assets中读取txt

     */

    public static String readFromAssets(Context context, String fileName) {
        String content = null;
        try {

            InputStream is = context.getAssets().open(fileName);

            content = readTextFromSDcard(is);


        } catch (Exception e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }
        return content;

    }


    /**

     * 从raw中读取txt

     */

    public static String readFromRaw(Context context, int rawId) {
        String content = null;
        try {

            InputStream is = context.getResources().openRawResource(rawId);

            content = readTextFromSDcard(is);

        } catch (Exception e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }
        return content;

    }


    /**

     * 按行读取txt

     *

     * @param is

     * @return

     * @throws Exception

     */
    public static String readTextFromSDcard(InputStream is) throws Exception {

        InputStreamReader reader = new InputStreamReader(is);

        BufferedReader bufferedReader = new BufferedReader(reader);

        StringBuffer buffer = new StringBuffer("");

        String str;

        while ((str = bufferedReader.readLine()) != null) {

            buffer.append(str);

            buffer.append("\n");

        }

        return buffer.toString();

    }



    public static void toastUser(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void toastUser(Context context, int msgID){
        Toast.makeText(context, context.getString(msgID), Toast.LENGTH_LONG).show();
    }

    private static final String DEBUG = "debug";
    private static final String LOG_TAG = "WZ";
    public static void err(String msg){

        log(LOG_TAG, msg);
		/*if(BuildConfig.DEBUG){

		}*/
    }
    public static void log(String tag , String msg){
        if(DEBUG.equals(BuildConfig.BUILD_TYPE)){
            Log.e(tag, msg);
        }
    }

    @SuppressLint("MissingPermission")
    public static String getDeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId()==null?"":tm.getDeviceId();
    }

    public static String getVersionName(Context context){
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packInfo.versionName;
        } catch (Exception ex) {
            return "";
        }
    }
    @SuppressWarnings("deprecation")
    public static String getAndroidId(Context context){
        String ANDROID_ID = Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID);
        return ANDROID_ID;
    }

    public static String isPackageInstalled(String packagename, Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo info=pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    public static Map<String,String> getQueryOfUrl(URL url){
        if(url == null || TextUtils.isEmpty(url.getQuery())){
            return null;
        }
        Map<String,String> map = new HashMap<String, String>();
        String[] kvs = url.getQuery().split("&");
        for (int i = 0; i < kvs.length; i++) {
            String[] kv = kvs[i].split("=");
            if(kv.length == 2 && !TextUtils.isEmpty(kv[0]) && !TextUtils.isEmpty(kv[1])){
                map.put(kv[0], kv[1]);
            }
        }
        return map;
    }
    public static String queryToUrlString(Map<String,String> map){
        if(map == null || map.isEmpty()){
            return "";
        }
        Set<String> keys = map.keySet();
        Iterator<String> it = keys.iterator();
        StringBuilder sb = new StringBuilder();
        boolean isfirst = true;
        while(it.hasNext()){
            String key = it.next();
            String value = map.get(key);

            if(isfirst){
                isfirst = false;
            } else {
                sb.append("&");
            }

            sb.append(key);
            sb.append("=");
            sb.append(value);
        }
        return sb.toString();
    }

    public static String getUrlRemoveQuery(String url){
        if(TextUtils.isEmpty(url)){
            return url;
        }
        return url.split("\\?")[0];
    }

    public static String setUrlAssignQueryValue(String urlstr, String key, String value){
        try {
            URL url = new URL(urlstr);
            String urlnew = url.getProtocol() + "://" + url.getHost();
            if(url.getPort() >= 0){
                urlnew += ":" + url.getPort();
            }

            String path = url.getPath();
            if(!path.startsWith("/")){
                urlnew += "/";
            }
            urlnew += path;
            Map<String,String> query = getQueryOfUrl(url);
            if(query != null){
                query.put(key, value);
            }
            String querystr = queryToUrlString(query);
            if(!TextUtils.isEmpty(querystr)){
                urlnew += "?" + querystr;
            }

            return urlnew;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return urlstr;
    }

    public static void installAPK(Context context, File file) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),"application/vnd.android.package-archive");
        context.startActivity(intent);
    }

//	public static boolean isNetConnected(Context context) {
//        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        if (cm != null) {
//            NetworkInfo[] infos = cm.getAllNetworkInfo();
//            if (infos != null) {
//                for (NetworkInfo ni : infos) {
//                    if (ni.isConnected()) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }

    @SuppressLint("SimpleDateFormat")
    public static String currentMillionSecondToString(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd.HH.mm.ss");
        return df.format(new Date());
    }







    public static boolean isYesterday(Calendar cal){
        Calendar nowzero = Calendar.getInstance();
        nowzero.set(Calendar.HOUR_OF_DAY, 0);
        nowzero.set(Calendar.MINUTE, 0);
        nowzero.set(Calendar.SECOND, 0);
        nowzero.set(Calendar.MILLISECOND, 0);
        long timeinmill = cal.getTimeInMillis();
        if(timeinmill < nowzero.getTimeInMillis() && timeinmill >= nowzero.getTimeInMillis() - 24 * 60 * 60 *1000){
            return true;
        }
        return false;
    }

    public static boolean isToday(Calendar cal){
        Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        long timeinmill = cal.getTimeInMillis();
        if(timeinmill > now.getTimeInMillis() && timeinmill < now.getTimeInMillis() + 24 * 60 * 60 *1000){
            return true;
        }
        return false;
    }
    //	D	day in year	(Number)	189
//	E	day of week	(Text)	E/EE/EEE:Tue, EEEE:Tuesday, EEEEE:T
//	F	day of week in month	(Number)	2 (2nd Wed in July)
//	G	era designator	(Text)	AD
//	H	hour in day (0-23)	(Number)	0
//	K	hour in am/pm (0-11)	(Number)	0
//	L	stand-alone month	(Text)	L:1 LL:01 LLL:Jan LLLL:January LLLLL:J
//	M	month in year	(Text)	M:1 MM:01 MMM:Jan MMMM:January MMMMM:J
//	S	fractional seconds	(Number)	978
//	W	week in month	(Number)	2
//	Z	time zone (RFC 822)	(Time Zone)	Z/ZZ/ZZZ:-0800 ZZZZ:GMT-08:00 ZZZZZ:-08:00
//	a	am/pm marker	(Text)	PM
//	c	stand-alone day of week	(Text)	c/cc/ccc:Tue, cccc:Tuesday, ccccc:T
//	d	day in month	(Number)	10
//	h	hour in am/pm (1-12)	(Number)	12
//	k	hour in day (1-24)	(Number)	24
//	m	minute in hour	(Number)	30
//	s	second in minute	(Number)	55
//	w	week in year	(Number)	27
//	y	year	(Number)	yy:10 y/yyy/yyyy:2010
//	z	time zone	(Time Zone)	z/zz/zzz:PST zzzz:Pacific Standard Time
//	'	escape for text	(Delimiter)	'Date=':Date=
//	''	single quote	(Literal)	'o''clock':o'clock
    @SuppressLint("SimpleDateFormat")
    public static String getTimeString(Calendar cal, String dateformat) {
        Date now = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);
        String str = dateFormat.format(now);
        return str;
    }

    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }


    /**
     * input "abc$$1dfa$$2898", "rrr","bbb"
     * output "abcrrrdfabbb898"
     * */
    public static String formatOutputStr(Context context, int resid, String...args){
        String str = context.getString(resid);
        str = formatOutputStr(str, args);
        return str;
    }

    public static String formatOutputStr(String str, String...args){
        int len = args.length;
        int j = 1;
        for (int i = 0; i < len; i++,j++) {
            str = str.replace("$$" + j , args[i]);
        }
        return str;
    }

    public static File getDataSaveDir(Context context){
        File dir = context.getDir("yydb", Context.MODE_PRIVATE);
        if(!dir.exists()){
            dir.mkdirs();
        }
        return dir;
    }
    public static String fenToYuan(int fen) {
        double yuan = (double) fen;
        yuan = yuan / 100;
        if (Math.round(yuan) - yuan == 0) {
            return String.valueOf((long) yuan);
        }
        return String.valueOf(yuan);
    }

    public static byte[] bmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output);
        if (needRecycle) {
            bmp.recycle();
        }

        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static final File appMiddleDir(Context context){
        if(!TextUtils.equals(Environment.getExternalStorageState(), Environment.MEDIA_MOUNTED) ){
            return null;
        }
        File dir = new File(Environment.getExternalStorageDirectory(), "yunhuiyy");
        if(!dir.exists()){
            dir.mkdirs();
        }
        return dir;
    }

    public static final File appDataDir(Context context){
        File dir = context.getDir("yunhuiyy", Context.MODE_PRIVATE);
        //File dir = new File(Environment.getExternalStorageDirectory(), "yunhuiyy");
        if(!dir.exists()){
            dir.mkdirs();
        }
        return dir;
    }


    public static String getUidFromPassPort(String passport){
        if(TextUtils.isEmpty(passport) || passport.indexOf(".") <= 0){
            return "";
        }
        return passport.substring(0,passport.indexOf("."));
    }





    @SuppressWarnings("deprecation")
    public static boolean copyToClipBoard(Context context, String text){
        ClipboardManager cmb = (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
        cmb.setText(text);
        return true;
    }

    public static String getMetaValue(Context context, String metaKey) {
        Bundle metaData = null;
        String apiKey = null;
        if (context == null || metaKey == null) {
            return null;
        }
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            if (null != ai) {
                metaData = ai.metaData;
            }
            if (null != metaData) {
                apiKey = metaData.getString(metaKey);
            }
        } catch (PackageManager.NameNotFoundException e) {

        }
        return apiKey;
    }


    /**
     *  利用java原生的摘要实现SHA256加密
     * @param str 加密后的报文
     * @return
     */
    public static String getSHA256StrJava(String str){
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    /**
     * 将byte转为16进制
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i=0;i<bytes.length;i++){
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length()==1){
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    public static boolean isWellFormedPwd(String pwd){
        return  pwd != null && pwd.length() >= 6 && pwd.length() <= 16;
    }
    public static boolean isPhoneNum(String phone){
        return phone != null && phone.length() == 11;

    }

    //2018-09-03 11:30:02.0
    public static Date getServerTime(String serverTime, String format){
        serverTime = serverTime.substring(0,serverTime.indexOf("."));
        if (format == null || format.isEmpty()) {
            //2018-07-18 16:27:36
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINESE);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        Date date = null;
        try {
            date = sdf.parse(serverTime);

        } catch (Exception e) {
        }
        return date;
    }
    public static String getDatePoor(String endStr, String startStr){
        if(endStr == null || startStr == null){
            return "";
        }
        return getDatePoor(getServerTime(endStr,null),getServerTime(startStr,null));
    }
    public static String getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        StringBuilder sb = new StringBuilder();
        boolean show = false;
        if(day > 0){
            sb.append(day).append("天");
            show = true;
        }
        if(hour > 0 || show){
            sb.append(hour).append("小时");
            show = true;
        }
        if(min > 0 || show){
            sb.append(min).append("分");
        }
        if(sec > 0){
            sb.append(sec).append("秒");
        }
        return sb.toString();
    }


    /**
     * 保留两位小数
     * @param value
     * @return
     */
    public static String getDecimalForTHree(double value) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.0000");
        if (value == 0) {
            return "0.00";
        } else if (value < 1) {
            return "0" + df.format(value);
        } else {
            return df.format(value);
        }
    }

    /**
     * 使用用户格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期格式
     * @return 提取字符串日期
     */
    public static String parseToYMD(String strDate, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            if(TextUtils.isEmpty(strDate)){
                return "";
            }
            return df.format(df.parse(strDate));
        } catch (ParseException e) {
            e.printStackTrace();
            return "---";
        }
    }
    public static String getUrl(Context context,String url){
        return url;
    }
    public static String spliteMMDD(String strDate){
        if(TextUtils.isEmpty(strDate)){
            return "--";
        }
        return strDate.substring(5,10);
    }

}


