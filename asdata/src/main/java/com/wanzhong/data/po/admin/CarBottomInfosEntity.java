package com.wanzhong.data.po.admin;

import android.text.TextUtils;

import com.wanzhong.common.po.BasePo;

/**
 * @time:{2020/4/28}
 * @auhor:{ZhangXW}
 */
public class CarBottomInfosEntity extends BasePo {

    /**
     * is_accident : 
     * is_wade : 
     * overall_status : 0
     * car_desc : 12
     * pricing : 110000
     * loan_money : 110000
     * chk_front_rear : 1
     * chk_outer_parts : 1
     * chk_roof : 1
     * chk_engine : 1
     * chk_apillar : 1
     * chk_gearbox : 1
     * chk_bpillar : 1
     * chk_telemecanique : 1
     * chk_cpillar : 1
     * chk_skylight : 1
     * chk_suspension_bracket : 1
     * chk_trim : 1
     * wait_dedu : 
     * wait_fine : 
     * is_burn : 0
     * discount_rate : null
     * cash_money : null
     */

    public String is_accident;
    public String is_wade;
    public String overall_status;
    public String car_desc;
    public String pricing;
    public String loan_money;
    public String chk_front_rear;
    public String chk_outer_parts;
    public String chk_roof;
    public String chk_engine;
    public String chk_apillar;
    public String chk_gearbox;
    public String chk_bpillar;
    public String chk_telemecanique;
    public String chk_cpillar;
    public String chk_skylight;
    public String chk_suspension_bracket;
    public String chk_trim;
    public String wait_dedu;
    public String wait_fine;
    public String is_burn;
    public String discount_rate;
    public String cash_money;

    public String getIs_accident() {
        return is_accident;
    }

    public void setIs_accident(String is_accident) {
        this.is_accident = is_accident;
    }

    public String getIs_wade() {
        return is_wade;
    }

    public void setIs_wade(String is_wade) {
        this.is_wade = is_wade;
    }

    public String getOverall_status() {
        return overall_status;
    }

    public void setOverall_status(String overall_status) {
        this.overall_status = overall_status;
    }

    public String getCar_desc() {
        return car_desc;
    }

    public void setCar_desc(String car_desc) {
        this.car_desc = car_desc;
    }

    public String getPricing() {
        if(TextUtils.isEmpty(pricing)){
            return "0";
        }
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public String getLoan_money() {
        if(TextUtils.isEmpty(loan_money)){
            return "  ";
        }
        return loan_money;
    }

    public void setLoan_money(String loan_money) {
        this.loan_money = loan_money;
    }

    public String getChk_front_rear() {
        return chk_front_rear;
    }

    public void setChk_front_rear(String chk_front_rear) {
        this.chk_front_rear = chk_front_rear;
    }

    public String getChk_outer_parts() {
        return chk_outer_parts;
    }

    public void setChk_outer_parts(String chk_outer_parts) {
        this.chk_outer_parts = chk_outer_parts;
    }

    public String getChk_roof() {
        return chk_roof;
    }

    public void setChk_roof(String chk_roof) {
        this.chk_roof = chk_roof;
    }

    public String getChk_engine() {
        return chk_engine;
    }

    public void setChk_engine(String chk_engine) {
        this.chk_engine = chk_engine;
    }

    public String getChk_apillar() {
        return chk_apillar;
    }

    public void setChk_apillar(String chk_apillar) {
        this.chk_apillar = chk_apillar;
    }

    public String getChk_gearbox() {
        return chk_gearbox;
    }

    public void setChk_gearbox(String chk_gearbox) {
        this.chk_gearbox = chk_gearbox;
    }

    public String getChk_bpillar() {
        return chk_bpillar;
    }

    public void setChk_bpillar(String chk_bpillar) {
        this.chk_bpillar = chk_bpillar;
    }

    public String getChk_telemecanique() {
        return chk_telemecanique;
    }

    public void setChk_telemecanique(String chk_telemecanique) {
        this.chk_telemecanique = chk_telemecanique;
    }

    public String getChk_cpillar() {
        return chk_cpillar;
    }

    public void setChk_cpillar(String chk_cpillar) {
        this.chk_cpillar = chk_cpillar;
    }

    public String getChk_skylight() {
        return chk_skylight;
    }

    public void setChk_skylight(String chk_skylight) {
        this.chk_skylight = chk_skylight;
    }

    public String getChk_suspension_bracket() {
        return chk_suspension_bracket;
    }

    public void setChk_suspension_bracket(String chk_suspension_bracket) {
        this.chk_suspension_bracket = chk_suspension_bracket;
    }

    public String getChk_trim() {
        return chk_trim;
    }

    public void setChk_trim(String chk_trim) {
        this.chk_trim = chk_trim;
    }

    public String getWait_dedu() {
        return wait_dedu;
    }

    public void setWait_dedu(String wait_dedu) {
        this.wait_dedu = wait_dedu;
    }

    public String getWait_fine() {
        return wait_fine;
    }

    public void setWait_fine(String wait_fine) {
        this.wait_fine = wait_fine;
    }

    public String getIs_burn() {
        return is_burn;
    }

    public void setIs_burn(String is_burn) {
        this.is_burn = is_burn;
    }

    public String getDiscount_rate() {
        if(TextUtils.isEmpty(discount_rate)){
            return "  ";
        }
        return discount_rate;
    }

    public void setDiscount_rate(String discount_rate) {
        this.discount_rate = discount_rate;
    }

    public String getCash_money() {
        return cash_money;
    }

    public void setCash_money(String cash_money) {
        this.cash_money = cash_money;
    }
}
