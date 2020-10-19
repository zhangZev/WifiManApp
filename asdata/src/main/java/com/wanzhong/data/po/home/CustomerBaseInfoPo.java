package com.wanzhong.data.po.home;

import com.wanzhong.common.util.StringUtil;

/**
 * {
 *         "customer_name": "客户姓名",
 *         "customer_phone": "客户电话",
 *         "customer_weixin": "客户微信",
 *         "source_name": "客户来源名称",
 *         "source_id": "客户来源id",
 *         "is_emphasis": "重点客户（0：是，1：否）",
 *         "site_province_id": "所在地区-省id",
 *         "site_city_id": "所在地区-市id",
 *         "site_county_id": "所在地区-区id",
 *         "site_province_name": "所在地区-省名称",
 *         "site_city_name": "所在地区-市名称",
 *         "site_county_name": "所在地区-区名称",
 *         "site": "联系地址",
 *         "profession": "职业",
 *         "interest": "兴趣",
 *         "birthday": "生日，格式2019/08/12",
 *         "customer_id": “客户id”
 *         "sex" :"性别（1男2女）"
 *     }
 *
 */
public class CustomerBaseInfoPo extends CustomerItemPo {

    private String customer_phone;
    private String customer_weixin;
    private String source_name;
    private String source_id;
    private String site_province_id;
    private String site_city_id;
    private String site_county_id;
    private String site_province_name;
    private String site_city_name;
    private String site_county_name;
    private String site;
    private String profession;
    private String interest;
    private String birthday;
    private String customer_sex;

    public String getCustomer_phone() {
        return StringUtil.changeNull(customer_phone);
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_weixin() {
        return StringUtil.changeNull(customer_weixin);
    }

    public void setCustomer_weixin(String customer_weixin) {
        this.customer_weixin = customer_weixin;
    }

    public String getSource_name() {
        return StringUtil.changeNull(source_name);
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getSource_id() {
        return StringUtil.changeNull(source_id);
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getSite_province_id() {
        return StringUtil.changeNull(site_province_id);
    }

    public void setSite_province_id(String site_province_id) {
        this.site_province_id = site_province_id;
    }

    public String getSite_city_id() {
        return StringUtil.changeNull(site_city_id);
    }

    public void setSite_city_id(String site_city_id) {
        this.site_city_id = site_city_id;
    }

    public String getSite_county_id() {
        return StringUtil.changeNull(site_county_id);
    }

    public void setSite_county_id(String site_county_id) {
        this.site_county_id = site_county_id;
    }

    public String getSite_province_name() {
        return StringUtil.changeNull(site_province_name);
    }

    public void setSite_province_name(String site_province_name) {
        this.site_province_name = site_province_name;
    }

    public String getSite_city_name() {
        return StringUtil.changeNull(site_city_name);
    }

    public void setSite_city_name(String site_city_name) {
        this.site_city_name = site_city_name;
    }

    public String getSite_county_name() {
        return StringUtil.changeNull(site_county_name);
    }

    public void setSite_county_name(String site_county_name) {
        this.site_county_name = site_county_name;
    }

    public String getSite() {
        return StringUtil.changeNull(site);
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getProfession() {
        return StringUtil.changeNull(profession);
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getInterest() {
        return StringUtil.changeNull(interest);
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getBirthday() {
        return StringUtil.changeNull(birthday);
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCustomer_sex() {
        return StringUtil.changeNull(customer_sex);
    }

    public void setCustomer_sex(String customer_sex) {
        this.customer_sex = customer_sex;
    }

    public String getAreaShow(){
        StringBuilder sb = new StringBuilder();
        if(StringUtil.isNotNullAndSpace(getSite_province_name())){
            sb.append(getSite_province_name()).append(" ");
        }
        if(StringUtil.isNotNullAndSpace(getSite_city_name())){
            sb.append(getSite_city_name()).append(" ");
        }
        if(StringUtil.isNotNullAndSpace(getSite_county_name())){
            sb.append(getSite_county_name());
        }
        return sb.toString();
    }
}
