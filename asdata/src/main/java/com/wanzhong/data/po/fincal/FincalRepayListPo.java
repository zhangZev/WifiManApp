package com.wanzhong.data.po.fincal;

import java.io.Serializable;

public class FincalRepayListPo implements Serializable {

    /**
     * product_type : 库存金融
     * total_money : 220
     * repay_dt : 2019-05-27 10:15:51.0
     * order_id : 20190426000006
     */

    private String product_type;
    private double total_money;
    private String repay_dt;
    private String order_id;

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public double getTotal_money() {
        return total_money;
    }

    public void setTotal_money(double total_money) {
        this.total_money = total_money;
    }

    public void setTotal_money(int total_money) {
        this.total_money = total_money;
    }

    public String getRepay_dt() {
        return repay_dt;
    }

    public void setRepay_dt(String repay_dt) {
        this.repay_dt = repay_dt;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
}
