package com.wanzhong.data.po.report;

import java.io.Serializable;

public class ReportCarPo implements Serializable {

    /**
     * reserveInfo : {"num":0,"price":0}
     * status0 : -1
     * status1 : -1
     * status2 : -1
     * createInfo : {"num":0,"price":0}
     * sellerInfo : {"num":0,"price":0}
     */

    private ReportCarInfoPo reserveInfo;
    private int status0;
    private int status1;
    private int status2;
    private boolean isShow;
    private ReportCarInfoPo createInfo;
    private ReportCarInfoPo sellerInfo;

    private String name;
    private int custNum;

    public ReportCarInfoPo getReserveInfo() {
        return reserveInfo;
    }

    public void setReserveInfo(ReportCarInfoPo reserveInfo) {
        this.reserveInfo = reserveInfo;
    }

    public int getStatus0() {
        if(status0==-1){
            return 0;
        }
        return status0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustNum() {
        return custNum;
    }

    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }

    public boolean isShow() {
        if (status0 == -1 && status1 == -1 && status2 == -1) {
            return true;
        }
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public void setStatus0(int status0) {
        this.status0 = status0;
    }

    public int getStatus1() {
        if(status1==-1){
            return 0;
        }
        return status1;
    }

    public void setStatus1(int status1) {
        this.status1 = status1;
    }

    public int getStatus2() {
        if(status2==-1){
            return 0;
        }
        return status2;
    }

    public void setStatus2(int status2) {
        this.status2 = status2;
    }

    public ReportCarInfoPo getCreateInfo() {
        return createInfo;
    }

    public void setCreateInfo(ReportCarInfoPo createInfo) {
        this.createInfo = createInfo;
    }

    public ReportCarInfoPo getSellerInfo() {
        return sellerInfo;
    }

    public void setSellerInfo(ReportCarInfoPo sellerInfo) {
        this.sellerInfo = sellerInfo;
    }
}
