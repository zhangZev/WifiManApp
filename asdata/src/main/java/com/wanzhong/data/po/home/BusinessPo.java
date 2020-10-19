package com.wanzhong.data.po.home;

import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;
import com.wanzhong.core.interfaces.CommImgTvViewData;

/**新商机*/
public class BusinessPo extends CarBySeriesNamePo implements CommImgTvViewData {

    private String customer_id;
    /**轨迹源（0：微店-询车况1：微店-帮我找车2：微店-降价通知3：微店-收藏\4：微店-询价）"*/
    private String track_source;
    /**级别：0：其他1：H级2：A级3：B级4：C级5：无效6：成交*/
    private String grade;
    /**客户姓名*/
    private String ucname;
    /**车牌号*/
    private String licence_plate;
    /**已等待天数*/
    private String await;

    private String phone;

    /**首次跟进耗时（值会出现5天,20小时34分钟,3分钟）*/
    private String first_follow_time;
    /**询车况*/
    private String advisory;
    /**意向车型*/
    private String purpose_car_specimens;
    /**预算*/
    private String budget;
    /**其他要求*/
    private String trequire;
    /**意向价格（单位万元）*/
    private String indicative_price;
    /**跟进时间（格式2019/08/09）*/
    private String follow_time;

    public String getTrack_source() {
        return StringUtil.changeNullDefault(track_source);
    }

    //（0：微店-询车况1：微店-帮我找车2：微店-降价通知3：微店-收藏）
    public String getTrackSourceShow(){
        String sourceShow = SysContants.CHAR_EMPTY_SHOW;
        switch (getTrack_source()){
            case SysContants.CHAR_0:
                sourceShow = "微店-询车况";
                break;
            case SysContants.CHAR_1:
                sourceShow = "微店-帮我找车";
                break;
            case SysContants.CHAR_2:
                sourceShow = "微店-降价通知";
                break;
            case SysContants.CHAR_3:
                sourceShow = "微店-收藏";
                break;
            case SysContants.CHAR_4:
                sourceShow = "微店-询价";
                break;
        }
        return sourceShow;
    }
    public void setTrack_source(String track_source) {
        this.track_source = track_source;
    }

    public String getGrade() {
        return StringUtil.changeNullDefault(grade);
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUcname() {
        return StringUtil.changeNullDefault(ucname);
    }

    public void setUcname(String ucname) {
        this.ucname = ucname;
    }

    public String getLicence_plate() {
        return StringUtil.changeNull(licence_plate,"未上牌");
    }

    public void setLicence_plate(String licence_plate) {
        this.licence_plate = licence_plate;
    }

    public String getAwait() {
        return StringUtil.changeNullDefault(await);
    }

    public void setAwait(String await) {
        this.await = await;
    }

    public String getPhone() {
        return StringUtil.changeNull(phone);
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirst_follow_time() {
        return StringUtil.changeNull(first_follow_time);
    }

    public void setFirst_follow_time(String first_follow_time) {
        this.first_follow_time = first_follow_time;
    }

    public String getAdvisory() {
        return StringUtil.changeNull(advisory);
    }

    public void setAdvisory(String advisory) {
        this.advisory = advisory;
    }

    public String getPurpose_car_specimens() {
        return StringUtil.changeNullDefault(purpose_car_specimens);
    }

    public void setPurpose_car_specimens(String purpose_car_specimens) {
        this.purpose_car_specimens = purpose_car_specimens;
    }

    public String getBudget() {
        return StringUtil.formatDecimal2(budget);
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getTrequire() {
        return StringUtil.changeNull(trequire);
    }

    public void setTrequire(String trequire) {
        this.trequire = trequire;
    }

    public String getIndicative_price() {
        return StringUtil.formatDecimal2(indicative_price);
    }

    public void setIndicative_price(String indicative_price) {
        this.indicative_price = indicative_price;
    }

    public String getFollow_time() {
        return StringUtil.changeNull(follow_time);
    }

    public void setFollow_time(String follow_time) {
        this.follow_time = follow_time;
    }

    public String getCustomer_id() {
        return StringUtil.changeNull(customer_id);
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public boolean showCarInfo(){
        return !SysContants.CHAR_1.equals(getTrack_source());
    }
    @Override
    public CharSequence getLine1Text() {
        if(showCarInfo()){
            return getCar_brand_name()+" "+getCar_series_name() +" "+getCar_specimens_name();
        } else {
            //帮我找车，意向车型
            return "意向车型："+getPurpose_car_specimens()+"\n"+
                    "购车预算："+getBudget()+"万元\n"
                    +"其他要求："+getTrequire();
        }

    }

    @Override
    public CharSequence getLine2Text() {
        if(showCarInfo()){
            return getLicence_plate() +"  |  "+getTravel_mileage() +"万公里";
        } else {
            return SysContants.CHAR_EMPTY;
        }

    }

    @Override
    public CharSequence getLine3Text() {
        if(showCarInfo()){
            return "¥"+getCar_price()+"万";
        } else {
            return SysContants.CHAR_EMPTY;
        }

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
        return showCarInfo();
    }
}
