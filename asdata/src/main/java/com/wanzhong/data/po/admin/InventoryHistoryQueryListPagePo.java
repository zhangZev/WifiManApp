package com.wanzhong.data.po.admin;

import com.wanzhong.data.po.ComResQueryListPagePo;

public class InventoryHistoryQueryListPagePo<T> extends ComResQueryListPagePo<T> {

    private InventoryHistoryCountPo statusNum;

    public InventoryHistoryCountPo getStatusNum() {
        return statusNum;
    }

    public void setStatusNum(InventoryHistoryCountPo statusNum) {
        this.statusNum = statusNum;
    }
}
