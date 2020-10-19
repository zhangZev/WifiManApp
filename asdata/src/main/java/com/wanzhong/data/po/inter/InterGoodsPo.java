package com.wanzhong.data.po.inter;

import java.io.Serializable;

/**
 * 豌豆兑换 活动专区
 */
public class InterGoodsPo implements Serializable {

    /**
     * key_id : 00000001
     * title : 花溪车管所过户免费卷
     * thumbnail_img : https://testwww.wanzhong.xin/common/queryFile?keyId=5cac17ce8721630f684eea11
     * price : 40000
     * ex_num : 15
     * act_price : 1000
     * act_amount : 0
     * act_limit : 1
     * act_begin_dt : 2019-09-01
     * act_end_dt : 2019-09-10
     */

    private String key_id;
    private String title;
    private String thumbnail_img;
    private String price;//消耗豌豆
    private String ex_num;//已兑换数量
    private String act_price;//活动消耗豌豆
    private String act_amount;//活动消耗元
    private String act_limit;//活动限购数量
    private String act_begin_dt;
    private String act_end_dt;

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail_img() {
        return thumbnail_img;
    }

    public void setThumbnail_img(String thumbnail_img) {
        this.thumbnail_img = thumbnail_img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEx_num() {
        return ex_num;
    }

    public void setEx_num(String ex_num) {
        this.ex_num = ex_num;
    }

    public String getAct_price() {
        return act_price;
    }

    public void setAct_price(String act_price) {
        this.act_price = act_price;
    }

    public String getAct_amount() {
        return act_amount;
    }

    public void setAct_amount(String act_amount) {
        this.act_amount = act_amount;
    }

    public String getAct_limit() {
        return act_limit;
    }

    public void setAct_limit(String act_limit) {
        this.act_limit = act_limit;
    }

    public String getAct_begin_dt() {
        return act_begin_dt;
    }

    public void setAct_begin_dt(String act_begin_dt) {
        this.act_begin_dt = act_begin_dt;
    }

    public String getAct_end_dt() {
        return act_end_dt;
    }

    public void setAct_end_dt(String act_end_dt) {
        this.act_end_dt = act_end_dt;
    }
}
