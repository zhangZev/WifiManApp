package com.wanzhong.data.po.fincal;

import com.wanzhong.common.util.SysContants;

import java.io.Serializable;

public class FincalPo implements Serializable {

    /**
     * 9未申请 0申请中 1被拒绝 2申请通过
     */
    private String finStatus;
    /**
     * 数量信息:单车oneNum/库融libNum/还款repayNum
     */
    private NumInfoBean numInfo;
    /**
     * 0主账号 1子账户
     */
    private String childFlag;

    /**
     * 额度信息里面包含单车利率、库融利率;
     */
    private UserQuotaBean userQuota;

    public String getFinStatus() {
        return finStatus;
    }

    public void setFinStatus(String finStatus) {
        this.finStatus = finStatus;
    }

    public NumInfoBean getNumInfo() {
        return numInfo;
    }

    public void setNumInfo(NumInfoBean numInfo) {
        this.numInfo = numInfo;
    }

    public String getChildFlag() {
        return childFlag;
    }

    public void setChildFlag(String childFlag) {
        this.childFlag = childFlag;
    }

    public UserQuotaBean getUserQuota() {
        return userQuota;
    }

    public void setUserQuota(UserQuotaBean userQuota) {
        this.userQuota = userQuota;
    }

    public static class NumInfoBean {
        /**
         * 库融libNum
         */
        private int libNum;
        /**
         * 单车
         */
        private int oneNum;
        /**
         * 还款
         */
        private int repayNum;

        public int getLibNum() {
            return libNum;
        }

        public void setLibNum(int libNum) {
            this.libNum = libNum;
        }

        public int getOneNum() {
            return oneNum;
        }

        public void setOneNum(int oneNum) {
            this.oneNum = oneNum;
        }

        public int getRepayNum() {
            return repayNum;
        }

        public void setRepayNum(int repayNum) {
            this.repayNum = repayNum;
        }
    }

    public static class UserQuotaBean {

        private double quota;
        private double quotaed;
        private double usequota;
        private double one_rate;
        private double lib_rate;
        private String quota_dt;
        /**0商户1个人*/
        private String user_type;

        public String getQuota_dt() {
            return quota_dt;
        }

        public void setQuota_dt(String quota_dt) {
            this.quota_dt = quota_dt;
        }

        public double getQuota() {
            return quota;
        }

        public void setQuota(double quota) {
            this.quota = quota;
        }

        public double getQuotaed() {
            return quotaed;
        }

        public void setQuotaed(double quotaed) {
            this.quotaed = quotaed;
        }

        public double getUsequota() {
            return usequota;
        }

        public void setUsequota(double usequota) {
            this.usequota = usequota;
        }

        public double getOne_rate() {
            return one_rate;
        }

        public void setOne_rate(double one_rate) {
            this.one_rate = one_rate;
        }

        public double getLib_rate() {
            return lib_rate;
        }

        public void setLib_rate(double lib_rate) {
            this.lib_rate = lib_rate;
        }

        public String getUser_type() {
            return user_type;
        }

        public void setUser_type(String user_type) {
            this.user_type = user_type;
        }

        public boolean isUserTypePerson(){
            return SysContants.CHAR_1.equals(getUser_type());
        }
    }
}
