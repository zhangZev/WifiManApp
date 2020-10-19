/*
package com.wanzhong.core.pay;

import android.content.Context;

import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXPayUtil {

    private WXPayUtil() {
    }

    private static WXPayUtil wxPayUtil;

    private static IWXAPI api;

    public static WXPayUtil getInstant(Context context, String appId) {
        if (wxPayUtil == null) {
            wxPayUtil = new WXPayUtil();
        }
        if (api == null) {
            api = WXAPIFactory.createWXAPI(context, appId);
        }
        //注册
        api.registerApp(appId);
        return wxPayUtil;
    }

    public IWXAPI getIWXAPI() {
        return api;
    }

    public void pay(String appId, String partnerId, String prepayId, String pkgValue, String nonceStr, String timeStamp, String sign) {
        PayReq req = new PayReq();
        req.appId = appId;
        req.partnerId = partnerId;
        req.prepayId = prepayId;
        req.packageValue = pkgValue;
        req.nonceStr = nonceStr;
        req.timeStamp = timeStamp;
        //sign = "appid=" + appId + "&noncestr=" + nonceStr + "&package=Sign=WXPay" + "&partnerid=" + partnerId + "&prepayid=" + prepayId + "&timestamp=" + timeStamp  ;
        req.sign = sign;
        api.sendReq(req);
    }


    //检测当前微信版本是否支持支付
    public boolean checkPay() {
        boolean isPaySupported = api.getWXAppSupportAPI() >= Build.PAY_SUPPORTED_SDK_INT;
        return isPaySupported;
    }

    public boolean checkInstall() {
        return api.isWXAppInstalled();
    }

}
*/
