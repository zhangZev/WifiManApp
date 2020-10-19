package com.wanzhong.data.po.admin;

import com.wanzhong.common.po.BasePo;

/**
 * @time:{2020/4/27}
 * @auhor:{ZhangXW}
 */
public class CarInfoListEntity extends BasePo {

    /**
     * key_id : 20200426000004
     * car_photos_lt45 : http://10.10.20.50:8064/common/queryFile?keyId=5ea535c9c03117556ce96771
     * trademark : 奥迪
     * demio_name : 奥迪A6L
     * motorcycle_type : 2019款 40 TFSI 豪华致雅型
     * shelf_id : Y45Y45U5U65I67KKU
     * car_num_no : 贵A3R3ED
     */

    private String key_id;
    private String car_photos_lt45;
    private String trademark;
    private String demio_name;
    private String motorcycle_type;
    private String shelf_id;
    private String car_num_no;
    /**
     * pricing : 110000
     * loan_money : 120000
     * assess_id : 20191016000003
     */

    private String pricing;
    private String loan_money;
    private String assess_id;
    /**
     * enter_name : 沟勾大叫二手
     * status : 6
     * carStatusText : 置换转入申请
     */

    private String enter_name;
    private String status;
    private String carStatusText;

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getCar_photos_lt45() {
        return car_photos_lt45;
    }

    public void setCar_photos_lt45(String car_photos_lt45) {
        this.car_photos_lt45 = car_photos_lt45;
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

    public String getShelf_id() {
        return shelf_id;
    }

    public void setShelf_id(String shelf_id) {
        this.shelf_id = shelf_id;
    }

    public String getCar_num_no() {
        return car_num_no;
    }

    public void setCar_num_no(String car_num_no) {
        this.car_num_no = car_num_no;
    }

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public String getLoan_money() {
        return loan_money;
    }

    public void setLoan_money(String loan_money) {
        this.loan_money = loan_money;
    }

    public String getAssess_id() {
        return assess_id;
    }

    public void setAssess_id(String assess_id) {
        this.assess_id = assess_id;
    }

    public String getEnter_name() {
        return enter_name;
    }

    public void setEnter_name(String enter_name) {
        this.enter_name = enter_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCarStatusText() {
        return carStatusText;
    }

    public void setCarStatusText(String carStatusText) {
        this.carStatusText = carStatusText;
    }
}
