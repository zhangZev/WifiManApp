package com.wanzhong.data.po.fincal;

import java.io.Serializable;

public class SingalOrderPo implements Serializable {


    private String key_id;
    private String loan_limit;
    private String amount;
    /**
     * 已放款、已逾期、已结清、待放款、申请中
     */
    private String status;
    private String ywdt;
    private String loan_dt;
    private String year_rate;
    private String interest;
    private String total_money;
    private String end_dt;
    private String days;
    private String interest_repay_dt;
    private String user_id;
    private String user_name;
    private String enter_name;
    private String one_rate;
    private String month_rate;
    private String over_money;
    private double ensure_money;//保证金额
    private double guarante_money;//担保金额
    private String baozheng;
    private String danbao;

    public String getBaozheng() {
        if(ensure_money>0){
            return "已交";
        }else {
            return "未交";
        }
    }

    public String getDanbao() {
        if(guarante_money>0){
            return "已交";
        }else {
            return "未交";
        }
    }

    public double getEnsure_money() {
        return ensure_money;
    }

    public void setEnsure_money(double ensure_money) {
        this.ensure_money = ensure_money;
    }

    public double getGuarante_money() {
        return guarante_money;
    }

    public void setGuarante_money(double guarante_money) {
        this.guarante_money = guarante_money;
    }

    public String getOne_rate() {
        return one_rate;
    }

    public void setOne_rate(String one_rate) {
        this.one_rate = one_rate;
    }

    public String getMonth_rate() {
        return month_rate;
    }

    public void setMonth_rate(String month_rate) {
        this.month_rate = month_rate;
    }

    public String getOver_money() {
        if(over_money==null){
            over_money ="---";
        }
        return over_money;
    }

    public void setOver_money(String over_money) {
        this.over_money = over_money;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getLoan_limit() {
        return loan_limit;
    }

    public void setLoan_limit(String loan_limit) {
        this.loan_limit = loan_limit;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getYwdt() {
        return ywdt;
    }

    public void setYwdt(String ywdt) {
        this.ywdt = ywdt;
    }

    public String getLoan_dt() {
        return loan_dt;
    }

    public void setLoan_dt(String loan_dt) {
        this.loan_dt = loan_dt;
    }

    public String getYear_rate() {
        return year_rate;
    }

    public void setYear_rate(String year_rate) {
        this.year_rate = year_rate;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getTotal_money() {
        return total_money;
    }

    public void setTotal_money(String total_money) {
        this.total_money = total_money;
    }

    public String getEnd_dt() {
        return end_dt;
    }

    public void setEnd_dt(String end_dt) {
        this.end_dt = end_dt;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getInterest_repay_dt() {
        return interest_repay_dt;
    }

    public void setInterest_repay_dt(String interest_repay_dt) {
        this.interest_repay_dt = interest_repay_dt;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEnter_name() {
        return enter_name;
    }

    public void setEnter_name(String enter_name) {
        this.enter_name = enter_name;
    }
}
