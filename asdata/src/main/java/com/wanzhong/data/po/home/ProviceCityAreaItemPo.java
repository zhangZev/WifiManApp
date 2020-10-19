package com.wanzhong.data.po.home;

import com.wanzhong.common.util.StringUtil;

/**
 * {
*                     "id": "id",
*                     "name": "地区名称",
*                     "firstletter": “首字母”
*                 }
 * */
public class ProviceCityAreaItemPo extends SimpleSingleChooseItemPo {


    private String name;
    private String firstletter;

    public String getName() {
        return StringUtil.changeNullDefault(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstletter() {
        return firstletter;
    }

    public void setFirstletter(String firstletter) {
        this.firstletter = firstletter;
    }

  /*  @Override
    public String getHeaderName() {
        return getFirstletter();
    }*/

    @Override
    public String getText() {
        return getName();
    }
}
