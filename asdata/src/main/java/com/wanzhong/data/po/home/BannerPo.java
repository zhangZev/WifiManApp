package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.data.utils.ImgUploadUtil;

public class BannerPo extends BasePo {

    private String picurl;

    private String title;

    private String httpurl;

    public String getPicurl() {
        return ImgUploadUtil.getInstance().getImgUrl(picurl);
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getTitle() {
        return StringUtil.changeNullDefault(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHttpurl() {
        return StringUtil.changeNullDefault(httpurl);
    }

    public void setHttpurl(String httpurl) {
        this.httpurl = httpurl;
    }
}
