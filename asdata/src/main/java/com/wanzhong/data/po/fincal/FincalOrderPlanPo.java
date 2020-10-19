package com.wanzhong.data.po.fincal;

import java.io.Serializable;

public class FincalOrderPlanPo implements Serializable {

    /**
     * key_id : 1f9435c8d7eb4ba2b173652b3fe6277a
     * parent_key_id : d59dd3db9b24467a9e4b3ace36c87b0d
     * period_num : 第一期
     * interest : 220.00
     * interest_repay_dt : 2019-06-01 00:00:00.0
     * principal : 0
     * total_money : 1817.38
     * over_money : 1597.38
     * status : 生效中
     * repay_dt : ---
     * repay_status : 待还款
     * isflag : 0
     * inter_status : null
     */

    private String key_id;
    private String parent_key_id;
    private String period_num;
    private String interest;
    private String interest_repay_dt;
    private double principal;
    private double total_money;
    private double over_money;
    /**
     *已结算（已还）、生效中（待还）、未生效（不显示还款）
     */
    private String status;
    private String repay_dt;


    private String repay_status;
    /**
     * 0可以还款
     */
    private String isflag;
    /**
     *  0 发起 1 锁定 2 确认 3 驳回
     */
    private String inter_status;

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getParent_key_id() {
        return parent_key_id;
    }

    public void setParent_key_id(String parent_key_id) {
        this.parent_key_id = parent_key_id;
    }

    public String getPeriod_num() {
        return period_num;
    }

    public void setPeriod_num(String period_num) {
        this.period_num = period_num;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getInterest_repay_dt() {
        return interest_repay_dt;
    }

    public void setInterest_repay_dt(String interest_repay_dt) {
        this.interest_repay_dt = interest_repay_dt;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getTotal_money() {
        return total_money;
    }

    public void setTotal_money(double total_money) {
        this.total_money = total_money;
    }

    public double getOver_money() {
        return over_money;
    }

    public void setOver_money(double over_money) {
        this.over_money = over_money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRepay_dt() {
        return repay_dt;
    }

    public void setRepay_dt(String repay_dt) {
        this.repay_dt = repay_dt;
    }

    public String getRepay_status() {
        return repay_status;
    }

    public void setRepay_status(String repay_status) {
        this.repay_status = repay_status;
    }

    public String getIsflag() {
        return isflag;
    }

    public void setIsflag(String isflag) {
        this.isflag = isflag;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public String getInter_status() {
        return inter_status;
    }

    public void setInter_status(String inter_status) {
        this.inter_status = inter_status;
    }
}
