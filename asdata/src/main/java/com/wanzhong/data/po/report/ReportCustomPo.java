package com.wanzhong.data.po.report;

import java.io.Serializable;

public class ReportCustomPo implements Serializable {

    /**
     * busiNum : 0
     * statusInfo : {"num0":0,"num1":0,"num2":0,"num3":0,"num4":0,"num5":0,"num6":0}
     * gradeInfo : {"num0":0,"num1":0,"num2":0,"num3":0,"num4":0,"num5":0,"num6":0}
     * custNum : 0
     * saleNum : 0
     */

    private int busiNum;
    private ReportCustomInfoPo statusInfo;
    private ReportCustomInfoPo gradeInfo;
    private int custNum;
    private int saleNum;

    public int getBusiNum() {
        return busiNum;
    }

    public void setBusiNum(int busiNum) {
        this.busiNum = busiNum;
    }

    public ReportCustomInfoPo getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(ReportCustomInfoPo statusInfo) {
        this.statusInfo = statusInfo;
    }

    public ReportCustomInfoPo getGradeInfo() {
        return gradeInfo;
    }

    public void setGradeInfo(ReportCustomInfoPo gradeInfo) {
        this.gradeInfo = gradeInfo;
    }

    public int getCustNum() {
        return custNum;
    }

    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

}
