package com.wanzhong.data.po.me;

import java.io.Serializable;

public class MeSignDataPo implements Serializable {

    /**
     * create_date : 2019-09-04
     * create_week : 3
     * integral_num : 1
     */

    private String create_date;
    private int create_week;
    private int integral_num;

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public int getCreate_week() {
        return create_week;
    }

    public void setCreate_week(int create_week) {
        this.create_week = create_week;
    }

    public int getIntegral_num() {
        return integral_num;
    }

    public void setIntegral_num(int integral_num) {
        this.integral_num = integral_num;
    }
}
