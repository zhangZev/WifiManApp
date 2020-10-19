package com.wanzhong.data.po.aswap;

import java.io.Serializable;
import java.util.List;

/**
 * @time:{2020/9/23}
 * @auhor:{ZhangXW}
 */
public class MeBean implements Serializable {

    /**
     * tokens : [{"freeAmount":0,"rmbPrice":0,"type":"WICC"},{"freeAmount":0,"rmbPrice":0,"type":"WGRT"},{"freeAmount":0,"rmbPrice":0,"type":"WUSD"}]
     * isActive : false
     */

    private boolean isActive;
    private List<TokensBean> tokens;

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public List<TokensBean> getTokens() {
        return tokens;
    }

    public void setTokens(List<TokensBean> tokens) {
        this.tokens = tokens;
    }

    public static class TokensBean {
        public TokensBean(long freeAmount, long rmbPrice, String type) {
            this.freeAmount = freeAmount;
            this.rmbPrice = rmbPrice;
            this.type = type;
        }

        /**
         * freeAmount : 0
         * rmbPrice : 0
         * type : WICC
         */

        private double freeAmount;
        private double rmbPrice;
        private String type;

        public double getFreeAmount() {
            return freeAmount;
        }

        public void setFreeAmount(double freeAmount) {
            this.freeAmount = freeAmount;
        }

        public double getRmbPrice() {
            return rmbPrice;
        }

        public void setRmbPrice(double rmbPrice) {
            this.rmbPrice = rmbPrice;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
