package com.wanzhong.data.po.inter;

import java.io.Serializable;
import java.util.List;

public class InterVouvhersDataPo implements Serializable {
    public int totalPage;
    public int count;
    public List<InterVouvhersPo> datas;
    public totalBean total;
    public class totalBean {
        int status0;
        int status1;
        int status2;
        int status3;
        //以下是员工的
        int dh;
        int lq;
        int sy;
        int zs;

        public int getDh() {
            return dh;
        }

        public void setDh(int dh) {
            this.dh = dh;
        }

        public int getLq() {
            return lq;
        }

        public void setLq(int lq) {
            this.lq = lq;
        }

        public int getSy() {
            return sy;
        }

        public void setSy(int sy) {
            this.sy = sy;
        }

        public int getZs() {
            return zs;
        }

        public void setZs(int zs) {
            this.zs = zs;
        }

        public int getStatus3() {
            return status3;
        }

        public void setStatus3(int status3) {
            this.status3 = status3;
        }

        public int getStatus0() {
            return status0;
        }

        public void setStatus0(int status0) {
            this.status0 = status0;
        }

        public int getStatus1() {
            return status1;
        }

        public void setStatus1(int status1) {
            this.status1 = status1;
        }

        public int getStatus2() {
            return status2;
        }

        public void setStatus2(int status2) {
            this.status2 = status2;
        }
    }
}
