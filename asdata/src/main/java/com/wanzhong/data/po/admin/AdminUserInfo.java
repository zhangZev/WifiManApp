package com.wanzhong.data.po.admin;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;

public class AdminUserInfo extends BasePo {

    private String name;
    private String head_img;

    public String getName() {
        return StringUtil.changeNullDefault(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead_img() {
        return StringUtil.changeNull(head_img);
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }
}
