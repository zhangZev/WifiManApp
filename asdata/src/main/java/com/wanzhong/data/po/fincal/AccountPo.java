package com.wanzhong.data.po.fincal;

import java.io.Serializable;

public class AccountPo implements Serializable {
    /**
     * interBankFlag:9 未申请 0 申请中 1 申请通过 2 申请不通过
     */
    public String interBankFlag;

    /**
     * bankUserName : 张**
     * bankNo : ***************6159
     */
    private String bankUserName;
    private String bankNo;
    private String bankArea;

    public String getBankArea() {
        return bankArea;
    }

    public void setBankArea(String bankArea) {
        this.bankArea = bankArea;
    }

    public String getBankUserName() {
        return bankUserName;
    }

    public void setBankUserName(String bankUserName) {
        this.bankUserName = bankUserName;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }
}
