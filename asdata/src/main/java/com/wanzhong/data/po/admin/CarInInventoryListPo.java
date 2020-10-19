package com.wanzhong.data.po.admin;

import android.text.TextUtils;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;
import com.wanzhong.core.interfaces.CommImgTvViewData;

/**
 * {
 * 			"key_id": "15550486787901",
 * 			"trademark": "马自达",
 * 			"demio_name": "CX10",
 * 			"motorcycle_type": "ATZ",
 * 			"shelf_id": "SQ123456789012345",
 * 			"thumbnail_img": "5cac40718721631174339db7"
 * 		     ck_status  盘库状态 0 正常 1 异常  2待盘库
 *                }
 * */
public class CarInInventoryListPo extends BasePo implements CommImgTvViewData {
    private String key_id;
    private String trademark;
    private String demio_name;
    private String motorcycle_type;
    private String shelf_id;
    private String thumbnail_img;
    private String ck_status;
    private String car_num_no;
    private String demio_color;
    private String parking_position;

    public String getKey_id() {
        return StringUtil.changeNull(key_id);
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getTrademark() {
        return StringUtil.changeNull(trademark);
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getDemio_name() {
        return StringUtil.changeNull(demio_name);
    }

    public void setDemio_name(String demio_name) {
        this.demio_name = demio_name;
    }

    public String getMotorcycle_type() {
        return StringUtil.changeNull(motorcycle_type);
    }

    public void setMotorcycle_type(String motorcycle_type) {
        this.motorcycle_type = motorcycle_type;
    }

    public String getShelf_id() {
        return StringUtil.changeNullDefault(shelf_id);
    }

    public void setShelf_id(String shelf_id) {
        this.shelf_id = shelf_id;
    }

    public String getThumbnail_img() {
        return StringUtil.changeNull(thumbnail_img);
    }

    public void setThumbnail_img(String thumbnail_img) {
        this.thumbnail_img = thumbnail_img;
    }

    public String getCk_status() {
        return StringUtil.changeNull(ck_status,SysContants.CHAR_2);
    }

    /**是否需要盘库*/
    public boolean needCheck(){
        return SysContants.CHAR_2.equals(getCk_status());
    }
    /**是否今日盘库异常*/
    public boolean isCheckErr(){
        return SysContants.CHAR_1.equals(getCk_status());
    }
    /**是否今日盘库正常*/
    public boolean isCheckSucc(){
        return SysContants.CHAR_0.equals(getCk_status());
    }

    public void setCk_status(String ck_status) {
        this.ck_status = ck_status;
    }

    @Override
    public CharSequence getLine1Text() {
        return new StringBuffer(getTrademark()).append(" ").append(getDemio_name()).append(" ").append(getMotorcycle_type());
    }

    @Override
    public CharSequence getLine2Text() {
        return null;
    }

    @Override
    public CharSequence getLine3Text() {
        if(TextUtils.isEmpty(getShelf_id())){
            return "VIN：---";
        }
        return new StringBuilder("VIN："+getShelf_id());
    }

    @Override
    public CharSequence getLine4Text() {
        if(TextUtils.isEmpty(getDemio_color())){
            return "颜色：---";
        }
        return new StringBuilder("颜色："+getDemio_color());
    }

    @Override
    public CharSequence getLine5Text() {
        if(TextUtils.isEmpty(getCar_num_no())){
            return "车牌号：---";
        }
        return new StringBuilder("车牌号："+getCar_num_no());
    }

    @Override
    public CharSequence getLine6Text() {
        if(TextUtils.isEmpty(getParking_position())){
            return "停放位置：---";
        }
        return new StringBuilder("停放位置："+getParking_position());
    }

    @Override
    public String getImagePath() {
        return getThumbnail_img();
    }

    @Override
    public boolean showImg() {
        return true;
    }

    public String getCar_num_no() {
        return car_num_no;
    }

    public String getDemio_color() {
        return demio_color;
    }

    public String getParking_position() {
        return parking_position;
    }
}
