package com.wanzhong.data.po.home;

/**
 *  "zsnum": "在售数量",
 *         "djnum": "订金数量",
 *         "ysnum": "已售数量",
 *
 */
public class HomeSearchCarDemioRespHolderPo<T> extends HomeSearchRespHolderPo<T> {

    private String zsnum;

    private String djnum;

    private String ysnum;

    public String getZsnum() {
        return zsnum;
    }

    public void setZsnum(String zsnum) {
        this.zsnum = zsnum;
    }

    public String getDjnum() {
        return djnum;
    }

    public void setDjnum(String djnum) {
        this.djnum = djnum;
    }

    public String getYsnum() {
        return ysnum;
    }

    public void setYsnum(String ysnum) {
        this.ysnum = ysnum;
    }
}
