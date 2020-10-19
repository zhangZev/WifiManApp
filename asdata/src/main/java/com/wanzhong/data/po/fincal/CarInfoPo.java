package com.wanzhong.data.po.fincal;

import java.io.Serializable;

/**
 * 车辆实体
 */
public class CarInfoPo implements Serializable {

    /**
     * thumbnail_img : https://testwww.wanzhong.xin/common/queryFile?keyId=5d48f54fbe78260493b6c179
     * trademark : 劳斯莱斯
     * demio_name : 幻影
     * motorcycle_type : 2018款 6.7T 标准轴距版
     * shelf_id_dashboard : 5d48f537be78260493b6c175
     * principal : 10000
     * interest : 43.4
     * over_money : 0
     * status : 6
     * key_id : 20190806000002
     */

    private String thumbnail_img;
    private String trademark;
    private String demio_name;
    private String motorcycle_type;
    private String shelf_id_dashboard;
    private double principal;
    private double interest;
    private double over_money;
    private String status;
    private String key_id;
    private String car_key_id;
    /**
     *  0 发起 1 锁定 2 确认 3 驳回
     */
    private String repay_status;
    public boolean isChecked;
    /**
     * 库融才有
     */
    public String old_car_id;

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

    public String getShelf_id_dashboard() {
        return shelf_id_dashboard;
    }

    public void setShelf_id_dashboard(String shelf_id_dashboard) {
        this.shelf_id_dashboard = shelf_id_dashboard;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getOver_money() {
        return over_money;
    }

    public void setOver_money(double over_money) {
        this.over_money = over_money;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
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

    public String getRepay_status() {
        return repay_status;
    }

    public void setRepay_status(String repay_status) {
        this.repay_status = repay_status;
    }

    public String getCar_key_id() {
        return car_key_id;
    }

    public void setCar_key_id(String car_key_id) {
        this.car_key_id = car_key_id;
    }
}
