package com.wanzhong.data.po.inter;

import java.io.Serializable;

public class InterPayPo implements Serializable {

    /**
     * recordId : 85a63c4b301042a6acd532f0bfefadc2
     * apiKey : wx29e88df5bf8f8514
     * mchId : 1555322281
     * orderId : wx101616496825300c5f54a5ff1563107000
     * nonceStr : 6131952e46a0442195ba5c84a7d4f037
     * timeStamp : 1568103409
     * packageStr : Sign=WXPay
     * sign : C1F90C0351060FF213781A3E3F7F778A
     */

    private String recordId;
    private String apiKey;
    private String mchId;
    private String orderId;
    private String nonceStr;
    private String timeStamp;
    private String packageStr;
    private String sign;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPackageStr() {
        return packageStr;
    }

    public void setPackageStr(String packageStr) {
        this.packageStr = packageStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
