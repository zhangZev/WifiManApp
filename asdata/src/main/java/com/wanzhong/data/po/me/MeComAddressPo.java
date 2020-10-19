package com.wanzhong.data.po.me;

import com.wanzhong.common.util.StringUtil;

import java.io.Serializable;

public class MeComAddressPo implements Serializable {

    private String province_id;
    private String city_id;
    private String region_id;
    private String province_name;
    private String city_name;
    private String region_name;
    private String enter_addr;

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getRegion_id() {
        return region_id;
    }

    public void setRegion_id(String region_id) {
        this.region_id = region_id;
    }

    public String getProvince_name() {
        return StringUtil.changeNull(province_name);
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getCity_name() {
        return StringUtil.changeNull(city_name);
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getRegion_name() {
        return StringUtil.changeNull(region_name);
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getEnter_addr() {
        return StringUtil.changeNull(enter_addr);
    }

    public void setEnter_addr(String enter_addr) {
        this.enter_addr = enter_addr;
    }

    public String getFullAddr(){
        return getProvince_name() + " "+getCity_name() +" "+getRegion_name() +" "+getEnter_addr();
    }
}

