package com.wanzhong.data.po.aswap;

import java.io.Serializable;

/**
 * @time:{2020/9/23}
 * @auhor:{ZhangXW}
 */
public class CoinsBean implements Serializable {

    /**
     * id : WICC
     * icon : http://134.175.126.98/aswap/b1.png
     * bal : 0
     */

    //转账
    private String type;
    private String icon;
    private double freeAmount;
    private String num;

    //选择
    private String id;
    private double bal;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBal() {
        return bal;
    }

    public void setBal(double bal) {
        this.bal = bal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getFreeAmount() {
        return freeAmount;
    }

    public void setFreeAmount(double freeAmount) {
        this.freeAmount = freeAmount;
    }
}
