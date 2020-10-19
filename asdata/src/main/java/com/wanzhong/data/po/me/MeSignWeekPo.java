package com.wanzhong.data.po.me;

import com.wanzhong.data.po.ComRespPo;

public class MeSignWeekPo extends ComRespPo {
    public String weekInfo;
    public int status;

    public MeSignWeekPo(String weekInfo, int status) {
        this.weekInfo = weekInfo;
        this.status = status;
    }
}
