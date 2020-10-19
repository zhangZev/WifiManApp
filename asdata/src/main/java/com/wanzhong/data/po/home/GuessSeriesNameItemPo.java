package com.wanzhong.data.po.home;

import com.wanzhong.common.util.StringUtil;

public class GuessSeriesNameItemPo extends SimpleSingleChooseItemPo {

    private String name;

    public String getName() {
        return StringUtil.changeNull(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    /**车系名称*/


    @Override
    public String getText() {
        return getName();
    }
}
