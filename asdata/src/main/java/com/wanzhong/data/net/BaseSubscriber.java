package com.wanzhong.data.net;

import android.app.Dialog;

import com.wanzhong.common.util.SysContants;
import com.wanzhong.core.BaseApp;
import com.wanzhong.data.po.ComRespPo;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.Subject;
import retrofit2.HttpException;

public class BaseSubscriber<T> extends Subject<T> {

    Dialog dialog;

    public BaseSubscriber() {
    }

    public BaseSubscriber(boolean showLoading) {
        if(showLoading){
            BaseApp.getInstance().showLoading(true);
        }

    }



    @Override
    public void onError(final Throwable e) {
        BaseApp.getInstance().showLoading(false);
        if (e instanceof HttpException) {
            BaseApp.getInstance().toast("网络异常,请检查网络");
        } else if (e instanceof IOException) {
            BaseApp.getInstance().toast("网络异常,请检查网络");
        } else if (e instanceof NeedLoginException) {
            BaseApp.getInstance().toast(e.getMessage());
            BaseApp.getInstance().setLogOut();
        } else {
            BaseApp.getInstance().toast(e.getMessage());
        }
    }

    @Override
    public void onComplete() {
        //关闭等待进度条
        BaseApp.getInstance().showLoading(false);
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(T t) {
        BaseApp.getInstance().showLoading(false);
       /* if(t != null && t instanceof ComRespPo && SysContants.RET_ERR_INVALID.equals(((ComRespPo)t).getRetCode())){
            BaseApp.getInstance().setLogOut();
        }*/
    }


    @Override
    public boolean hasObservers() {
        return false;
    }

    @Override
    public boolean hasThrowable() {
        return false;
    }

    @Override
    public boolean hasComplete() {
        return false;
    }

    @Override
    public Throwable getThrowable() {
        return null;
    }

    @Override
    protected void subscribeActual(Observer<? super T> observer) {

    }
}