package com.wanzhong.data.po.admin;

import com.wanzhong.common.po.BasePo;

/**
 * @time:{2020/4/27}
 * @auhor:{ZhangXW}
 */
public class CarRecordEntity extends BasePo {

    /**
     * key_id : 20191216000002
     * user_id : 20190902000002
     * user_name : 贵产无
     * enter_name : 小小米科技有限责任公司
     * apply_amount : 10000
     * product_type : 库存金融
     * product_type_text : 2
     * inter :
     * days : 0
     * end_dt : null
     * loan_dt : null
     * amount : 0
     * year_rate : 0
     * one_rate : 0
     * month_rate : 0
     * loan_limit : 12个月
     * status : 申请中
     * ywdt : 2019-12-16 11:19:42.0
     * car_desc : null
     * car_amount : 0
     * interest : ---
     * over_money : ---
     * total_money : ---
     */

    private String key_id;
    private String user_id;
    private String user_name;
    private String enter_name;
    private double apply_amount;
    private String product_type;
    private String product_type_text;
    private String inter;
    private int days;
    private String end_dt;
    private String loan_dt;
    private double amount;
    private double year_rate;
    private double one_rate;
    private double month_rate;
    private String loan_limit;
    private String status;
    private String ywdt;
    private String car_desc;
    private double car_amount;
    private String interest;
    private String over_money;
    private String total_money;

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
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

    public double getApply_amount() {
        return apply_amount;
    }

    public void setApply_amount(double apply_amount) {
        this.apply_amount = apply_amount;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getProduct_type_text() {
        return product_type_text;
    }

    public void setProduct_type_text(String product_type_text) {
        this.product_type_text = product_type_text;
    }

    public String getInter() {
        return inter;
    }

    public void setInter(String inter) {
        this.inter = inter;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getEnd_dt() {
        return end_dt;
    }

    public void setEnd_dt(String end_dt) {
        this.end_dt = end_dt;
    }

    public String getLoan_dt() {
        return loan_dt;
    }

    public void setLoan_dt(String loan_dt) {
        this.loan_dt = loan_dt;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getYear_rate() {
        return year_rate;
    }

    public void setYear_rate(double year_rate) {
        this.year_rate = year_rate;
    }

    public double getOne_rate() {
        return one_rate;
    }

    public void setOne_rate(double one_rate) {
        this.one_rate = one_rate;
    }

    public double getMonth_rate() {
        return month_rate;
    }

    public void setMonth_rate(double month_rate) {
        this.month_rate = month_rate;
    }

    public String getLoan_limit() {
        return loan_limit;
    }

    public void setLoan_limit(String loan_limit) {
        this.loan_limit = loan_limit;
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

    public String getCar_desc() {
        return car_desc;
    }

    public void setCar_desc(String car_desc) {
        this.car_desc = car_desc;
    }

    public double getCar_amount() {
        return car_amount;
    }

    public void setCar_amount(double car_amount) {
        this.car_amount = car_amount;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getOver_money() {
        return over_money;
    }

    public void setOver_money(String over_money) {
        this.over_money = over_money;
    }

    public String getTotal_money() {
        return total_money;
    }

    public void setTotal_money(String total_money) {
        this.total_money = total_money;
    }
}
