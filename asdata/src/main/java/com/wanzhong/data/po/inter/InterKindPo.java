package com.wanzhong.data.po.inter;

import java.io.Serializable;

public class InterKindPo implements Serializable {

    /**
     * up_num : 1000
     * cur_grade_score : 0
     * cur_wdou_num : 0
     * name : 贫农
     * key_id : 00000001
     */

    private int up_num;
    private int cur_grade_score;
    private int cur_wdou_num;
    private int num;
    private String name;
    private String key_id;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getUp_num() {
        return up_num;
    }

    public void setUp_num(int up_num) {
        this.up_num = up_num;
    }

    public int getCur_grade_score() {
        return cur_grade_score;
    }

    public void setCur_grade_score(int cur_grade_score) {
        this.cur_grade_score = cur_grade_score;
    }

    public int getCur_wdou_num() {
        return cur_wdou_num;
    }

    public void setCur_wdou_num(int cur_wdou_num) {
        this.cur_wdou_num = cur_wdou_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }
}
