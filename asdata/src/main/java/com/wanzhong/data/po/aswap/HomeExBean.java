package com.wanzhong.data.po.aswap;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @time:{2020/9/24}
 * @auhor:{ZhangXW}
 */
public class HomeExBean implements Serializable {

    /**
     * slidePoint : 0.31
     * rate : 1 YSJ1=0.996933735YSJ2
     * num2 : 1.99386747
     */

    private double slidePoint;
    private String rate;
    private double num2;
    //做市
    private BigDecimal proportion;

    public BigDecimal getProportion() {
        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    public double getSlidePoint() {
        return slidePoint;
    }

    public void setSlidePoint(double slidePoint) {
        this.slidePoint = slidePoint;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }
}
