package com.wanzhong.data.po.aswap;

import java.io.Serializable;

/**
 * @time:{2020/9/25}
 * @auhor:{ZhangXW}
 */
public class MarketBean implements Serializable {

    /**
     * sub_id : YSJ1YSJ
     * token1_id : YSJ1
     * token2_id : YSJ2
     * icon1 : http://134.175.126.98/aswap/b7.png
     * icon2 : http://134.175.126.98/aswap/b8.png
     * bal : 4.99870898
     */

    private String sub_id;
    private String token1_id;
    private String token2_id;
    private String icon1;
    private String icon2;

    private double bal;
    private MarketInfoBean marketInfos;
    private boolean isShow;//true 显示

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public MarketInfoBean getMarketInfos() {
        return marketInfos;
    }

    public void setMarketInfos(MarketInfoBean marketInfos) {
        this.marketInfos = marketInfos;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getToken1_id() {
        return token1_id;
    }

    public void setToken1_id(String token1_id) {
        this.token1_id = token1_id;
    }

    public String getToken2_id() {
        return token2_id;
    }

    public void setToken2_id(String token2_id) {
        this.token2_id = token2_id;
    }

    public String getIcon1() {
        return icon1;
    }

    public void setIcon1(String icon1) {
        this.icon1 = icon1;
    }

    public String getIcon2() {
        return icon2;
    }

    public void setIcon2(String icon2) {
        this.icon2 = icon2;
    }

    public double getBal() {
        return bal;
    }

    public void setBal(double bal) {
        this.bal = bal;
    }
}
