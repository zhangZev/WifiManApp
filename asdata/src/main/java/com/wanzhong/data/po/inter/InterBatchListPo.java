package com.wanzhong.data.po.inter;

import java.io.Serializable;

/**
 * @time:{2020/7/7}
 * @auhor:{ZhangXW}
 */
public class InterBatchListPo implements Serializable {

    /**
     * key_id : 00000001
     * title : 万众市场400元抵用券
     * num : 11
     */

    private String key_id;
    private String title;
    private int num;

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
