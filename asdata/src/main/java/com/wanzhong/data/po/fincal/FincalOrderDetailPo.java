package com.wanzhong.data.po.fincal;

import java.io.Serializable;

public class FincalOrderDetailPo implements Serializable {

    /**
     * key_id : 20190429000015
     * loan_limit : 3个月
     * amount : 20000.00
     * status : 已逾期
     * ywdt : 2019-04-29
     * loan_dt : 2019-04-30
     * year_rate : 0.1320
     * year_rate_d : 0.132
     * one_rate : 0.0362
     * month_rate : 1.1
     * interest : 220.00
     * total_money : 20000.00
     * end_dt : 2019-07-30
     * days : 90
     * interest_repay_dt : 2019-06-01
     * user_id : 20190419000002
     * user_name : 测试一
     * enter_name : 测试外包公司
     */

    private String key_id;
    private String loan_limit;
    private String amount;
    private String status;
    private String ywdt;
    private String loan_dt;
    private String year_rate;
    private double year_rate_d;
    private String one_rate;
    private String month_rate;
    private String interest;
    private String total_money;
    private String end_dt;
    private String days;
    private String interest_repay_dt;
    private String user_id;
    private String user_name;
    private String enter_name;

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

    public double getYear_rate_d() {
        return year_rate_d;
    }

    public void setYear_rate_d(double year_rate_d) {
        this.year_rate_d = year_rate_d;
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
