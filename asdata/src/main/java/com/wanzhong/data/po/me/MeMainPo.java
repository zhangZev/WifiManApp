package com.wanzhong.data.po.me;

import com.wanzhong.common.util.StringUtil;


/**
 * {
 *         "user_name": "姓名",
 *         "head_img": 头像地址,
 *         "enter_name": "企业名称",
 *         "car_dealer_phone": “客服电话”
 *     }
 * */
public class MeMainPo extends MeComAddressPo {

    private String user_name;
    private String head_img;
    private String enter_name;
    private String car_dealer_phone;
    private String leader;


    public String getUser_name() {
        return StringUtil.changeNullDefault(user_name);
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getEnter_name() {
        return StringUtil.changeNullDefault(enter_name);
    }

    public void setEnter_name(String enter_name) {
        this.enter_name = enter_name;
    }

    public String getCar_dealer_phone() {
        return StringUtil.changeNull(car_dealer_phone);
    }

    public void setCar_dealer_phone(String car_dealer_phone) {
        this.car_dealer_phone = car_dealer_phone;
    }

    public String getLeader() {
        return StringUtil.changeNull(leader);
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }
}
