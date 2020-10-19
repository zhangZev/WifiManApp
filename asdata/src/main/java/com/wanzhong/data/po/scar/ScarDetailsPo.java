package com.wanzhong.data.po.scar;

import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;

import java.io.Serializable;
import java.util.List;

/**
 * 车源车辆详情
 */
public class ScarDetailsPo implements Serializable {

    /**
     * key_id : 20190829000001
     * imgDatas : ["https://testwww.wanzhong.xin/common/queryFile?keyId=5cac17ce8721630f684eea11","https://testwww.wanzhong.xin/common/queryFile?keyId=5cac17ce8721630f684eea11","https://testwww.wanzhong.xin/common/queryFile?keyId=5cac17ce8721630f684eea11","https://testwww.wanzhong.xin/common/queryFile?keyId=5cac17ce8721630f684eea11","https://testwww.wanzhong.xin/common/queryFile?keyId=5cac17ce8721630f684eea11","https://testwww.wanzhong.xin/common/queryFile?keyId=5cac17ce8721630f684eea11","https://testwww.wanzhong.xin/common/queryFile?keyId=5cac17ce8721630f684eea11","https://testwww.wanzhong.xin/common/queryFile?keyId=5cac17ce8721630f684eea11","https://testwww.wanzhong.xin/common/queryFile?keyId=5cac17ce8721630f684eea11"]
     * trademark : 雪铁龙
     * demio_name : 爱丽舍
     * motorcycle_type : 2018款 改款 1.6L 手动舒适型
     * cc : 3.0T
     * shelf_id : 4RTJG84JT94KYU4KD
     * engine_number : R4TEE3RT4
     * begin_register_dt : 2019-08-06
     * maturity_dt : 2019-08-01
     * demio_color : 白色
     * interior_color : 黑色
     * use_nature : 非营运
     * travel_mileage : 200
     * assigned_count : 1
     * price : 11.28
     * same_price : 80.88
     * tdesc : 经检测，该车排除火烧情况；转向柱浮锈；全车地胶地毯脏污；排除调表情况；骨架完好，排除事故车；发动机舱内部机械部件正常，无拆卸渗漏痕迹；详细结果请查看检测报告。
     * status : 0
     * hall_status : 仓库
     * age : 1
     * is_m_shop : 是否添加到微店 0 否 1是
     * is_m_same : 是否同行发布 0 否 1 是
     * seller_dt : 出售时间
     */

    private String key_id;
    private String trademark;
    private String demio_name;
    private String motorcycle_type;
    private String cc;
    private String shelf_id;
    private String engine_number;
    private String begin_register_dt;
    private String maturity_dt;
    private String demio_color;
    private String interior_color;
    private String use_nature;
    private String travel_mileage;
    private String assigned_count;
    private String price;
    private String same_price;
    private String tdesc;
    private String status;
    private String hall_status;
    private String age;
    private String phone;
    private List<String> imgDatas;
    private String is_m_shop;
    private String is_m_same;
    private String seller_dt;
    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getTrademark() {
        return StringUtil.changeNullDefault(trademark);
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getDemio_name() {
        return StringUtil.changeNullDefault(demio_name);
    }

    public void setDemio_name(String demio_name) {
        this.demio_name = demio_name;
    }

    public String getMotorcycle_type() {
        return StringUtil.changeNullDefault(motorcycle_type);
    }

    public void setMotorcycle_type(String motorcycle_type) {
        this.motorcycle_type = motorcycle_type;
    }

    public String getCc() {
        return StringUtil.changeNullDefault(cc);
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getShelf_id() {
        return StringUtil.changeNullDefault(shelf_id);
    }

    public void setShelf_id(String shelf_id) {
        this.shelf_id = shelf_id;
    }

    public String getEngine_number() {
        return StringUtil.changeNullDefault(engine_number);
    }

    public void setEngine_number(String engine_number) {
        this.engine_number = engine_number;
    }

    public String getBegin_register_dt() {
        return StringUtil.changeNullDefault(begin_register_dt);
    }

    public void setBegin_register_dt(String begin_register_dt) {
        this.begin_register_dt = begin_register_dt;
    }

    public String getMaturity_dt() {
        return StringUtil.changeNullDefault(maturity_dt);
    }

    public void setMaturity_dt(String maturity_dt) {
        this.maturity_dt = maturity_dt;
    }

    public String getDemio_color() {
        return StringUtil.changeNullDefault(demio_color);
    }

    public void setDemio_color(String demio_color) {
        this.demio_color = demio_color;
    }

    public String getInterior_color() {
        return StringUtil.changeNullDefault(interior_color);
    }

    public void setInterior_color(String interior_color) {
        this.interior_color = interior_color;
    }

    public String getUse_nature() {
        return StringUtil.changeNullDefault(use_nature);
    }

    public void setUse_nature(String use_nature) {
        this.use_nature = use_nature;
    }

    public String getTravel_mileage() {
        return StringUtil.changeNullDefault(travel_mileage);
    }

    public void setTravel_mileage(String travel_mileage) {
        this.travel_mileage = travel_mileage;
    }

    public String getAssigned_count() {
        return StringUtil.changeNullDefault(assigned_count);
    }

    public void setAssigned_count(String assigned_count) {
        this.assigned_count = assigned_count;
    }

    public String getPrice() {
        return StringUtil.formatDecimal2(price);
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSame_price() {
        return StringUtil.formatDecimal2(same_price);
    }

    public void setSame_price(String same_price) {
        this.same_price = same_price;
    }

    public String getTdesc() {
        return StringUtil.changeNullDefault(tdesc);
    }

    public void setTdesc(String tdesc) {
        this.tdesc = tdesc;
    }

    public String getStatus() {
        return StringUtil.changeNull(status);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHall_status() {
        return StringUtil.changeNull(hall_status);
    }

    public void setHall_status(String hall_status) {
        this.hall_status = hall_status;
    }

    public String getAge() {
        return StringUtil.changeNull(age);
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<String> getImgDatas() {
        return imgDatas;
    }

    public void setImgDatas(List<String> imgDatas) {
        this.imgDatas = imgDatas;
    }

    public String getPhone() {
        return StringUtil.changeNull(phone);
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIs_m_shop() {
        return StringUtil.changeNull(is_m_shop);
    }

    public void setIs_m_shop(String is_m_shop) {
        this.is_m_shop = is_m_shop;
    }

    public String getIs_m_same() {
        return StringUtil.changeNull(is_m_same);
    }

    public void setIs_m_same(String is_m_same) {
        this.is_m_same = is_m_same;
    }
    /**是否已经上架微店*/
    public boolean isMShop(){
        return SysContants.CHAR_1.equals(getIs_m_shop());
    }
    /**是否已经同行发布*/
    public boolean isMSame(){
        return SysContants.CHAR_1.equals(getIs_m_same());
    }

    public String getSeller_dt() {
        return StringUtil.changeNullDefault(seller_dt);
    }

    public void setSeller_dt(String seller_dt) {
        this.seller_dt = seller_dt;
    }
}
