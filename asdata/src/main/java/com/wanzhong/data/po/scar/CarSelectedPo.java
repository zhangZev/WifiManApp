package com.wanzhong.data.po.scar;

import java.io.Serializable;

public class CarSelectedPo implements Serializable {
    public String info;
    public int startNum;
    public int endNum;

    public CarSelectedPo(String info, int startNum, int endNum) {
        this.info = info;
        this.startNum = startNum;
        this.endNum = endNum;
    }
}
