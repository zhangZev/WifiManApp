package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.data.po.VersionPo;

/**主页检测结果*/
public class IndexCheckPo extends BasePo {

    /**弹出活动集合*/
    private BannerPopPo activity;
    private HomeSiginData signin;
    /**APP更新*/
    private VersionPo version_info;


    public BannerPopPo getActivity() {
        return activity;
    }

    public void setActivity(BannerPopPo activity) {
        this.activity = activity;
    }

    public HomeSiginData getSignin() {
        return signin;
    }

    public void setSignin(HomeSiginData signin) {
        this.signin = signin;
    }

    public VersionPo getVersion_info() {
        return version_info;
    }

    public void setVersion_info(VersionPo version_info) {
        this.version_info = version_info;
    }
}
