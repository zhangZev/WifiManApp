package com.wanzhong.data.po.fincal;

import java.io.Serializable;
import java.util.List;

/**
 * 单车还款
 */
public class SIngalOrderDataPo implements Serializable {
    private List<CarInfoPo> repays;
    private double amount;
    private SingalOrderPo orderPo;

    public List<CarInfoPo> getRepays() {
        return repays;
    }

    public void setRepays(List<CarInfoPo> repays) {
        this.repays = repays;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public SingalOrderPo getOrderPo() {
        return orderPo;
    }

    public void setOrderPo(SingalOrderPo orderPo) {
        this.orderPo = orderPo;
    }
}
