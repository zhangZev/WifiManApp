/*
package com.wanzhong.core.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.hwangjr.rxbus.RxBus;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.wanzhong.core.utils.BaseConsts;
import com.wanzhong.core.view.toasty.Toasty;

//文件名为WXPayEntryActivity.java,放置于application.wxapi
public class BaseWXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String wxKey = BaseConsts.WX_APPID;
        api = WXPayUtil.getInstant(this, wxKey).getIWXAPI();
        api.handleIntent(getIntent(), this);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
        switch (req.getType()) {
            case ConstantsAPI.COMMAND_GETMESSAGE_FROM_WX:
                break;
            case ConstantsAPI.COMMAND_SHOWMESSAGE_FROM_WX:
                break;
            default:
                break;
        }
        finish();
    }

    @Override
    public void onResp(BaseResp resp) {
        int result = 0;
        String code = "";
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            switch (resp.errCode) {
                case BaseResp.ErrCode.ERR_OK:
                    Toasty.success(getApplicationContext(), "支付成功！").show();
                    RxBus.get().post(BaseConsts.BusAction.PAY_FINISH, "1");
                    break;
                case BaseResp.ErrCode.ERR_USER_CANCEL:
                    Toasty.info(getApplicationContext(), "支付取消！").show();
                    RxBus.get().post(BaseConsts.BusAction.PAY_FINISH, "3");
                    break;
                case BaseResp.ErrCode.ERR_AUTH_DENIED:
                    Toasty.info(getApplicationContext(), "支付拒绝！").show();
                    RxBus.get().post(BaseConsts.BusAction.PAY_FINISH, "3");
                    break;
                default:
                    Toasty.info(getApplicationContext(), "支付失败！").show();
                    RxBus.get().post(BaseConsts.BusAction.PAY_FINISH, "3");
                    break;
            }
        }
        finish();
    }


}*/
