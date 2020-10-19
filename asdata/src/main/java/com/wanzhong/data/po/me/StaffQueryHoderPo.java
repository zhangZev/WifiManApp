package com.wanzhong.data.po.me;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.SysContants;

import java.util.List;

/**
 *  {
 *         "staff": [
 *             {
 *                 "user_id": "用户id",
 *                 "user_name": "姓名",
 *                 "head_img": "头像地址",
 *                 "status": "状态（0启用，1停用）",
 *                 "role_type": "角色类型（0超级管理员，1管理员，2员工）",
 *                 "user_phone": "电话",
 *                 "add_car_num": 新增车辆数量,
 *                 "make_car_num": 成交车辆数量
 *             }
 *         ],
 *         "operSets": 权限数组，有0显示：新增员工，有1显示：修改[
 *             0,
 *             1
 *         ]
 * */
public class StaffQueryHoderPo extends BasePo {
    private List<StaffPo> staff;
    private String[] operSets;

    public List<StaffPo> getStaff() {
        return staff;
    }

    public void setStaff(List<StaffPo> staff) {
        this.staff = staff;
    }

    public String[] getOperSets() {
        return operSets;
    }

    public void setOperSets(String[] operSets) {
        this.operSets = operSets;
    }

    public boolean canAddStaff(){
        boolean canAdd = false;
        if(operSets != null && operSets.length > 0){
            for(int i = 0 ; i < operSets.length ; i++){
                if(SysContants.CHAR_0.equals(operSets[i])){
                    canAdd = true;
                    break;
                }
            }
        }
        return canAdd;
    }


    public boolean canEditStaff(){
        boolean canAdd = false;
        if(operSets != null && operSets.length > 0){
            for(int i = 0 ; i < operSets.length ; i++){
                if(SysContants.CHAR_1.equals(operSets[i])){
                    canAdd = true;
                    break;
                }
            }
        }
        return canAdd;
    }
}
