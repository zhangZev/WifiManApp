package com.wanzhong.data.po.inter;

import java.io.Serializable;
import java.util.List;

/**
 * 抵用券
 */
public class InterVoucherPo implements Serializable {


    private String key_id;
    private String title;
    private String img;
    private String tdesc;
    private String price;
    private String amount;
    private int ex_num;
    private int num;
    private String expiry_month;
    private String act_begin_dt;
    private String createdt;
    private String used_dt;
    private String end_dt;
    private String act_end_dt;
    private int act_limit;
    private String status;
    private String limit_status;
    private List<UseRecordBean> use_record;

    public int getEx_num() {
        return ex_num;
    }

    public void setEx_num(int ex_num) {
        this.ex_num = ex_num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCreatedt() {
        return createdt;
    }

    public void setCreatedt(String createdt) {
        this.createdt = createdt;
    }

    public String getUsed_dt() {
        return used_dt;
    }

    public void setUsed_dt(String used_dt) {
        this.used_dt = used_dt;
    }

    public String getEnd_dt() {
        return end_dt;
    }

    public void setEnd_dt(String end_dt) {
        this.end_dt = end_dt;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTdesc() {
        return tdesc;
    }

    public void setTdesc(String tdesc) {
        this.tdesc = tdesc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getExpiry_month() {
        return expiry_month;
    }

    public void setExpiry_month(String expiry_month) {
        this.expiry_month = expiry_month;
    }

    public String getAct_begin_dt() {
        return act_begin_dt;
    }

    public void setAct_begin_dt(String act_begin_dt) {
        this.act_begin_dt = act_begin_dt;
    }

    public String getAct_end_dt() {
        return act_end_dt;
    }

    public void setAct_end_dt(String act_end_dt) {
        this.act_end_dt = act_end_dt;
    }

    public int getAct_limit() {
        return act_limit;
    }

    public void setAct_limit(int act_limit) {
        this.act_limit = act_limit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLimit_status() {
        return limit_status;
    }

    public void setLimit_status(String limit_status) {
        this.limit_status = limit_status;
    }

    public List<UseRecordBean> getUse_record() {
        return use_record;
    }

    public void setUse_record(List<UseRecordBean> use_record) {
        this.use_record = use_record;
    }

    public static class UseRecordBean {
        /**
         * oper_name : 测试二
         * oper_type : 0
         * action_date : 2020/08/07
         */

        private String oper_name;
        private String oper_type;
        private String action_date;

        public String getOper_name() {
            return oper_name;
        }

        public void setOper_name(String oper_name) {
            this.oper_name = oper_name;
        }

        //OPER_TYPE: 0 豌豆兑换 1 扫码领取 2 业务退办
        // 3 车管抵用 4 租赁抵用 5 物业抵用 6 转送好友 7 批量转送
        public String getOper_type() {
            if(oper_type.equals("0")){
                return "豌豆兑换";
            }else if(oper_type.equals("1")){
                return "扫码领取";
            }else if(oper_type.equals("2")){
                return "业务退办";
            }else if(oper_type.equals("3")){
                return "车管抵用";
            }else if(oper_type.equals("4")){
                return "租赁抵用";
            }else if(oper_type.equals("5")){
                return "物业抵用";
            }else if(oper_type.equals("6")){
                return "转送好友";
            }else if(oper_type.equals("7")){
                return "批量转送";
            }
            return "";
        }

        public void setOper_type(String oper_type) {
            this.oper_type = oper_type;
        }

        public String getAction_date() {
            return action_date;
        }

        public void setAction_date(String action_date) {
            this.action_date = action_date;
        }
    }
}
