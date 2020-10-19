package cn.icanfitness.ican.app.common;

import com.wanzhong.common.util.SysContants;
import com.wanzhong.core.BaseApp;
import com.wanzhong.core.utils.BaseConsts;
import com.wanzhong.data.po.CustomerBasePo;

import cn.icanfitness.ican.app.common.db.DBManager;


public class AppCommon extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        /*if(!AppCommonConfig.isClientTypeValid()){
            CommonUtil.toastUser(getApplicationContext(),"App Client Type is invalid ,check your config.xml");
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    try{
                        sleep(3000);
                    } catch (Exception e){

                    }
                    System.exit(0);
                }
            }.start();
        }*/
        DBManager.getInstance().initDB(this);
    }

    private CustomerBasePo loginUserInfo;
    @Override
    public String getToken() {
        getLoginUserInfo();
        return super.getToken();
    }
    @Override
    public String getUserId(){
        getLoginUserInfo();
        return super.getUserId();
    }

    public CustomerBasePo getLoginUserInfo(){
        if(loginUserInfo == null){
            final Object object = CustomerBasePo.loadFromFile(getApplicationContext(), BaseConsts.Pref.USER_INFO);
            if(object != null){
                loginUserInfo = (CustomerBasePo)object;
            }
        }
        if(loginUserInfo != null){
            mToken = loginUserInfo.getTokenId();
            mUserId = loginUserInfo.getUserId();
        } else {
            mToken = SysContants.CHAR_EMPTY;
            mUserId = SysContants.CHAR_EMPTY;
        }
        return loginUserInfo;
    }
    public void clearLoginUserInfo(){
        if(loginUserInfo != null){
            loginUserInfo.deleteFile(getApplicationContext(),BaseConsts.Pref.USER_INFO);
        }
        loginUserInfo = null;
        mToken = null;
        mUserId = null;
    }

    public void setLogin(CustomerBasePo po){
        if(po != null){
            clearLoginUserInfo();
            po.saveToFile(getApplicationContext(), BaseConsts.Pref.USER_INFO);
            getLoginUserInfo();
        }
    }
    @Override
    public void setLogOut(){

    }
    public void setLogOut(boolean ifJumpToLogin, Class jumpToClass){
        clearLoginUserInfo();
        if(ifJumpToLogin){
            LoginActivity.start(getApplicationContext(),jumpToClass,true);
        }

    }

}
