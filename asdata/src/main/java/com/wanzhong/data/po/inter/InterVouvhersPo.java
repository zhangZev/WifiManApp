package com.wanzhong.data.po.inter;

import android.text.TextUtils;

import java.io.Serializable;

public class InterVouvhersPo implements Serializable {

    /**
     * key_id : S05201909E2E27J1ET3
     * goods_key_id : 00000000
     * used_dt : null
     * end_dt : null
     * createdt : 2019-09-09
     * days : 0
     * title : 抵用卷
     * expiry_month : -1
     */

    private String key_id;
    private String goods_key_id;
    private String used_dt;
    private String end_dt;
    private String createdt;
    private String days;
    private String title;
    private String expiry_month;

    private String give_name;
    private String num;
    private String recv_name;
    private String status;
    //0未使用，1已使用
    private String use_status;

    public String getUse_status() {
        return use_status;
    }

    public void setUse_status(String use_status) {
        this.use_status = use_status;
    }

    public String getGive_name() {
        return give_name;
    }

    public void setGive_name(String give_name) {
        this.give_name = give_name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getRecv_name() {
        if(TextUtils.isEmpty(recv_name)){
            return "";
        }
        return recv_name;
    }

    public void setRecv_name(String recv_name) {
        this.recv_name = recv_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getGoods_key_id() {
        return goods_key_id;
    }

    public void setGoods_key_id(String goods_key_id) {
        this.goods_key_id = goods_key_id;
    }

    public String getUsed_dt() {
        if(TextUtils.isEmpty(used_dt)){
            return "";
        }
        return used_dt;
    }

    public void setUsed_dt(String used_dt) {
        this.used_dt = used_dt;
    }

    public String getEnd_dt() {
        return end_dt;
    }

    public void setEnd_dt(String end_dt) {
        this.end_dt = end_dt;
    }

    public String getCreatedt() {
        if(TextUtils.isEmpty(createdt)){
            return "";
        }
        return createdt;
    }

    public void setCreatedt(String createdt) {
        this.createdt = createdt;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpiry_month() {
        return expiry_month;
    }

    public void setExpiry_month(String expiry_month) {
        this.expiry_month = expiry_month;
    }

}
