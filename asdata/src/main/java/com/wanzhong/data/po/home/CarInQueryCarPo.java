package com.wanzhong.data.po.home;

import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;

/**{
 "car_brand_name": "品牌名称",
 "car_series_name": "车系名称",
 "car_specimens_name": "车型名称",
 "cover_chart": "封面缩略图",
 "travel_mileage": 里程数（单位万）,
 "car_price": 标价（单位万）,
 "begin_register_dt": "初次上牌（格式：2019年08月）",
 "licence_plate": "车牌归属（格式：贵C）",
 "sell_price": 出售价格（单位万）,
 "hall_status": "在厅状态（0在厅 1车辆外借 2仓库）",
 "library_age": 库龄（天）,
 "is_m_same": "是否同行发布（0 否 1 是）",
 "is_m_shop": "是否添加到微店（0 否 1是）",
 "same_price": 同行价格（单位万）,
 "status": "状态（0 在售 1 预订 2 已售）",
 "car_id": “车辆id”
 }*/
public class CarInQueryCarPo extends CarBySeriesNamePo  {

    private String licence_plate;

    private String sell_price;

    private String hall_status;

    private String is_m_same;

    private String is_m_shop;

    private String same_price;

    private String status;

    public String getLicence_plate() {
        return licence_plate;
    }

    public void setLicence_plate(String licence_plate) {
        this.licence_plate = licence_plate;
    }

    public String getSell_price() {
        return StringUtil.formatDecimal2(sell_price);
    }

    public void setSell_price(String sell_price) {
        this.sell_price = sell_price;
    }

    public String getHall_status() {
        return hall_status;
    }

    public void setHall_status(String hall_status) {
        this.hall_status = hall_status;
    }

    public String getIs_m_same() {
        return is_m_same;
    }

    public void setIs_m_same(String is_m_same) {
        this.is_m_same = is_m_same;
    }

    public String getIs_m_shop() {
        return is_m_shop;
    }

    public void setIs_m_shop(String is_m_shop) {
        this.is_m_shop = is_m_shop;
    }

    public String getSame_price() {
        return StringUtil.formatDecimal2(same_price);
    }

    public void setSame_price(String same_price) {
        this.same_price = same_price;
    }

    public String getStatus() {
        return status;
    }

    public String getHallStatusShow(){
        //在厅状态（0在厅 1车辆外借 2仓库）
        if(SysContants.CHAR_0.equals(getHall_status())){
            return "在厅";
        } else if(SysContants.CHAR_1.equals(getHall_status())){
            return "车辆外借";
        } else if(SysContants.CHAR_2.equals(getHall_status())){
            return "仓库";
        }
        return SysContants.CHAR_EMPTY_SHOW;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public CharSequence getLine2Text() {
        return getBegin_register_dt()+" | "+getTravel_mileage()+"万公里 | "+getLicence_plate();
    }

    /**是否已经上架微店*/
    public boolean isMShop(){
        return SysContants.CHAR_1.equals(getIs_m_shop());
    }
    /**是否已经同行发布*/
    public boolean isMSame(){
        return SysContants.CHAR_1.equals(getIs_m_same());
    }

}
