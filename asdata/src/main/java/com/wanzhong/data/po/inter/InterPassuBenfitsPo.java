package com.wanzhong.data.po.inter;

import java.io.Serializable;

public class InterPassuBenfitsPo implements Serializable {
    /**
     * key_id : 00000001
     * title : 车辆保养工时抵扣券
     * sub_title : 车辆保养工时抵扣券
     * icon : https://teststatic.wanzhong.xin/appIcon/5d6f794929bc851390533cb7
     */

    private String key_id;
    private String title;
    private String sub_title;
    private String icon;

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
