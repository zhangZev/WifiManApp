package com.wanzhong.data.po.me;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;

public class StaffPo extends BasePo {

    private String user_id;
    private String user_phone;
    private String user_name;
    private String head_img;
    private String status;
    private String role_type;
    private String add_car_num;
    private String make_car_num;
    //以下是员工的
    private int dh;
    private int lq;
    private int sy;
    private int zs;

    public int getDh() {
        return dh;
    }

    public void setDh(int dh) {
        this.dh = dh;
    }

    public int getLq() {
        return lq;
    }

    public void setLq(int lq) {
        this.lq = lq;
    }

    public int getSy() {
        return sy;
    }

    public void setSy(int sy) {
        this.sy = sy;
    }

    public int getZs() {
        return zs;
    }

    public void setZs(int zs) {
        this.zs = zs;
    }

    public String getUser_phone() {
        return StringUtil.changeNull(user_phone);
    }

    public void setUser_phone(String phone) {
        this.user_phone = phone;
    }

    public String getUser_name() {
        return StringUtil.changeNullDefault(user_name);
    }

    public void setUser_name(String name) {
        this.user_name = name;
    }

    public String getUser_id() {
        return StringUtil.changeNull(user_id);
    }

    public void setUser_id(String uid) {
        this.user_id = uid;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getStatus() {
        return StringUtil.changeNull(status);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole_type() {
        return StringUtil.changeNull(role_type);
    }

    //（0超级管理员，1管理员，2员工）
    public String getRoleTypeShow(){
        if(SysContants.CHAR_0.equals(getRole_type())){
            return "超级管理员";
        } else if(SysContants.CHAR_1.equals(getRole_type())){
            return "管理员";
        } else if(SysContants.CHAR_2.equals(getRole_type())){
            return "员工";
        }
        return SysContants.CHAR_EMPTY;
    }
    public int getRoleTypeInt(){
        try{
            return Integer.parseInt(getRole_type());
        } catch (NumberFormatException e){

        }
        return 100;
    }
    public int getStatusInt(){
        try{
            return Integer.parseInt(getStatus());
        } catch (NumberFormatException e){

        }
        return 100;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }

    public String getAdd_car_num() {
        return StringUtil.changeNull(add_car_num);
    }

    public void setAdd_car_num(String add_car_num) {
        this.add_car_num = add_car_num;
    }

    public String getMake_car_num() {
        return StringUtil.changeNull(make_car_num);
    }

    public void setMake_car_num(String make_car_num) {
        this.make_car_num = make_car_num;
    }
}
