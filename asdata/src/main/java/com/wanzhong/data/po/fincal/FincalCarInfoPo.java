package com.wanzhong.data.po.fincal;

import java.io.Serializable;

public class FincalCarInfoPo implements Serializable {

    /**
     * thumbnail_img : https://testwww.wanzhong.xin/common/queryFile?keyId=5ce4ef18be78264950e05fca
     * trademark : 哈弗黑
     * demio_name :
     * motorcycle_type : C4X
     * shelf_id_dashboard : 5ce4ef07be78264950e05fc6
     * principal : ---
     * key_id : 20190522000002
     * old_car_id : 20190425000010
     */

    private String thumbnail_img;
    private String trademark;
    private String demio_name;
    private String motorcycle_type;
    private String shelf_id_dashboard;
    private String principal;
    private String key_id;
    private String old_car_id;
    private String createdt;

    public String getCreatedt() {
        return createdt;
    }

    public void setCreatedt(String createdt) {
        this.createdt = createdt;
    }

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

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getOld_car_id() {
        return old_car_id;
    }

    public void setOld_car_id(String old_car_id) {
        this.old_car_id = old_car_id;
    }
}
