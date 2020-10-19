package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;

/**
 * {
 *                 "customer_id": "客户id",
 *                 "customer_status": "客户状态（0普通1订金2预约3到店4无效5成交）",
 *                 "grade": "客户等级（0其他1H级2A级3B级4C级5无效6成交）",
 *                 "customer_name": "客户姓名",
 *                 "is_emphasis": "是否是重点客户（0是1否）",
 *                 "buy_car_need": "最新买车需求描述",
 *                 "new_follow": "最新跟进描述",
 *                 "car_info": 车辆描述,
 *                 "sell_price": 车辆成交价（单位万元）,
 *                 "subscription": 车辆订金（单位万元）,
 *                 "create_time": "创建时间（格式：2019/08/13 13:15）",
 *                 "sales_name": "创建人姓名",
 *                 "follow_des": "跟进描述",
 *                 "follow_day": 跟进描述值（为负数：过期几天，0.01：未设置回访，为正数：几天后跟进）
 *             }
 * */
public class CustomerItemPo extends BasePo {

    private String customer_id;

    private String customer_status;

    private String  grade;

    private String customer_name;

    private String phone;

    private String is_emphasis;

    private String buy_car_need;

    private String new_follow;

    private String car_info;

    private String sell_price;

    private String subscription;

    private String create_time;

    private String sales_name;

    private String follow_des;

    private String follow_day;

    private String follow_name;
    private String new_follow_time;

    public String getCustomer_id() {
        return StringUtil.changeNull(customer_id);
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_status() {
        return StringUtil.changeNullInt(customer_status);
    }

    public void setCustomer_status(String customer_status) {
        this.customer_status = customer_status;
    }

    public String getGrade() {
        return StringUtil.changeNullInt(grade);
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCustomer_name() {
        return StringUtil.changeNullDefault(customer_name);
    }

    public String getCustomer_name_origin() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getIs_emphasis() {
        return StringUtil.changeNull(is_emphasis, SysContants.CHAR_1);
    }

    public void setIs_emphasis(String is_emphasis) {
        this.is_emphasis = is_emphasis;
    }

    public String getBuy_car_need() {
        return StringUtil.changeNullDefault(buy_car_need);
    }

    public void setBuy_car_need(String buy_car_need) {
        this.buy_car_need = buy_car_need;
    }

    public String getNew_follow() {
        return StringUtil.changeNullDefault(new_follow);
    }

    public void setNew_follow(String new_follow) {
        this.new_follow = new_follow;
    }

    public String getCar_info() {
        return StringUtil.changeNullDefault(car_info);
    }

    public void setCar_info(String car_info) {
        this.car_info = car_info;
    }

    public String getSell_price() {
        return StringUtil.changeNullDefault(sell_price);
    }

    public void setSell_price(String sell_price) {
        this.sell_price = sell_price;
    }

    public String getSubscription() {
        return StringUtil.changeNullDefault(subscription);
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public String getCreate_time() {
        return StringUtil.changeNullDefault(create_time);
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getSales_name() {
        return sales_name;
    }

    public void setSales_name(String sales_name) {
        this.sales_name = sales_name;
    }

    public String getFollow_des() {
        return StringUtil.changeNullDefault(follow_des);
    }

    public void setFollow_des(String follow_des) {
        this.follow_des = follow_des;
    }

    public String getFollow_day() {
        return StringUtil.changeNull(follow_day,"0.01");
    }

    public void setFollow_day(String follow_day) {
        this.follow_day = follow_day;
    }

    public String getNew_follow_time() {
        return StringUtil.changeNullDefault(new_follow_time);
    }

    public void setNew_follow_time(String new_follow_time) {
        this.new_follow_time = new_follow_time;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getFollowDayDouble(){
        try {
            return Double.parseDouble(getFollow_day());
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        return Integer.MAX_VALUE;
    }

    public String getLine3Show(){
        //"客户状态（0普通1订金2预约3到店4无效5成交）",
        /*if(SysContants.CHAR_1.equals(getCustomer_status()) || SysContants.CHAR_5.equals(getCustomer_status())){
            return getCar_info();
        } else {
            return "最新跟进："+getNew_follow();
        }*/
        return "最新跟进："+getNew_follow();
    }

    public String getFollow_name() {
        return follow_name;
    }

    public void setFollow_name(String follow_name) {
        this.follow_name = follow_name;
    }
}
