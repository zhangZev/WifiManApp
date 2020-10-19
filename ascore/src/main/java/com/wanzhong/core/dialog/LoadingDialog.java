package com.wanzhong.core.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

import com.wanzhong.core.R;
import com.wanzhong.core.view.indicators.AVLoadingIndicatorView;
import com.wanzhong.core.view.indicators.BallSpinFadeLoaderIndicator;

/**
 * 开发者: ZhangZev
 * 时间: 2019/1/22
 * 描述：
 */
public class LoadingDialog extends Dialog {
    private Context mContext;
    AVLoadingIndicatorView indicator;

    public LoadingDialog(@NonNull Context context) {
        super(context,R.style.LoadingDialog);
        mContext = context;
    }

    public LoadingDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_loading, null);
        indicator = view.findViewById(R.id.indicator);
        indicator.setIndicator(new BallSpinFadeLoaderIndicator());
        //setCancelable(true);
        setContentView(view);
    }



    @Override
    public void show() {
        super.show();
        if(indicator!=null){
            //indicator.setIndicator(new BallSpinFadeLoaderIndicator());
            indicator.show();
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
