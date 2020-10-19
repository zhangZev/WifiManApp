package com.wanzhong.data.po.aswap;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @time:{2020/9/25}
 * @auhor:{ZhangXW}
 */
public class MarketInfoBean implements Serializable {

    /**
     * token1Num : 4.999999990919523
     * token2Num : 4.9974092582499745
     * lpRate : 0.02
     * token2Rate : 5.2909235973037434E8
     * token1Rate : 5.29366649225336E8
     */

    private double token1Num;
    private double token2Num;
    private double lpRate;
    private double token2Rate;
    private double token1Rate;
    private double bal1;
    private double bal2;
    private String rate1;
    private String rate2;
    public String getRate1() {
        return rate1;
    }

    public void setRate1(String rate1) {
        this.rate1 = rate1;
    }

    public String getRate2() {
        return rate2;
    }

    public void setRate2(String rate2) {
        this.rate2 = rate2;
    }
    public double getBal1() {
        return bal1;
    }

    public void setBal1(double bal1) {
        this.bal1 = bal1;
    }

    public double getBal2() {
        return bal2;
    }

    public void setBal2(double bal2) {
        this.bal2 = bal2;
    }

    public double getToken1Num() {
        return token1Num;
    }

    public void setToken1Num(double token1Num) {
        this.token1Num = token1Num;
    }

    public double getToken2Num() {
        return token2Num;
    }

    public void setToken2Num(double token2Num) {
        this.token2Num = token2Num;
    }

    public double getLpRate() {
        return lpRate;
    }

    public void setLpRate(double lpRate) {
        this.lpRate = lpRate;
    }

    public double getToken2Rate() {
        return token2Rate;
    }

    public void setToken2Rate(double token2Rate) {
        this.token2Rate = token2Rate;
    }

    public double getToken1Rate() {
        return token1Rate;
    }

    public void setToken1Rate(double token1Rate) {
        this.token1Rate = token1Rate;
    }
}
