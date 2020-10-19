package com.wanzhong.data.po.scar;

import android.text.TextUtils;

import com.wanzhong.common.util.StringUtil;

import java.io.Serializable;

/**
 * 车源信息 车辆实体
 */
public class CarResDetailsPo implements Serializable {

    /**
     * thumbnail_img : 5cac17ce8721630f684eea11
     * trademark : 福特
     * demio_name : 锐界(进口)
     * motorcycle_type : 2012款 2.0T 精锐天窗版
     * begin_register_dt : 2019-08-06
     * travel_mileage : 200
     * amount : 808800
     * key_id : 20190828000001
     * status : 0
     * age : 0.0740
     */

    private String thumbnail_img;
    private String trademark;
    private String demio_name;
    private String motorcycle_type;
    private String begin_register_dt;
    private String travel_mileage;
    private String amount;
    private String key_id;
    /**
     * 1失效，0正常
     */
    private String status;
    private String age;

    public String getThumbnail_img() {
        return thumbnail_img;
    }

    public void setThumbnail_img(String thumbnail_img) {
        this.thumbnail_img = thumbnail_img;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getDemio_name() {
        return demio_name;
    }

    public void setDemio_name(String demio_name) {
        this.demio_name = demio_name;
    }

    public String getMotorcycle_type() {
        return motorcycle_type;
    }

    public void setMotorcycle_type(String motorcycle_type) {
        this.motorcycle_type = motorcycle_type;
    }

    public String getBegin_register_dt() {
        if (TextUtils.isEmpty(begin_register_dt)) {
            return "--";
        }
        return begin_register_dt;
    }

    public void setBegin_register_dt(String begin_register_dt) {
        this.begin_register_dt = begin_register_dt;
    }

    public String getTravel_mileage() {
        return StringUtil.changeNullDefault(travel_mileage);
    }

    public void setTravel_mileage(String travel_mileage) {
        this.travel_mileage = travel_mileage;
    }

    public String getAmount() {
        return StringUtil.changeNullDefault(amount);
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
