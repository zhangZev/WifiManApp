package com.wanzhong.data.po.admin;

import com.wanzhong.common.util.StringUtil;

/**
 * {"thumbnail_img":"http://10.10.20.50:8064/common/queryFile?keyId=5ce6066dbe78261d34fa99e2","trademark":"品牌","demio_name":"","motorcycle_type":"sjdfkj","s
 * helf_id":"fgh12gj45tytyj1gh","enter_name":"贵阳黑风华府二手车行","err_msg":"null","check_name":"zhangsan2"}
 * */
public class CarInInventoryHistoryListPo extends CarInInventoryListPo {

    private String enter_name;

    private String check_name;
    private String err_msg;
    public String getEnter_name() {
        return StringUtil.changeNullDefault(enter_name);
    }

    public void setEnter_name(String enter_name) {
        this.enter_name = enter_name;
    }

    @Override
    public CharSequence getLine2Text() {
        return new StringBuilder("VIN："+getShelf_id());
    }

    @Override
    public CharSequence getLine3Text() {
        return getEnter_name();
    }

    public String getCheck_name() {
        return StringUtil.changeNullDefault(check_name);
    }

    public void setCheck_name(String check_name) {
        this.check_name = check_name;
    }

    public String getErr_msg() {
        return StringUtil.changeNullDefault(err_msg);
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }
}
