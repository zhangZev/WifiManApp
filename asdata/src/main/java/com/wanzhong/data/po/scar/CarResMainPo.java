package com.wanzhong.data.po.scar;

import java.io.Serializable;
import java.util.List;

public class CarResMainPo implements Serializable {

    /**
     * subscribeNum : 2
     * meScarNum : 11
     * subscribeData : []
     * scarNum : 19
     */

    private int subscribeNum;
    private int meScarNum;
    private int scarNum;
    private List<CarResDetailsPo> subscribeData;

    public int getSubscribeNum() {
        return subscribeNum;
    }

    public void setSubscribeNum(int subscribeNum) {
        this.subscribeNum = subscribeNum;
    }

    public int getMeScarNum() {
        return meScarNum;
    }

    public void setMeScarNum(int meScarNum) {
        this.meScarNum = meScarNum;
    }

    public int getScarNum() {
        return scarNum;
    }

    public void setScarNum(int scarNum) {
        this.scarNum = scarNum;
    }

    public List<CarResDetailsPo> getSubscribeData() {
        return subscribeData;
    }

    public void setSubscribeData(List<CarResDetailsPo> subscribeData) {
        this.subscribeData = subscribeData;
    }
}
