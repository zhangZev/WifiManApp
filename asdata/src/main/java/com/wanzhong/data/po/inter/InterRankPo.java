package com.wanzhong.data.po.inter;

import com.wanzhong.common.util.StringUtil;

import java.io.Serializable;

/**
 * 积分排行榜
 */
public class InterRankPo implements Serializable {

    private String enter_name;
    private String head_img;
    private String name;
    private String wdId;

    public String getEnter_name() {
        return enter_name;
    }

    public void setEnter_name(String enter_name) {
        this.enter_name = enter_name;
    }


    public String getHead_img() {
        return StringUtil.changeNull(head_img);
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWdId() {
        return wdId;
    }

    public void setWdId(String wd_id) {
        this.wdId = wd_id;
    }
}
