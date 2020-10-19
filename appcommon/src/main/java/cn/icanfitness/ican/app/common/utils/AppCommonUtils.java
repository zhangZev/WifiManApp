package cn.icanfitness.ican.app.common.utils;

import android.content.Intent;

import com.allenliu.versionchecklib.core.AVersionService;
import com.allenliu.versionchecklib.core.AllenChecker;
import com.allenliu.versionchecklib.core.VersionDialogActivity;
import com.allenliu.versionchecklib.core.VersionParams;
import com.allenliu.versionchecklib.v2.AllenVersionChecker;
import com.allenliu.versionchecklib.v2.builder.DownloadBuilder;
import com.allenliu.versionchecklib.v2.builder.UIData;
import com.allenliu.versionchecklib.v2.callback.ForceUpdateListener;
import com.allenliu.versionchecklib.v2.callback.RequestVersionListener;
import com.wanzhong.core.BaseApp;
import com.wanzhong.data.po.VersionPo;
import com.wanzhong.data.po.VersionRespPo;

import cn.icanfitness.ican.app.common.R;


import androidx.fragment.app.Fragment;
import io.reactivex.annotations.Nullable;


public class AppCommonUtils implements ForceUpdateListener {

    private static AppCommonUtils mInstance;
    private  AppCommonUtils(){

    }
    public static AppCommonUtils getInstance(){
        if(mInstance == null){
            mInstance = new AppCommonUtils();
        }
        return mInstance;
    }

    private DownloadBuilder builder = null;

    /**
     * 自动更新APP
     */
    public void updateApp(boolean showMsgs) {
        if(showMsgs){
            BaseApp.getInstance().showLoading(true);
        }

        builder = AllenVersionChecker
                .getInstance()
                .requestVersion()
                .setRequestUrl("https://www.baidu.com")
                .request(new RequestVersionListener() {
                    @Nullable
                    @Override
                    public UIData onRequestVersionSuccess(String result) {
                        if(showMsgs){
                            BaseApp.getInstance().showLoading(false);
                        }
                        final VersionRespPo po = BaseApp.getInstance().getBeanFromJson(result,VersionRespPo.class);

                        return crateUIData(po);
                    }

                    @Override
                    public void onRequestVersionFailure(String message) {
                        BaseApp.getInstance().toast("获取升级信息失败，请稍后重试");
                        if(showMsgs){
                            BaseApp.getInstance().showLoading(false);
                        }
                    }
                });
        //builder.setForceUpdateListener(AppCommonUtils.this);
        builder.executeMission(BaseApp.getInstance().getApplicationContext());


    }


    private static UIData crateUIData(VersionRespPo bean) {
        UIData uiData = UIData.create();
        uiData.setTitle(BaseApp.getInstance().getApplicationContext().getResources().getString(R.string.app_name));
        uiData.setDownloadUrl("http://test-1251233192.coscd.myqcloud.com/1_1.apk");
        uiData.setContent("升级内容");
        return uiData;
    }

    @Override
    public void onShouldForceUpdate() {
       // BaseApp.getInstance().toast("强制更新=============");
        //builder.download(BaseApp.getInstance().getApplicationContext());
        Intent intent = new Intent();
    }

    public void showUpdateDialog(Fragment fragment, VersionPo versionPo){
        if(versionPo == null || !versionPo.hasUpdate()){
            return;
        }
        AllenChecker.setGlobalContext(BaseApp.getInstance().getApplicationContext());
        Intent intent = new Intent(fragment.getContext(), VersionDialogActivity.class);
        intent.putExtra("title","更新提示");
        intent.putExtra("text",versionPo.getUpdate_msg());
        intent.putExtra("downloadUrl",versionPo.canUsePatch(fragment.getContext()) ? versionPo.getPatch_link() :  versionPo.getDownload_link());
        intent.putExtra("isForce",versionPo.isForceUpdate());
        VersionParams versionParams = new VersionParams.Builder()
                .setDownloadUrl(versionPo.getDownload_link()).build();
        intent.putExtra(AVersionService.VERSION_PARAMS_KEY,versionParams);
        fragment.startActivity(intent);
    }
}
