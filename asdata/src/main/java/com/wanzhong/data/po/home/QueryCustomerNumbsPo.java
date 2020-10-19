package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;

/**
 * {"wx_num":"0","noSetFollow_num":"0","c_num":"1
 * ","b_num":"0","h_num":"2","unmake_num":"0","unfollow_num":"0","a_num":"0","cj_num":"0","zd_num":"2","all_num":"3"}
 * */
public class QueryCustomerNumbsPo extends BasePo {
    private String wx_num;
    private String noSetFollow_num;
    private String c_num;
    private String b_num;
    private String h_num;
    private String unmake_num;
    private String unfollow_num;
    private String a_num;
    private String cj_num;
    private String zd_num;
    private String all_num;

    public String getWx_num() {
        return StringUtil.changeNull(wx_num);
    }

    public void setWx_num(String wx_num) {
        this.wx_num = wx_num;
    }

    public String getNoSetFollow_num() {
        return StringUtil.changeNull(noSetFollow_num);
    }

    public void setNoSetFollow_num(String noSetFollow_num) {
        this.noSetFollow_num = noSetFollow_num;
    }

    public String getC_num() {
        return StringUtil.changeNull(c_num);
    }

    public void setC_num(String c_num) {
        this.c_num = c_num;
    }

    public String getB_num() {
        return StringUtil.changeNull(b_num);
    }

    public void setB_num(String b_num) {
        this.b_num = b_num;
    }

    public String getH_num() {
        return StringUtil.changeNull(h_num);
    }

    public void setH_num(String h_num) {
        this.h_num = h_num;
    }

    public String getUnmake_num() {
        return StringUtil.changeNull(unmake_num);
    }

    public void setUnmake_num(String unmake_num) {
        this.unmake_num = unmake_num;
    }

    public String getUnfollow_num() {
        return StringUtil.changeNull(unfollow_num);
    }

    public void setUnfollow_num(String unfollow_num) {
        this.unfollow_num = unfollow_num;
    }

    public String getA_num() {
        return StringUtil.changeNull(a_num);
    }

    public void setA_num(String a_num) {
        this.a_num = a_num;
    }

    public String getCj_num() {
        return StringUtil.changeNull(cj_num);
    }

    public void setCj_num(String cj_num) {
        this.cj_num = cj_num;
    }

    public String getZd_num() {
        return StringUtil.changeNull(zd_num);
    }

    public void setZd_num(String zd_num) {
        this.zd_num = zd_num;
    }

    public String getAll_num() {
        return StringUtil.changeNull(all_num);
    }

    public void setAll_num(String all_num) {
        this.all_num = all_num;
    }
}
