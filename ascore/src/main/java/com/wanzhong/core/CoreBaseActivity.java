package com.wanzhong.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.gyf.barlibrary.ImmersionBar;
import com.hwangjr.rxbus.RxBus;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.core.utils.BaseConsts;
import com.wanzhong.core.utils.DialogUtil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * 开发者: ChenXian
 * 时间: 2019/03/11
 * 描述：最基础Activity
 */
public abstract class CoreBaseActivity extends AppCompatActivity {


    //private BusImplement mBusImplement;
    private boolean enableBackConfirm = false;
    private long firstBackPressTime;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(setDefaultActivityBg()){
            //getWindow().setBackgroundDrawableResource(R.drawable.drawable_activity_bg);
        }

        if (BaseApp.getInstance().mScreenHeight <= 0) {
            DisplayMetrics metrics = new DisplayMetrics();
            this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
            BaseApp.getInstance().mScreenHeight = metrics.heightPixels;
            BaseApp.getInstance().mScreenWidth = metrics.widthPixels;
        }

        //mBusImplement = new BusImplement();
        //CommonUtil.err("register--------------");
        //RxBus.get().register(mBusImplement);
        //registBusReceiver();
        firstBackPressTime = 0;
        ImmersionBar.with(this).statusBarDarkFont(isStatusBarDarkFont()).init();
        setTheme(getThemeId());
    }

    protected boolean isStatusBarDarkFont(){
        return false;
    }
    protected int getThemeId(){
        return R.style.MultiThemeMain;
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ImmersionBar.with(this).statusBarDarkFont(isStatusBarDarkFont()).init();
    }
    protected boolean setDefaultActivityBg(){
        return true;
    }

    private static int mBusBroadCastPriority = IntentFilter.SYSTEM_LOW_PRIORITY + 1 ;
    private BusBroadCastReceiver mBusBroadCastReceiver;
    private void registBusReceiver(){
        IntentFilter filter = new IntentFilter();
        filter.addAction(BaseConsts.Intent.ACTION_SHOW_LOADING);
        filter.addAction(BaseConsts.Intent.ACTION_CLOSE_ACTIVITY);
        filter.addAction(BaseConsts.Intent.ACTION_TOAST);
        filter.addAction(BaseConsts.Intent.ACTION_TOKEN_INVILID);
        filter.addCategory(BaseApp.getInstance().getPackageName());
        mBusBroadCastReceiver = new BusBroadCastReceiver();
        if(mBusBroadCastPriority + 1 >= IntentFilter.SYSTEM_HIGH_PRIORITY){
            //最大了
        } else {
            mBusBroadCastPriority++;
        }
        filter.setPriority(mBusBroadCastPriority);

        registerReceiver(mBusBroadCastReceiver,filter);
    }
    private class BusBroadCastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action =  intent.getAction();
            if(BaseConsts.Intent.ACTION_SHOW_LOADING.equals(action)){
                abortBroadcast();
                if(intent.getBooleanExtra(BaseConsts.EXT_DATA,false)){
                    DialogUtil.getInstant(CoreBaseActivity.this).showWait();
                } else {
                    DialogUtil.getInstant(CoreBaseActivity.this).dismissWait();
                }
            } else if(BaseConsts.Intent.ACTION_TOAST.equals(action)){
                abortBroadcast();
                DialogUtil.getInstant(CoreBaseActivity.this).showMsg(intent.getStringExtra(BaseConsts.EXT_DATA));
            } else if(BaseConsts.Intent.ACTION_CLOSE_ACTIVITY.equals(action)){
                abortBroadcast();
                if(intent.hasExtra(BaseConsts.EXT_DATA)){
                    Intent data = (Intent)intent.getParcelableExtra(BaseConsts.EXT_DATA);
                    if(data != null){
                        CoreBaseActivity.this.setResult(RESULT_OK,data);
                    }
                }
                finish();
            }else if(BaseConsts.Intent.ACTION_TOKEN_INVILID.equals(action)){
                abortBroadcast();
                if(intent.hasExtra(BaseConsts.EXT_DATA)){
                    String msg = intent.getStringExtra(BaseConsts.EXT_DATA);
                    if(StringUtil.isNotNullAndSpace(msg)){
                        DialogUtil.getInstant(CoreBaseActivity.this).showMsg(msg);
                    }
                }
                BaseApp.getInstance().setLogOut();

            }

        }
    }
    /*private class BusImplement {
        @Subscribe(thread = EventThread.MAIN_THREAD, tags = {@Tag(BaseConsts.BusAction.SHOW_LOADING)})
        public void showLoading(Boolean showloading) {
            if(showloading){
                DialogUtil.getInstant(CoreBaseActivity.this).showWait();
            } else {
                DialogUtil.getInstant(CoreBaseActivity.this).dismissWait();
            }

        }
        @Subscribe(thread = EventThread.MAIN_THREAD, tags = {@Tag(BaseConsts.BusAction.TOAST)})
        public void toast(String message) {
            DialogUtil.getInstant(CoreBaseActivity.this).showMsg(message);
        }

        @Subscribe(thread = EventThread.MAIN_THREAD, tags = {@Tag(BaseConsts.BusAction.CLOSE_ACTIVITY)})
        public void closeActivity(Intent intent) {
            if(intent != null){
                setResult(RESULT_OK,intent);
            }
            finish();

        }
        *//**Token invilid  logout*//*
        @Subscribe(thread = EventThread.MAIN_THREAD, tags = {@Tag(BaseConsts.BusAction.TOKEN_INVILID)})
        public void tokenInvilid(String message) {
            if(!TextUtils.isEmpty(message)){
                DialogUtil.getInstant(CoreBaseActivity.this).showMsg(message);
            }
            *//*App.getInstance().setLogOut();
            App.getInstance().checkLogin(CoreBaseActivity.this);*//*
        }


    }*/

    public void enableBackConfirm(boolean enable){
        this.enableBackConfirm = enable;
    }

    @Override
    public void onBackPressed() {
        if(enableBackConfirm){
            if(firstBackPressTime <= 0){
                firstBackPressTime = System.currentTimeMillis();

                BaseApp.getInstance().toast(R.string.press_again_to_exit);
                getWindow().getDecorView().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        firstBackPressTime = 0;
                    }
                }, 2000);
                return;
            }
        }
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
        DialogUtil.getInstant(this).dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().post(BaseConsts.BusAction.ACTIVITY_DESTORYED,"");
        /*if(mBusImplement != null){
            RxBus.get().unregister(mBusImplement);
        }*/
        if(mBusBroadCastReceiver != null){
            try{
                unregisterReceiver(mBusBroadCastReceiver);
            } catch (Exception e){

            }
        }
        ImmersionBar.with(this).destroy();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }




}

