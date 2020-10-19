package com.wanzhong.data.po.aswap;

import java.io.Serializable;

/**
 * @time:{2020/9/24}
 * @auhor:{ZhangXW}
 */
public class SignBean implements Serializable {
    private String unsignedTxraw;
    private String txid;
    private String operDesc;
    private String operType;
    private String operIcon;
    private String operFee;

    public String getOperIcon() {
        return operIcon;
    }

    public void setOperIcon(String operIcon) {
        this.operIcon = operIcon;
    }

    public String getOperDesc() {
        return operDesc;
    }

    public void setOperDesc(String operDesc) {
        this.operDesc = operDesc;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getOperFee() {
        return operFee;
    }

    public void setOperFee(String operFee) {
        this.operFee = operFee;
    }

    public String getUnsignedTxraw() {
        return unsignedTxraw;
    }

    public void setUnsignedTxraw(String unsignedTxraw) {
        this.unsignedTxraw = unsignedTxraw;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }
}
