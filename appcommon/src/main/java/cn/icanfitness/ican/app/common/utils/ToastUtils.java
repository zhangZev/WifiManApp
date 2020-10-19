package cn.icanfitness.ican.app.common.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.icanfitness.ican.app.common.R;

/**
 * @time:{2020/8/21}
 * @auhor:{ZhangXW}
 */
public class ToastUtils {


    private static TextView mTextView;
    private static ImageView mImageView;
    private static Toast toastStart;

    /**
     * 普通弹出
     * @param context
     * @param message
     */
    public static void showToast(Context context, String message) {
        if(toastStart!=null){
            toastStart.cancel();
        }
        View toastRoot = initView(context);
        //为控件设置属性
        mImageView.setVisibility(View.GONE);
        setToastText(context, message, toastRoot);
    }

    /**
     * 发送成功
     * @param context
     * @param message
     */
    public static void showToastSuccess(Context context, String message) {
        if(toastStart!=null){
            toastStart.cancel();
        }
        View toastRoot = initView(context);
        mImageView.setImageResource(R.drawable.ic_launcher);
        //为控件设置属性
        setToastText(context, message, toastRoot);
    }

    private static void setToastText(Context context, String message, View toastRoot) {
        mTextView.setText(message);
        //Toast的初始化
        toastStart = new Toast(context);
        toastStart.setGravity(Gravity.CENTER, 0, 0);
        toastStart.setDuration(Toast.LENGTH_SHORT);
        toastStart.setView(toastRoot);
        toastStart.show();
    }

    private static View initView(Context context) {
        //加载Toast布局
        View toastRoot = LayoutInflater.from(context).inflate(R.layout.view_toast_common, null);
        //初始化布局控件
        mTextView = (TextView) toastRoot.findViewById(R.id.message);
        mImageView = (ImageView) toastRoot.findViewById(R.id.imageView);
        return toastRoot;
    }
}
