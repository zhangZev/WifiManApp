package com.wanzhong.data.po;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;

public class ComRespPo extends BasePo {

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isResultOk() {
        return code == 0;
    }

    public boolean isResultErr() {
        return code == -1;
    }

}
