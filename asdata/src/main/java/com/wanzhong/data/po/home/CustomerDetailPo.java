package com.wanzhong.data.po.home;

import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;
import com.wanzhong.core.interfaces.CommImgTvViewData;

/**
 * 响应数据主体{
 *         "customer_need": 意向车型集合[
 *             {
 *                 "cars": 车辆集合[
 *                     {
 *                         "series_id": "意向车型名称id",
 *                         "car_brand_name": "车辆品牌名称",
 *                         "car_series_name": "车辆车系名称",
 *                         "car_specimens_name": "车辆车型名称",
 *                         "cover_chart": "车辆封面缩略图",
 *                         "begin_register_dt": "初次上牌，格式2019/02",
 *                         "travel_mileage": 里程数，单位万,
 *                         "car_price": 标价，单位万,
 *                         "car_id": “车辆id”
 *                     }
 *                 ],
 *                 "name": “意向车型名称”
 *             }
 *         ],
 *         "budget_end": 结束预算，单位万,
 *         "customer_phone": "客户电话",
 *         "customer_weixin": "客户微信",
 *         "predict_buy_time": "预计买车，格式2019/08/01",
 *         "site": "地区",
 *         "budget_begin": 开始预算，单位万,
 *         "grade": "客户等级0其他1H级2A级3B级4C级5无效6成交",
 *         "customer_status": "客户状态0普通1订金2预约3到店4无效5成交",
 *         "customer_name": "客户姓名",
 *         "source_id": "客户来源id",
 *         "customer_id": "客户id",
 *         "follow_name": "销售人姓名",
 *         "source_name": “客户来源名称”
 *         "is_emphasis":重点客户（0：是1：否）
 *         "buy_car_remark" "需求备注"
 *     }
 * */
public class CustomerDetailPo extends CustomerIntentionsHolderPo implements CommImgTvViewData {
    private String budget_end;
    private String customer_phone;
    private String customer_weixin;
    private String predict_buy_time;
    private String site;
    private String budget_begin;
    private String grade;
    private String customer_status;
    private String customer_name;
    private String source_id;
    private String customer_id;
    private String follow_name;
    private String source_name;
    private String is_emphasis;
    private String buy_car_remark;

    public String getBudget_end() {
        return StringUtil.formatDecimal2(budget_end);
    }

    public void setBudget_end(String budget_end) {
        this.budget_end = budget_end;
    }

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

    public String getPredict_buy_time() {
        return StringUtil.changeNull(predict_buy_time);
    }

    public void setPredict_buy_time(String predict_buy_time) {
        this.predict_buy_time = predict_buy_time;
    }

    public String getSite() {
        return StringUtil.changeNullDefault(site);
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getBudget_begin() {
        return StringUtil.formatDecimal2(budget_begin);
    }

    public void setBudget_begin(String budget_begin) {
        this.budget_begin = budget_begin;
    }

    public String getGrade() {
        return StringUtil.changeNullInt(grade);
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCustomer_status() {
        return StringUtil.changeNullDefault(customer_status);
    }

    public void setCustomer_status(String customer_status) {
        this.customer_status = customer_status;
    }

    public String getCustomer_name() {
        return StringUtil.changeNullDefault(customer_name);
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getSource_id() {
        return StringUtil.changeNull(source_id);
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getCustomer_id() {
        return StringUtil.changeNull(customer_id);
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getFollow_name() {
        return StringUtil.changeNullDefault(follow_name);
    }

    public void setFollow_name(String follow_name) {
        this.follow_name = follow_name;
    }

    public String getSource_name() {
        return StringUtil.changeNullDefault(source_name);
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getIs_emphasis() {
        return StringUtil.changeNull(is_emphasis, SysContants.CHAR_1);
    }

    public void setIs_emphasis(String is_emphasis) {
        this.is_emphasis = is_emphasis;
    }

    public String getBuy_car_remark() {
        return StringUtil.changeNull(buy_car_remark);
    }

    public void setBuy_car_remark(String buy_car_remark) {
        this.buy_car_remark = buy_car_remark;
    }

    @Override
    public CharSequence getLine1Text() {
        return getCustomer_name();
    }

    @Override
    public CharSequence getLine2Text() {
        return getCustomer_phone();
    }

    @Override
    public CharSequence getLine3Text() {
        return "销售："+getFollow_name() +"  客户来源："+getSource_name();
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
        ///TODO 默认头像图片
        return null;
    }

    @Override
    public boolean showImg() {
        return true;
    }
}
