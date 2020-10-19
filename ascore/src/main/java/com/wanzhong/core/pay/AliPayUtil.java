package com.wanzhong.core.pay;


import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.alipay.sdk.app.PayTask;
import com.hwangjr.rxbus.RxBus;
import com.wanzhong.core.entity.PayResult;
import com.wanzhong.core.utils.BaseConsts;

import java.util.Map;


public class AliPayUtil {
    public static AliPayUtil mAliPayUtil;

    private AliPayUtil() {
    }

    ;

    private static Activity mActivity;

    public static AliPayUtil getInstant(Activity activity) {
        mActivity = activity;
        if (mAliPayUtil == null) {
            mAliPayUtil = new AliPayUtil();
        }
        return mAliPayUtil;
    }

    private final int SDK_PAY_FLAG = 0;

    private OnAliPayListener mListener;

    public void pay(final String value, OnAliPayListener listener) {
        mListener = listener;
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                try {
//					String nvalue= URLDecoder.decode(value, "utf-8");
//					String nvalue=Html.fromHtml(value).toString();
                    PayTask alipay = new PayTask(mActivity);
                    // 调用支付接口，获取支付结果

                    Map<String, String> result = alipay.payV2(value, true);
                    Message msg = new Message();
                    msg.what = SDK_PAY_FLAG;
                    msg.obj = result;
                    mHandler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == SDK_PAY_FLAG) {
                PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                String resultStatus = payResult.getResultStatus();
                if (TextUtils.equals(resultStatus, "9000")) {
                    if (mListener != null) {
                        mListener.onResult(S_OK);
                    }
                    RxBus.get().post(BaseConsts.BusAction.PAY_FINISH, "1");
                } else {
                    // 判断resultStatus 为非“9000”则代表可能支付失败
                    // “8000”代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                    if (TextUtils.equals(resultStatus, "8000")) {
                        if (mListener != null) {
                            mListener.onResult(S_ING);
                        }
                    } else {
                        if (mListener != null) {
                            mListener.onResult(S_ERROR);
                        }
                        // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                    }
                    RxBus.get().post(BaseConsts.BusAction.PAY_FINISH, "3");
                }

            }
        }

    };

    private String getStatus(String result) {

        if (TextUtils.isEmpty(result)) {
            return null;
        }

        String FResult = null;

        String[] resultParams = result.split(";");

        for (String resultParam : resultParams) {
            if (resultParam.startsWith("resultStatus")) {
                FResult = gatValue(resultParam, "resultStatus");
            }
        }
        return FResult;

    }

    private String gatValue(String content, String key) {
        String prefix = key + "={";
        return content.substring(content.indexOf(prefix) + prefix.length(), content.lastIndexOf("}"));
    }

    public interface OnAliPayListener {
        public void onResult(int status);
    }

    public static final int S_OK = 0;
    public static final int S_ERROR = 1;
    public static final int S_ING = 2;

}
