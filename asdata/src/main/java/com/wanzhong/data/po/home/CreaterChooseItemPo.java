package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;

/**
 * {
 *                 "user_id": "用户id",
 *                 "user_name": "用户姓名",
 *                 "role_type": “用户角色（0 超级管理员 1 管理员 2 员工）”
 *             }
 * */
public class CreaterChooseItemPo extends BasePo {

    private String parentId;

    private boolean isGroup = false;

    private String user_id;
    private String role_type;
    private String user_name;
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String id) {
        this.user_id = id;
    }

    public String getText() {
        return getUser_name();
    }


    public String getRole_type() {
        return StringUtil.changeNull(role_type, SysContants.CHAR_2);
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }

    public String getUser_name() {
        return StringUtil.changeNullDefault(user_name);
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
