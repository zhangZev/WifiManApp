package com.wanzhong.core.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PatchUtil {


    /**
     *
     * @Description 将app由data/app目录拷贝到sd卡下的指定目录中
     *
     * @param packageName
     *            应用程序的ID号，如com.wondertek.jttxl
     *
     * @param dest
     *            需要将应用程序拷贝的目标位置
     *
     * @date 2013-7-24 下午3:32:12
     */
    public static String backupApplication(Context context, String packageName, String dest) {
        if (packageName == null || packageName.length() == 0 || dest == null || dest.length() == 0) {
            return "illegal parameters";
        }

        String oldApk = null;
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(packageName, 0);
            oldApk = info.applicationInfo.publicSourceDir;
        } catch (PackageManager.NameNotFoundException e1) {
            e1.printStackTrace();
            return packageName + "doesn't exist!";
        }
        File apkFile = new File(oldApk);
        if (!apkFile.exists()) {
            return oldApk + " doesn't exist!";
        }
        FileInputStream in = null;
        try {
            in = new FileInputStream(apkFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        int i = dest.lastIndexOf('/');
        if (i != -1) {
            File dirs = new File(dest.substring(0, i));
            dirs.mkdirs();
            dirs = null;
        }
        byte[] c = new byte[1024];
        int slen;
        FileOutputStream out = null;
        try {
            File file = new File(dest);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            out = new FileOutputStream(dest);
            while ((slen = in.read(c, 0, c.length)) != -1)
                out.write(c, 0, slen);
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        } finally {
            if (out != null)
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return e.getMessage();
                }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return e.getMessage();
                }
            }
        }
        return "success";

    }


    /**
     * 将补丁包合成更新包
     *
     * @param patch
     *            补丁包路径
     * @return 合成的更新包路径，与补丁包同目录
     */
    public static File createByPatch(Context context, String patch, String pkg) {
        File patchfile = new File(patch);
        if(!patchfile.exists()){
            return null;
        }
        String result = backupApplication(context, pkg,
                patchfile.getParent() + "/old.apk");
        if ("success".equals(result)) {

            try {
                int re = patch(patchfile.getParent() + "/old.apk",
                        patchfile.getParent() + "/new.apk", patch);
                File f = new File(patchfile.getParent() + "/old.apk");
                if (f.exists())
                    f.delete();
                if (re == 0) {
                    return new File(patchfile.getParent() + "/new.apk");
                }
            } catch (Exception e) {
                CommonUtil.err("e  "+e.getMessage());
                e.printStackTrace();
            }
        }
        //差分包生成失败过，以后都走全包更新
        SPUtil.getInstant(context).save(BaseConsts.Pref.PATCH_NEVER_FAILED,false);
        return null;
    }

    private static String getsdpath(){
        return Environment.getExternalStorageDirectory().getPath()+ File.separator;
    }
    //生成差分包
    public native int diff(String oldpath,String newpath,String patch);
    //旧apk和差分包合并
    public static native int patch(String oldpath,String newpath,String patch);
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
