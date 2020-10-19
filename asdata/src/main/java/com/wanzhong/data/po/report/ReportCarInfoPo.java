package com.wanzhong.data.po.report;

import com.wanzhong.common.util.StringUtil;

import java.io.Serializable;

public class ReportCarInfoPo implements Serializable {
    /**
     * num : 0
     * price : 0
     */

    private int num;
    private String price;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPrice() {
        return StringUtil.formatDecimal2(price);
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
