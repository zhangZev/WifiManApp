package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;

import java.util.List;
/**主页数据*/
public class HomeIndexPo extends BasePo {

    /**未读消息数*/
    private String unread_message_num;

    /**今日任务-客户跟进数量*/
    private String customer_num;
    /**今日任务-新商机跟进数量*/
    private String business_num;

    /**客户关怀-生日客户数量*/
    private String care_customer;
    /**客户关怀-保险临期数量*/
    private String care_car;
    /**新商机跟进集合（最多10条）*/
    private List<BusinessPo> business;

    private List<BannerPo> banner;

    private List<BannerPo> advertise;

    /**客户跟进集合（最多10条）*/
    private List<CustomerFollowPo> customer;

    /**当前年月*/
    private String now_time;

    /**微店ID*/
    private String wdId;


    public String getNow_time() {
        return StringUtil.changeNullDefault(now_time);
    }

    public void setNow_time(String now_time) {
        this.now_time = now_time;
    }

    public String getUnread_message_num() {
        return StringUtil.changeNullInt(unread_message_num);
    }

    public void setUnread_message_num(String unread_message_num) {
        this.unread_message_num = unread_message_num;
    }

    public String getCustomer_num() {
        return StringUtil.changeNullInt(customer_num);
    }

    public void setCustomer_num(String customer_num) {
        this.customer_num = customer_num;
    }

    public String getBusiness_num() {
        return StringUtil.changeNullInt(business_num);
    }

    public void setBusiness_num(String business_num) {
        this.business_num = business_num;
    }

    public String getCare_customer() {
        return StringUtil.changeNullInt(care_customer);
    }

    public void setCare_customer(String care_customer) {
        this.care_customer = care_customer;
    }

    public String getCare_car() {
        return StringUtil.changeNullInt(care_car);
    }

    public void setCare_car(String care_car) {
        this.care_car = care_car;
    }

    public List<BusinessPo> getBusiness() {
        return business;
    }

    public void setBusiness(List<BusinessPo> business) {
        this.business = business;
    }

    public List<BannerPo> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerPo> banner) {
        this.banner = banner;
    }

    public List<BannerPo> getAdvertise() {
        return advertise;
    }

    public void setAdvertise(List<BannerPo> advertise) {
        this.advertise = advertise;
    }

    public List<CustomerFollowPo> getCustomer() {
        return customer;
    }

    public void setCustomer(List<CustomerFollowPo> customer) {
        this.customer = customer;
    }

    public String getWdId() {
        return StringUtil.changeNull(wdId);
    }

    public void setWdId(String wdId) {
        this.wdId = wdId;
    }
}
