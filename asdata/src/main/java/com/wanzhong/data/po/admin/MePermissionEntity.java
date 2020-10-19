package com.wanzhong.data.po.admin;

import java.io.Serializable;

/**
 * @time:{2020/5/7}
 * @auhor:{ZhangXW}
 */
public class MePermissionEntity implements Serializable {

    /**
     * menuid : PK_APP_MENU_01
     * name : 盘库记录
     */

    private String menuid;
    private String name;

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
