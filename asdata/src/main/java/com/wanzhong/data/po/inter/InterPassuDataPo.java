package com.wanzhong.data.po.inter;

import java.io.Serializable;
import java.util.List;

public class InterPassuDataPo implements Serializable {

    /**
     * curGrade : {"differ":300,"cur_grade_score":700}
     * grade : {"key_id":"00000001","name":"贫农","grade":"1","low_num":"0","up_num":"1000","price":"1530","limit1":"0","limit2":"0"}
     * benfits : [{"key_id":"00000001","title":"车辆保养工时抵扣券","sub_title":"车辆保养工时抵扣券","icon":"https://teststatic.wanzhong.xin/appIcon/5d6f794929bc851390533cb7"},{"key_id":"00000002","title":"租金、物业、水电优惠","sub_title":"租金、物业、水电优惠","icon":"https://teststatic.wanzhong.xin/appIcon/5d6f798129bc851390533cbb"},{"key_id":"00000000","title":"车管所VIP专属通道","sub_title":"车管所VIP专属通道","icon":"https://teststatic.wanzhong.xin/appIcon/5d6f790429bc851390533cb3"}]
     */

    private InterPassuPo curGrade;
    private GradeBean grade;
    private List<InterPassuBenfitsPo> benfits;

    public InterPassuPo getCurGrade() {
        return curGrade;
    }

    public void setCurGrade(InterPassuPo curGrade) {
        this.curGrade = curGrade;
    }

    public GradeBean getGrade() {
        return grade;
    }

    public void setGrade(GradeBean grade) {
        this.grade = grade;
    }



    public static class GradeBean {
        /**
         * key_id : 00000001
         * name : 贫农
         * grade : 1
         * low_num : 0
         * up_num : 1000
         * price : 1530
         * limit1 : 0
         * limit2 : 0
         */

        private String key_id;
        private String name;
        private String grade;
        private String low_num;
        private String up_num;
        private String price;
        private String limit1;
        private String limit2;

        public String getKey_id() {
            return key_id;
        }

        public void setKey_id(String key_id) {
            this.key_id = key_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getLow_num() {
            return low_num;
        }

        public void setLow_num(String low_num) {
            this.low_num = low_num;
        }

        public String getUp_num() {
            return up_num;
        }

        public void setUp_num(String up_num) {
            this.up_num = up_num;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getLimit1() {
            return limit1;
        }

        public void setLimit1(String limit1) {
            this.limit1 = limit1;
        }

        public String getLimit2() {
            return limit2;
        }

        public void setLimit2(String limit2) {
            this.limit2 = limit2;
        }
    }

    public List<InterPassuBenfitsPo> getBenfits() {
        return benfits;
    }

    public void setBenfits(List<InterPassuBenfitsPo> benfits) {
        this.benfits = benfits;
    }
}
