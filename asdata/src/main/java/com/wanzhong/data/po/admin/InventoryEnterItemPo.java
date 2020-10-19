package com.wanzhong.data.po.admin;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;

/**
 * {
 * 			"enter_id": "20190331000001",
 * 			"user_name": "王者龙",
 * 			"enter_name": "黑水集团",
 * 			"head_img": "",
 * 			"num": 33
 *                }
 * */
public class InventoryEnterItemPo extends BasePo {
    private String enter_id;
    private String user_name;
    private String enter_name;
    private String head_img;
    private String num;

    public String getEnter_id() {
        return StringUtil.changeNull(enter_id);
    }

    public void setEnter_id(String enter_id) {
        this.enter_id = enter_id;
    }

    public String getUser_name() {
        return StringUtil.changeNullDefault(user_name);
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEnter_name() {
        return StringUtil.changeNullDefault(enter_name);
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

    public String getNum() {
        return StringUtil.changeNullInt(num);
    }

    public void setNum(String num) {
        this.num = num;
    }
}
