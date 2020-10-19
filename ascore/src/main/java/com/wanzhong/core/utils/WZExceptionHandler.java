package com.wanzhong.core.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.Process;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WZExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static WZExceptionHandler handler;
    private static Context mContext;

    public WZExceptionHandler() {
    }

    public static WZExceptionHandler getInstence(Context context) {
        mContext = context;
        if(handler == null) {
            handler = new WZExceptionHandler();
        }

        Thread.setDefaultUncaughtExceptionHandler(handler);
        return handler;
    }

    @SuppressLint({"SimpleDateFormat"})
    public void uncaughtException(Thread thread, Throwable ex) {
        try {
            ex.printStackTrace();
            File exception = new File(this.getSDPath() + File.separator +  "wzsaas.log");
            if(!exception.exists()) {
                exception.createNewFile();
            }

            PrintWriter pw = new PrintWriter(new FileOutputStream(exception, true));
            pw.write("--------------------------");
            pw.write((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
            pw.write("-------------------------");
            ex.printStackTrace(pw);
            pw.write("---------------------------------" + CommonUtil.getVersionCode(mContext) + "--------------------------------------");
            pw.close();
        } catch (Exception var5) {
            ex.printStackTrace();
        }

        Process.killProcess(Process.myPid());
        System.exit(10);
    }

    private String getSDPath() {
        return Environment.getExternalStorageDirectory().getPath();
    }
}
