package com.wanzhong.data.po;

import com.wanzhong.common.po.ComRequestPo;

public class LoginPo extends ComRequestPo {

    private String loginId;
    private String passwd;
    public String getLoginId() {
        return loginId;
    }
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
