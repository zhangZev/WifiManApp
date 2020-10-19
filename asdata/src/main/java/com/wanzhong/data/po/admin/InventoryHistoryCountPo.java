package com.wanzhong.data.po.admin;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;

/**
 * {"st_2":"0","st_0":"4","st_1":"2"}
 * */
public class InventoryHistoryCountPo extends BasePo {

    private String st_2;
    private String st_0;
    private String st_1;

    public String getSt_2() {
        return StringUtil.changeNull(st_2);
    }

    public void setSt_2(String st_2) {
        this.st_2 = st_2;
    }

    public String getSt_0() {
        return StringUtil.changeNull(st_0);
    }

    public void setSt_0(String st_0) {
        this.st_0 = st_0;
    }

    public String getSt_1() {
        return StringUtil.changeNull(st_1);
    }

    public void setSt_1(String st_1) {
        this.st_1 = st_1;
    }
}
