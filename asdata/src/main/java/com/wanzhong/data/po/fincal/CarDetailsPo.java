package com.wanzhong.data.po.fincal;

import android.text.TextUtils;

import java.io.Serializable;

public class CarDetailsPo implements Serializable {

    /**
     * key_id : 20190709000003
     * thumbnail_img : https://testwww.wanzhong.xin/common/queryFile?keyId=5d240542be78265e5f79ea7b
     * trademark : 阿尔法·罗密欧
     * demio_name : ALFA GT
     * motorcycle_type : 2004款 3.2
     * shelf_id_dashboard : 5d240533be78265e5f79ea77
     * cc :
     * shelf_id : KUYJTFHRG89415623
     * engine_number : 8456asdasd
     * begin_register_dt : 2019-07-10
     * maturity_dt : 2019-07-16
     * demio_color : 黑
     * interior_color : 蓝
     * use_nature : 1
     * assigned_count : 1
     * travel_mileage : 20000
     * principal : 20000.00
     * interest : 71.01
     * over_money : 0.00
     * status : 6
     * end_dt : 2019-10-07 00:00:00.0
     * days : 81
     * useddays : 9
     * over_days : 0
     * repay_dt : null
     */

    private String key_id;
    private String thumbnail_img;
    private String trademark;
    private String demio_name;
    private String motorcycle_type;
    private String shelf_id_dashboard;
    private String cc;
    private String shelf_id;
    private String engine_number;
    private String begin_register_dt;
    private String maturity_dt;
    private String demio_color;
    private String interior_color;
    private String use_nature;
    private String assigned_count;
    private String travel_mileage;
    private String principal;
    private String interest;
    private String over_money;
    private String status;
    private String end_dt;
    private String days;
    private String useddays;
    private String over_days;
    private String repay_dt;

    public String getRepay_dt() {
        return repay_dt;
    }

    public void setRepay_dt(String repay_dt) {
        this.repay_dt = repay_dt;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getThumbnail_img() {
        return thumbnail_img;
    }

    public void setThumbnail_img(String thumbnail_img) {
        this.thumbnail_img = thumbnail_img;
    }

    public String getTrademark() {
        if (TextUtils.isEmpty(trademark)) {
            return "";
        }
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getDemio_name() {
        if (TextUtils.isEmpty(demio_name)) {
            return "";
        }
        return demio_name;
    }

    public void setDemio_name(String demio_name) {
        this.demio_name = demio_name;
    }

    public String getMotorcycle_type() {
        if (TextUtils.isEmpty(motorcycle_type)) {
            return "";
        }
        return motorcycle_type;
    }

    public void setMotorcycle_type(String motorcycle_type) {

        this.motorcycle_type = motorcycle_type;
    }

    public String getShelf_id_dashboard() {
        if (TextUtils.isEmpty(shelf_id_dashboard)) {
            return "---";
        }
        return shelf_id_dashboard;
    }

    public void setShelf_id_dashboard(String shelf_id_dashboard) {
        this.shelf_id_dashboard = shelf_id_dashboard;
    }

    public String getCc() {
        if (TextUtils.isEmpty(cc)) {
            return "---";
        }
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getShelf_id() {
        if (TextUtils.isEmpty(shelf_id)) {
            return "---";
        }
        return shelf_id;
    }

    public void setShelf_id(String shelf_id) {
        this.shelf_id = shelf_id;
    }

    public String getEngine_number() {
        if (TextUtils.isEmpty(engine_number)) {
            return "---";
        }
        return engine_number;
    }

    public void setEngine_number(String engine_number) {
        this.engine_number = engine_number;
    }

    public String getBegin_register_dt() {
        return begin_register_dt;
    }

    public void setBegin_register_dt(String begin_register_dt) {
        this.begin_register_dt = begin_register_dt;
    }

    public String getMaturity_dt() {
        if (TextUtils.isEmpty(maturity_dt)) {
            return "---";
        }
        return maturity_dt;
    }

    public void setMaturity_dt(String maturity_dt) {
        this.maturity_dt = maturity_dt;
    }

    public String getDemio_color() {
        if (TextUtils.isEmpty(demio_color)) {
            return "---";
        }
        return demio_color;
    }

    public void setDemio_color(String demio_color) {
        this.demio_color = demio_color;
    }

    public String getInterior_color() {
        if (TextUtils.isEmpty(interior_color)) {
            return "---";
        }
        return interior_color;
    }

    public void setInterior_color(String interior_color) {
        this.interior_color = interior_color;
    }

    public String getUse_nature() {
        return use_nature;
    }

    public void setUse_nature(String use_nature) {
        this.use_nature = use_nature;
    }

    public String getAssigned_count() {
        return assigned_count;
    }

    public void setAssigned_count(String assigned_count) {
        this.assigned_count = assigned_count;
    }

    public String getTravel_mileage() {
        if (TextUtils.isEmpty(travel_mileage)) {
            return "---";
        }
        return travel_mileage;
    }

    public void setTravel_mileage(String travel_mileage) {
        this.travel_mileage = travel_mileage;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getUseddays() {
        return useddays;
    }

    public void setUseddays(String useddays) {
        this.useddays = useddays;
    }

    public String getOver_days() {
        return over_days;
    }

    public void setOver_days(String over_days) {
        this.over_days = over_days;
    }


}
