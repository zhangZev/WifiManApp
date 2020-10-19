package com.wanzhong.data.po.home;

import com.wanzhong.common.po.ComRequestPo;
import com.wanzhong.common.util.SysContants;

import java.util.List;

public class CarSellRequestPo extends ComRequestPo {

    private String car_key_id;
    private String amount ;
    private String reserve_amount ;
    private String pay_way  ;
    private String mortgage_type ;
    private String mortgage_rate ;
    private String mortgage_limit ;
    private String first_amount ;
    private String mortgage_amount ;
    private String repay_amount ;
    private String insu_com_name ;
    private String com_insu_end_dt ;
    private String tra_insu_end_dt ;
    private String transfer_type ;
    private String sale_type ;
    private String sale_user ;
    private String sale_dt ;
    private String mor_pro_amount ;
    private String insu_rep_amount ;
    private String bou_profit_amount ;
    private String qua_profit_amount ;
    private String ret_profit_amount ;
    private String deri_desc ;
    private String cust_name ;
    private String cust_phone  ;
    private String source_id  ;
    private String cust_type  ;
    private String cust_id_card  ;
    private String cust_addr  ;
    private String cust_payer  ;
    private String cust_bank_name  ;
    private String cust_bank_no  ;
    private String cust_other_no  ;
    private String tdesc  ;
    private List<String> enclosure;




    private List<String> localImgs;

    public String getCar_key_id() {
        return car_key_id;
    }

    public void setCar_key_id(String car_key_id) {
        this.car_key_id = car_key_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReserve_amount() {
        return reserve_amount;
    }

    public void setReserve_amount(String reserve_amount) {
        this.reserve_amount = reserve_amount;
    }

    public String getPay_way() {
        return pay_way;
    }

    public void setPay_way(String pay_way) {
        this.pay_way = pay_way;
    }

    public String getMortgage_type() {
        return mortgage_type;
    }

    public void setMortgage_type(String mortgage_type) {
        this.mortgage_type = mortgage_type;
    }

    public String getMortgage_rate() {
        return mortgage_rate;
    }

    public void setMortgage_rate(String mortgage_rate) {
        this.mortgage_rate = mortgage_rate;
    }

    public String getMortgage_limit() {
        return mortgage_limit;
    }

    public void setMortgage_limit(String mortgage_limit) {
        this.mortgage_limit = mortgage_limit;
    }

    public String getFirst_amount() {
        return first_amount;
    }

    public void setFirst_amount(String first_amount) {
        this.first_amount = first_amount;
    }

    public String getMortgage_amount() {
        return mortgage_amount;
    }

    public void setMortgage_amount(String mortgage_amount) {
        this.mortgage_amount = mortgage_amount;
    }

    public String getRepay_amount() {
        return repay_amount;
    }

    public void setRepay_amount(String repay_amount) {
        this.repay_amount = repay_amount;
    }

    public String getInsu_com_name() {
        return insu_com_name;
    }

    public void setInsu_com_name(String insu_com_name) {
        this.insu_com_name = insu_com_name;
    }

    public String getCom_insu_end_dt() {
        return com_insu_end_dt;
    }

    public void setCom_insu_end_dt(String com_insu_end_dt) {
        this.com_insu_end_dt = com_insu_end_dt;
    }

    public String getTra_insu_end_dt() {
        return tra_insu_end_dt;
    }

    public void setTra_insu_end_dt(String tra_insu_end_dt) {
        this.tra_insu_end_dt = tra_insu_end_dt;
    }

    public String getTransfer_type() {
        return transfer_type;
    }

    public String getTransfer_typeStr(){
        return SysContants.CHAR_1.equals(getTransfer_type()) ? "外迁" : "本地";
    }
    public void setTransfer_type(String transfer_type) {
        this.transfer_type = transfer_type;
    }

    public String getSale_type() {
        return sale_type;
    }
    public String getSale_typeStr(){
        return SysContants.CHAR_1.equals(getSale_type()) ? "批发" : "零售";
    }

    public void setSale_type(String sale_type) {
        this.sale_type = sale_type;
    }

    public String getSale_user() {
        return sale_user;
    }

    public void setSale_user(String sale_user) {
        this.sale_user = sale_user;
    }

    public String getSale_dt() {
        return sale_dt;
    }

    public void setSale_dt(String sale_dt) {
        this.sale_dt = sale_dt;
    }

    public String getMor_pro_amount() {
        return mor_pro_amount;
    }

    public void setMor_pro_amount(String mor_pro_amount) {
        this.mor_pro_amount = mor_pro_amount;
    }

    public String getInsu_rep_amount() {
        return insu_rep_amount;
    }

    public void setInsu_rep_amount(String insu_rep_amount) {
        this.insu_rep_amount = insu_rep_amount;
    }

    public String getBou_profit_amount() {
        return bou_profit_amount;
    }

    public void setBou_profit_amount(String bou_profit_amount) {
        this.bou_profit_amount = bou_profit_amount;
    }

    public String getQua_profit_amount() {
        return qua_profit_amount;
    }

    public void setQua_profit_amount(String qua_profit_amount) {
        this.qua_profit_amount = qua_profit_amount;
    }

    public String getRet_profit_amount() {
        return ret_profit_amount;
    }

    public void setRet_profit_amount(String ret_profit_amount) {
        this.ret_profit_amount = ret_profit_amount;
    }

    public String getDeri_desc() {
        return deri_desc;
    }

    public void setDeri_desc(String deri_desc) {
        this.deri_desc = deri_desc;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getCust_type() {
        return cust_type;
    }

    public String getCust_typeStr() {
        return SysContants.CHAR_0.equals(cust_type) ? "个人" : "公司";
    }
    public void setCust_type(String cust_type) {
        this.cust_type = cust_type;
    }

    public String getCust_id_card() {
        return cust_id_card;
    }

    public void setCust_id_card(String cust_id_card) {
        this.cust_id_card = cust_id_card;
    }

    public String getCust_addr() {
        return cust_addr;
    }

    public void setCust_addr(String cust_addr) {
        this.cust_addr = cust_addr;
    }

    public String getCust_payer() {
        return cust_payer;
    }

    public void setCust_payer(String cust_payer) {
        this.cust_payer = cust_payer;
    }

    public String getCust_bank_name() {
        return cust_bank_name;
    }

    public void setCust_bank_name(String cust_bank_name) {
        this.cust_bank_name = cust_bank_name;
    }

    public String getCust_bank_no() {
        return cust_bank_no;
    }

    public void setCust_bank_no(String cust_bank_no) {
        this.cust_bank_no = cust_bank_no;
    }

    public String getCust_other_no() {
        return cust_other_no;
    }

    public void setCust_other_no(String cust_other_no) {
        this.cust_other_no = cust_other_no;
    }

    public String getTdesc() {
        return tdesc;
    }

    public void setTdesc(String tdesc) {
        this.tdesc = tdesc;
    }

    public List<String> getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(List<String> enclosure) {
        this.enclosure = enclosure;
    }

    public int getDeriCount(){
        int mor_pro_amount = 0;
        int insu_rep_amount = 0;
        int bou_profit_amount = 0;
        int qua_profit_amount = 0;
        int ret_profit_amount = 0;
        try{
            mor_pro_amount = Integer.parseInt(getMor_pro_amount());
        }catch (NumberFormatException e){

        }
        try{
            insu_rep_amount = Integer.parseInt(getInsu_rep_amount());
        }catch (NumberFormatException e){

        }
        try{
            bou_profit_amount = Integer.parseInt(getBou_profit_amount());
        }catch (NumberFormatException e){

        }
        try{
            qua_profit_amount = Integer.parseInt(getQua_profit_amount());
        }catch (NumberFormatException e){

        }
        try{
            ret_profit_amount = Integer.parseInt(getRet_profit_amount());
        }catch (NumberFormatException e){

        }
        return mor_pro_amount + insu_rep_amount + bou_profit_amount + qua_profit_amount + ret_profit_amount;
    }

    public List<String> getLocalImgs() {
        return localImgs;
    }

    public void setLocalImgs(List<String> localImgs) {
        this.localImgs = localImgs;
    }
}
