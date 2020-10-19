package com.wanzhong.data.po.inter;

import java.io.Serializable;

/**
 * 等级权益
 */
public class InterPassuPo implements Serializable {
    public String id;
    public String title;
    public int checkPos;
    public int unCheckPos;
    public int imgId;
    public int unImgId;
    public int differ;
    public int cur_grade_score;

    public InterPassuPo(String id, String title,int check,int unCheck,int imgId,int unImgId,int differ,int cur_grade_score) {
        this.id = id;
        this.title = title;
        this.checkPos = check;
        this.unCheckPos = unCheck;
        this.imgId = imgId;
        this.unImgId = unImgId;
        this.differ = differ;
        this.cur_grade_score = cur_grade_score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
