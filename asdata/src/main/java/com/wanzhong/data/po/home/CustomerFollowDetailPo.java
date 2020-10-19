package com.wanzhong.data.po.home;


import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;
import com.wanzhong.core.interfaces.CommImgTvViewData;

/**
 * {
 *                 "follow_way": "跟进方式(0创建1系统2轨迹3跟进4到店)",
 *                 "track_source": "轨迹源(0微店-询车况1微店-帮我找车2微店-降价通知3微店-收藏4.微店-询价)当跟进方式为2轨迹时,该字段有值",
 *                 "follow_user_name": "跟进人用户姓名",
 *                 "link_type": "沟通方式(0到店1电话2微信3短信)",
 *                 "follow_concent": "跟进内容",
 *                 "follow_time": "跟进时间，格式2019/08/14 18:40",
 *                 "plan_follow_time": "计划跟进时间2019/05/05 11:05",
 *                 "shop_num": "到店次数(跟进方式为到店时显示)",
 *                 "invite_shop": "是否到店进行预约(0是1否)",
 *                 "invite_result": "预约结果(0成功1失败)",
 *                 "go_shop_time": "预计到店时间，格式2019/08/14",
 *                 "car_id": 车辆-id,
 *                 "cover_chart": 车辆-封面图,
 *                 "car_brand_name": 车辆-品牌名称,
 *                 "car_series_name": 车辆-车系名称,
 *                 "car_specimens_name": 车辆-车型名称,
 *                 "begin_register_dt": 车辆-初次上牌时间，格式2019年8月,
 *                 "travel_mileage": 车辆-里程数，单位万,
 *                 "car_price": 车辆-标价，单位万
 *             }
 * */
public class CustomerFollowDetailPo extends CustomerFollowPo implements CommImgTvViewData {

    private String track_source;
    private String follow_user_name;
    private String link_type;
    private String follow_concent;
    private String plan_follow_time;
    private String shop_num;
    private String invite_shop;
    private String invite_result;
    private String go_shop_time;
    private String car_id;
    private String cover_chart;
    private String car_brand_name;
    private String car_series_name;
    private String car_specimens_name;
    private String begin_register_dt;
    private String travel_mileage;
    private String car_price;

    public String getTrack_source() {
        return StringUtil.changeNull(track_source);
    }

    public void setTrack_source(String track_source) {
        this.track_source = track_source;
    }

    public String getFollow_user_name() {
        return StringUtil.changeNullDefault(follow_user_name);
    }

    public void setFollow_user_name(String follow_user_name) {
        this.follow_user_name = follow_user_name;
    }

    public String getLink_type() {
        return StringUtil.changeNull(link_type);
    }

    public void setLink_type(String link_type) {
        this.link_type = link_type;
    }

    public String getFollow_concent() {
        return StringUtil.changeNullDefault(follow_concent);
    }

    public void setFollow_concent(String follow_concent) {
        this.follow_concent = follow_concent;
    }

    public String getPlan_follow_time() {
        return StringUtil.changeNullDefault(plan_follow_time);
    }

    public void setPlan_follow_time(String plan_follow_time) {
        this.plan_follow_time = plan_follow_time;
    }

    public String getShop_num() {
        return StringUtil.changeNullInt(shop_num);
    }

    public void setShop_num(String shop_num) {
        this.shop_num = shop_num;
    }

    public String getInvite_shop() {
        return StringUtil.changeNull(invite_shop);
    }

    public void setInvite_shop(String invite_shop) {
        this.invite_shop = invite_shop;
    }

    public String getInvite_result() {
        return StringUtil.changeNull(invite_result);
    }

    public void setInvite_result(String invite_result) {
        this.invite_result = invite_result;
    }

    public String getGo_shop_time() {
        return StringUtil.changeNullDefault(go_shop_time);
    }

    public void setGo_shop_time(String go_shop_time) {
        this.go_shop_time = go_shop_time;
    }

    public String getCar_id() {
        return StringUtil.changeNull(car_id);
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getCover_chart() {
        return StringUtil.changeNull(cover_chart);
    }

    public void setCover_chart(String cover_chart) {
        this.cover_chart = cover_chart;
    }

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

    @Override
    public CharSequence getLine1Text() {
        return getCar_brand_name() +" "+getCar_series_name()+" "+getCar_specimens_name();
    }

    @Override
    public CharSequence getLine2Text() {
        return getBegin_register_dt()+"  |  "+getTravel_mileage() +"万公里";
    }

    @Override
    public CharSequence getLine3Text() {
        return "¥"+getCar_price()+"万元";
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

    private String getTrackSourceShow(){
        String source = SysContants.CHAR_EMPTY;
        switch (getTrack_source()){
            case SysContants.CHAR_0:{
                source = "微店-询车况";
                break;
            }
            case SysContants.CHAR_1:{
                source = "微店-帮我找车";
                break;
            }
            case SysContants.CHAR_2:{
                source = "微店-降价通知";
                break;
            }
            case SysContants.CHAR_3:{
                source = "微店-收藏";
                break;
            }
            case SysContants.CHAR_4:{
                source = "微店-询价";
                break;
            }
        }
        return source;
    }
    public String getFollowTitle(){
        if(SysContants.CHAR_0.equals(getFollow_way())){
            //创建
            return "创建  |  "+getFollow_time();
        } else  if(SysContants.CHAR_1.equals(getFollow_way())){
            //系统
            return "系统  |  "+getFollow_user_name()+"  |  "+getFollow_time();
        }else  if(SysContants.CHAR_2.equals(getFollow_way())){
            //轨迹
            return "轨迹  |  "+getTrackSourceShow()+"  |  "+getFollow_time();
        }else  if(SysContants.CHAR_3.equals(getFollow_way())){
            //跟进
            return "跟进  |  "+getFollow_user_name()+"  |  "+getFollow_time();
        }else  if(SysContants.CHAR_4.equals(getFollow_way())){
            //到店
            return "第"+getShop_num()+"次到店  |  "+getFollow_user_name()+"  |  "+getFollow_time();
        }
        return getFollow_time();
    }
}
