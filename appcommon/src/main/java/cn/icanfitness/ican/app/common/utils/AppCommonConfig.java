package cn.icanfitness.ican.app.common.utils;

import com.wanzhong.core.BaseApp;

import cn.icanfitness.ican.app.common.R;

public class AppCommonConfig {

    /**用户端*/
    private static final String CLIENT_TYPE_SAAS = "1";
    /**管理员端*/
    private static final String CLIENT_TYPE_ADMIN = "9";

    private static String mClientType;
    public static String getClientType(){
        if(mClientType == null){
            mClientType = BaseApp.getInstance().getApplicationContext().getString(R.string.client_type);
        }
        return mClientType;
    }

    /**返回配置的客户端类型是否合法*/
    public static boolean isClientTypeValid(){
        return CLIENT_TYPE_SAAS.equals(getClientType()) || CLIENT_TYPE_ADMIN.equals(getClientType());
    }

    /**检查客户端类型是否合法，不合法则直接抛异常*/
    public static void checkClientTypeValid() throws Exception {
        if(!isClientTypeValid()){
            throw new Exception("App Client Type is invalid ,check your config.xml");
        }
    }

    /**是不是用户端App*/
    public static boolean isClientSaas(){
        return CLIENT_TYPE_SAAS.equals(getClientType());
    }

    /**是不是管理员端App*/
    public static boolean isClientAdmin(){
        return CLIENT_TYPE_ADMIN.equals(getClientType());
    }


}
