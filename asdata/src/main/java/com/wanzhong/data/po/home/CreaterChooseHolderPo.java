package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;

import java.util.List;

/**
 * 响应数据主体{
 *         "staff_users": 销售员工集合[
 *             {
 *                 "user_id": "用户id",
 *                 "user_name": "用户姓名",
 *                 "role_type": “用户角色（0 超级管理员 1 管理员 2 员工）”
 *             }
 *         ],
 *         "man_users": 管理员集合[
 *             {
 *                 "user_id": "用户id",
 *                 "user_name": "用户姓名",
 *                 "role_type": “用户角色（0 超级管理员 1 管理员 2 员工）”
 *             }
 *         ],
 *         "all_users": 全部集合[
 *             {
 *                 "user_id": "用户id",
 *                 "user_name": "用户姓名",
 *                 "role_type": “用户角色（0 超级管理员 1 管理员 2 员工）”
 *             }
 *         ],
 *         "man_num": 管理员数量,
 *         "staff_num": 销售员工数量,
 *         "all_num": 全部数量
 *     }
 * */
public class CreaterChooseHolderPo extends BasePo {

    private List<CreaterChooseItemPo> staff_users;

    private List<CreaterChooseItemPo> man_users;

    private String man_num;

    private String staff_num;

    private String all_num;

    public List<CreaterChooseItemPo> getStaff_users() {
        return staff_users;
    }

    public void setStaff_users(List<CreaterChooseItemPo> staff_users) {
        this.staff_users = staff_users;
    }

    public List<CreaterChooseItemPo> getMan_users() {
        return man_users;
    }

    public void setMan_users(List<CreaterChooseItemPo> man_users) {
        this.man_users = man_users;
    }

    public String getMan_num() {
        return StringUtil.changeNullInt(man_num);
    }

    public void setMan_num(String man_num) {
        this.man_num = man_num;
    }

    public String getStaff_num() {
        return StringUtil.changeNullInt(staff_num);
    }

    public void setStaff_num(String staff_num) {
        this.staff_num = staff_num;
    }

    public String getAll_num() {
        return StringUtil.changeNullInt(all_num);
    }

    public void setAll_num(String all_num) {
        this.all_num = all_num;
    }
}
