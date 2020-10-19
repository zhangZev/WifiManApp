package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;

/**客户跟进*/
public class CustomerFollowPo extends BasePo {

    /**
     * {
     * 	"customer_id": "20190814000002",
     * 	"customer_name": "公冶洋",
     * 	"customer_phone": "15685190029",
     * 	"grade": "6",
     * 	"new_follow_record": "(08月14日)客户被创建 ","
     * 	new_need ":"预算： 3.00 万左右；;","
     * 	create_name ":"
     * 	小黄 ","
     * 	create_time ":"
     * 	2019 / 08 / 14 18: 40 ","
     * 	new_plan_follow_time ":"
     * 	2019 / 05 / 05 11: 05 ","
     * 	follow_result ":"
     * 	0 ","
     * 	finish_day ":null}
     * */
    private String customer_id;
    /**级别：0：其他1：H级2：A级3：B级4：C级5：无效6：成交*/
    private String grade;
    /**客户姓名*/
    private String ucname;
    /**买车需求*/
    private String carneeds;
    /**最新跟进*/
    private String follow;
    /**最新跟进时间，格式：2019/06/20 15:18*/
    private String follow_time;
    /**最新跟进方式：--:未设置,0：创建1：系统2：轨迹3：跟进*/
    private String follow_way;
    /**销售归属*/
    private String sales_man;
    /**已过期天数*/
    private String past;

    private String phone;
    //private String create_name;
    private String create_time;
    private String new_plan_follow_time;
    /**跟进结果（0待完成1按时2逾期3提前）*/
    private String follow_result;
    /**跟进天数差值，0按时完成，负数逾期的天数，正数提前完成的天数*/
    private String finish_day;

    public String getFinisTip(){
        if(SysContants.CHAR_0.equals(getFollow_result())){
            return "计划跟进："+getNew_plan_follow_time();
        } else if(SysContants.CHAR_1.equals(getFollow_result())){
            return "已按时完成任务";
        } else if(SysContants.CHAR_2.equals(getFollow_result())){
            int finishDayInt = Integer.MAX_VALUE;
            try{
                finishDayInt = Integer.parseInt(getFinish_day());
            } catch (NumberFormatException e){

            }
            if(finishDayInt != Integer.MAX_VALUE){
                return "逾期"+Math.abs(finishDayInt)+"天完成任务";
            } else {
                return "逾期完成任务";
            }
        } else if(SysContants.CHAR_3.equals(getFollow_result())){
            int finishDayInt = Integer.MAX_VALUE;
            try{
                finishDayInt = Integer.parseInt(getFinish_day());
            } catch (NumberFormatException e){

            }
            if(finishDayInt != Integer.MAX_VALUE){
                return "提前"+Math.abs(finishDayInt)+"天完成任务";
            } else {
                return "提前完成任务";
            }
        }
        return SysContants.CHAR_EMPTY;
    }

    public String getCustomer_id() {
        return StringUtil.changeNull(customer_id);
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
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

    public String getCarneeds() {
        return StringUtil.changeNullDefault(carneeds);
    }

    public void setCarneeds(String carneeds) {
        this.carneeds = carneeds;
    }

    public String getFollow() {
        return StringUtil.changeNullDefault(follow);
    }

    public void setFollow(String follow) {
        this.follow = follow;
    }

    public String getFollow_time() {
        return StringUtil.changeNullDefault(follow_time);
    }

    public void setFollow_time(String follow_time) {
        this.follow_time = follow_time;
    }

    public String getFollow_way() {
        return StringUtil.changeNullDefault(follow_way);
    }

    public void setFollow_way(String follow_way) {
        this.follow_way = follow_way;
    }

    public String getSales_man() {
        return StringUtil.changeNullDefault(sales_man);
    }

    public void setSales_man(String sales_man) {
        this.sales_man = sales_man;
    }

    public String getPast() {
        return past;
    }

    public void setPast(String past) {
        this.past = past;
    }

    public String getPhone() {
        return StringUtil.changeNull(phone);
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

 /*   public String getCreate_name() {
        return StringUtil.changeNullDefault(create_name);
    }

    public void setCreate_name(String create_name) {
        this.create_name = create_name;
    }
*/
    public String getCreate_time() {
        return StringUtil.changeNull(create_time);
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getNew_plan_follow_time() {
        return StringUtil.changeNull(new_plan_follow_time);
    }

    public void setNew_plan_follow_time(String new_plan_follow_time) {
        this.new_plan_follow_time = new_plan_follow_time;
    }

    public String getFollow_result() {
        return StringUtil.changeNull(follow_result);
    }

    public void setFollow_result(String follow_result) {
        this.follow_result = follow_result;
    }

    public String getFinish_day() {
        return StringUtil.changeNull(finish_day);
    }

    public void setFinish_day(String finish_day) {
        this.finish_day = finish_day;
    }
}
