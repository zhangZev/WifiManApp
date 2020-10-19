package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.core.interfaces.CommImgTvViewData;

/**
 *  {
 *             "car_brand_name": "品牌名称",
 *             "car_series_name": "车系名称",
 *             "car_specimens_name": "车型名称",
 *             "cover_chart": "封面缩略图",
 *             "begin_register_dt": "上牌日期：2019年02月",
 *             "travel_mileage": 里程数（单位万）,
 *             "car_price": 标价（单位万）,
 *             "car_id": "车辆id",
 *             "enter_name": "车商名称",
 *             "library_age": 库龄（单位天）
 *         }
 * */
public class CarBySeriesNamePo extends BasePo implements CommImgTvViewData {

    private String car_brand_name;
    private String car_series_name;
    private String car_specimens_name;
    private String cover_chart;
    private String begin_register_dt;
    private String travel_mileage;
    private String car_price;
    private String car_id;
    private String enter_name;
    private String library_age;

    public String getCar_brand_name() {
        return StringUtil.changeNullDefault(car_brand_name);
    }

    public void setCar_brand_name(String car_brand_name) {
        this.car_brand_name = car_brand_name;
    }

    public String getCar_series_name() {
        return StringUtil.changeNullDefault(car_series_name);
    }

    public void setCar_series_name(String car_series_name) {
        this.car_series_name = car_series_name;
    }

    public String getCar_specimens_name() {
        return StringUtil.changeNullDefault(car_specimens_name);
    }

    public void setCar_specimens_name(String car_specimens_name) {
        this.car_specimens_name = car_specimens_name;
    }

    public String getCover_chart() {
        return StringUtil.changeNull(cover_chart);
    }

    public void setCover_chart(String cover_chart) {
        this.cover_chart = cover_chart;
    }

    public String getBegin_register_dt() {
        return StringUtil.changeNullDefault(begin_register_dt);
    }

    public void setBegin_register_dt(String begin_register_dt) {
        this.begin_register_dt = begin_register_dt;
    }

    public String getTravel_mileage() {
        return StringUtil.formatDecimal2(travel_mileage);
    }

    public void setTravel_mileage(String travel_mileage) {
        this.travel_mileage = travel_mileage;
    }

    public String getCar_price() {
        return StringUtil.formatDecimal2(car_price);
    }

    public void setCar_price(String car_price) {
        this.car_price = car_price;
    }

    public String getCar_id() {
        return StringUtil.changeNull(car_id);
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getEnter_name() {
        return StringUtil.changeNullDefault(enter_name);
    }

    public void setEnter_name(String enter_name) {
        this.enter_name = enter_name;
    }

    public String getLibrary_age() {
        return StringUtil.changeNullInt(library_age);
    }
    public String getLibraryAgeShow(){
        return "库龄"+getLibrary_age()+"天";
    }

    public void setLibrary_age(String library_age) {
        this.library_age = library_age;
    }

    @Override
    public CharSequence getLine1Text() {
        return getCar_brand_name() +" "+getCar_series_name()+" "+getCar_specimens_name();
    }

    @Override
    public CharSequence getLine2Text() {
        return getBegin_register_dt()+" | "+getTravel_mileage()+"万公里";
    }

    @Override
    public CharSequence getLine3Text() {
        return "¥"+getCar_price()+"万";
    }

    @Override
    public CharSequence getLine4Text() {
        return null;
    }

    @Override
    public CharSequence getLine5Text() {
        return null;
    }

    @Override
    public CharSequence getLine6Text() {
        return null;
    }

    @Override
    public String getImagePath() {
        return getCover_chart();
    }

    @Override
    public boolean showImg() {
        return true;
    }

}
