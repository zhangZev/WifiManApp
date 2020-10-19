package com.wanzhong.data.po.home;

import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;
import com.wanzhong.core.interfaces.CommImgTvViewData;

public class CarSellDetailRespPo extends CarSellRequestPo implements CommImgTvViewData {

    private String cover_chart;
    private String trademark;
    private String demio_name;
    private String motorcycle_type;
    private String begin_register_dt;
    private String travel_mileage;
    private String deri_amount;
    private String source_name;


    public String getDeri_amount() {
        return StringUtil.formatDecimal2(deri_amount);
    }

    public void setDeri_amount(String deri_amount) {
        this.deri_amount = deri_amount;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getCover_chart() {
        return cover_chart;
    }

    public void setCover_chart(String cover_chart) {
        this.cover_chart = cover_chart;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getDemio_name() {
        return demio_name;
    }

    public void setDemio_name(String demio_name) {
        this.demio_name = demio_name;
    }

    public String getMotorcycle_type() {
        return motorcycle_type;
    }

    public void setMotorcycle_type(String motorcycle_type) {
        this.motorcycle_type = motorcycle_type;
    }

    public String getBegin_register_dt() {
        return begin_register_dt;
    }

    public void setBegin_register_dt(String begin_register_dt) {
        this.begin_register_dt = begin_register_dt;
    }

    public String getTravel_mileage() {
        return StringUtil.changeNullDefault(travel_mileage);
    }

    public void setTravel_mileage(String travel_mileage) {
        this.travel_mileage = travel_mileage;
    }

    @Override
    public CharSequence getLine1Text() {
        return getMotorcycle_type();
    }

    @Override
    public CharSequence getLine2Text() {
        return getBegin_register_dt() +"  |  "+getTravel_mileage() +"公里";
    }

    @Override
    public CharSequence getLine3Text() {
        return null;
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

    @Override
    public String getAmount() {
        return StringUtil.formatDecimal2(super.getAmount());
    }

    @Override
    public String getReserve_amount() {
        return StringUtil.formatDecimal2(super.getReserve_amount());
    }

    @Override
    public String getPay_way() {
        return super.getPay_way();
    }
    public String getPay_wayStr() {
        return SysContants.CHAR_1.equals(super.getPay_way()) ? "按揭" : "全款";
    }

    @Override
    public String getMortgage_type() {
        return StringUtil.changeNullDefault(super.getMortgage_type());
    }

    @Override
    public String getMortgage_rate() {
        return StringUtil.changeNullDefault(super.getMortgage_rate());
    }

    @Override
    public String getMortgage_limit() {
        return StringUtil.changeNullDefault(super.getMortgage_limit());
    }

    @Override
    public String getFirst_amount() {
        return StringUtil.formatDecimal2(super.getFirst_amount());
    }

    @Override
    public String getMortgage_amount() {
        return StringUtil.formatDecimal2(super.getMortgage_amount());
    }

    @Override
    public String getRepay_amount() {
        return StringUtil.formatDecimal2(super.getRepay_amount());
    }

    @Override
    public String getInsu_com_name() {
        return StringUtil.changeNullDefault(super.getInsu_com_name());
    }

    @Override
    public String getCom_insu_end_dt() {
        return StringUtil.changeNullDefault(super.getCom_insu_end_dt());
    }

    @Override
    public String getTra_insu_end_dt() {
        return StringUtil.changeNullDefault(super.getTra_insu_end_dt())
                ;
    }

    @Override
    public String getTransfer_type() {
        return super.getTransfer_type();
    }

    @Override
    public String getTransfer_typeStr() {
        return super.getTransfer_typeStr();
    }

    @Override
    public String getSale_type() {
        return super.getSale_type();
    }

    @Override
    public String getSale_typeStr() {
        return super.getSale_typeStr();
    }

    @Override
    public String getSale_user() {
        return StringUtil.changeNullDefault(super.getSale_user());
    }

    @Override
    public String getSale_dt() {
        return StringUtil.changeNullDefault(super.getSale_dt());
    }

    @Override
    public String getMor_pro_amount() {
        return super.getMor_pro_amount();
    }

    @Override
    public String getInsu_rep_amount() {
        return super.getInsu_rep_amount();
    }

    @Override
    public String getBou_profit_amount() {
        return super.getBou_profit_amount();
    }

    @Override
    public String getQua_profit_amount() {
        return super.getQua_profit_amount();
    }

    @Override
    public String getRet_profit_amount() {
        return super.getRet_profit_amount();
    }

    @Override
    public String getDeri_desc() {
        return super.getDeri_desc();
    }

    @Override
    public String getCust_name() {
        return StringUtil.changeNullDefault(super.getCust_name());
    }

    @Override
    public String getCust_phone() {
        return StringUtil.changeNullDefault(super.getCust_phone());
    }

    @Override
    public String getSource_id() {
        return super.getSource_id();
    }

    @Override
    public String getCust_type() {
        return super.getCust_type();
    }

    @Override
    public String getCust_typeStr() {
        return super.getCust_typeStr();
    }

    @Override
    public String getCust_id_card() {
        return StringUtil.changeNullDefault(super.getCust_id_card());
    }

    @Override
    public String getCust_addr() {
        return StringUtil.changeNullDefault(super.getCust_addr());
    }

    @Override
    public String getCust_payer() {
        return StringUtil.changeNullDefault(super.getCust_payer());
    }

    @Override
    public String getCust_bank_name() {
        return StringUtil.changeNullDefault(super.getCust_bank_name());
    }

    @Override
    public String getCust_bank_no() {
        return StringUtil.changeNullDefault(super.getCust_bank_no());
    }

    @Override
    public String getCust_other_no() {
        return StringUtil.changeNullDefault(super.getCust_other_no());
    }

    @Override
    public String getTdesc() {
        return StringUtil.changeNullDefault(super.getTdesc());
    }

}
