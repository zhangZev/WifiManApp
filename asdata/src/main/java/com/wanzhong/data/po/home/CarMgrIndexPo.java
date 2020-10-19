package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;

import java.util.List;

/**
 * {
 *         "zsnum": "在售数量",
 *         "djnum": "订金数量",
 *         "ysnum": "已售数量",
 *         "operSets": 权限数组，要么有0，要么无，有0显示发车按钮[
 *             0
 *         ],
 *         "mycy": "我发布的车源数量",
 *         "allcy": “全部发布的车源数量”
 *     }*/
public class CarMgrIndexPo extends BasePo {

    private String zsnum;
    private String djnum;
    private String ysnum;
    private List<String> operSets;
    private String mycy;
    private String allcy;
    private String wdName;
    private String wdId;

    public String getZsnum() {
        return StringUtil.changeNull(zsnum);
    }

    public void setZsnum(String zsnum) {
        this.zsnum = zsnum;
    }

    public String getDjnum() {
        return StringUtil.changeNull(djnum);
    }

    public void setDjnum(String djnum) {
        this.djnum = djnum;
    }

    public String getYsnum() {
        return StringUtil.changeNull(ysnum);
    }

    public void setYsnum(String ysnum) {
        this.ysnum = ysnum;
    }

    public List<String> getOperSets() {
        return operSets;
    }

    public boolean canPubCar(){
        if(getOperSets() != null && getOperSets().size() == 1 && SysContants.CHAR_0.equals(getOperSets().get(0))){
            return true;
        }
        return false;
    }
    public void setOperSets(List<String> operSets) {
        this.operSets = operSets;
    }

    public String getMycy() {
        return StringUtil.changeNull(mycy);
    }

    public void setMycy(String mycy) {
        this.mycy = mycy;
    }

    public String getAllcy() {
        return StringUtil.changeNull(allcy);
    }

    public void setAllcy(String allcy) {
        this.allcy = allcy;
    }

    public String getWdName() {
        return StringUtil.changeNull(wdName,"车辆管理");
    }

    public void setWdName(String wdName) {
        this.wdName = wdName;
    }

    public String getWdId() {
        return StringUtil.changeNull(wdId);
    }

    public void setWdId(String wxId) {
        this.wdId = wxId;
    }
}
