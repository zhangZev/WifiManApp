package com.wanzhong.data.po.home;

/**
 * "h_num": "H级数量",
 *         "a_num": "A级数量",
 *         "b_num": "B级数量",
 *         "c_num": "C级数量",
 *         "wx_num": "无效数量",
 *         "cj_num": "成交数量",
 * */
public class HomeSearchCustomRespHolderPo<T> extends HomeSearchRespHolderPo<T> {
    private  String h_num;
    private String a_num;
    private String b_num;
    private String c_num;
    private String wx_num;
    private String cj_num;

    public String getH_num() {
        return h_num;
    }

    public void setH_num(String h_num) {
        this.h_num = h_num;
    }

    public String getA_num() {
        return a_num;
    }

    public void setA_num(String a_num) {
        this.a_num = a_num;
    }

    public String getB_num() {
        return b_num;
    }

    public void setB_num(String b_num) {
        this.b_num = b_num;
    }

    public String getC_num() {
        return c_num;
    }

    public void setC_num(String c_num) {
        this.c_num = c_num;
    }

    public String getWx_num() {
        return wx_num;
    }

    public void setWx_num(String wx_num) {
        this.wx_num = wx_num;
    }

    public String getCj_num() {
        return cj_num;
    }

    public void setCj_num(String cj_num) {
        this.cj_num = cj_num;
    }
}
