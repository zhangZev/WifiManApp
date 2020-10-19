package com.wanzhong.data.po.home;

import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;
import com.wanzhong.data.po.HeaderSupportBasePo;

public class CarSelectItemPo extends HeaderSupportBasePo {

    /*public static final String ID_ALL_TRADE_MARK = "-1";
    public static final String ID_ALL_DEMIO = "-2";
    public static final String ID_ALL_TYPE = "-3";*/

    private String parentId;
    //是不是全选功能
    private boolean selectAll = false;
    private String logo;
    private String id;
    private String name;

    public String getLevel() {
        if(this instanceof CarBrandSelectTradeMarkPo){
            return SysContants.CHAR_1;
        } else if(this instanceof CarBrandSelectDemioPo){
            return SysContants.CHAR_2;
        } else if(this instanceof  CarBrandSelectTypePo){
            return SysContants.CHAR_3;
        }
        return SysContants.CHAR_0;
    }


    public String getLogo() {
        return logo;
    }

    public void setLogo(String img) {
        this.logo = img;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getText() {
        return getName();
    }

    @Override
    public void setText(String text) {
        setName(text);
    }

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return StringUtil.changeNull(id);
    }


    public boolean isSelectAll() {
        return selectAll;
    }

    public void setSelectAll(boolean selectAll) {
        this.selectAll = selectAll;
    }

    public String getParentId() {
        return StringUtil.changeNull(parentId);
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    private String uuid;
    public String getUUID(){
        if(StringUtil.isNullOrSpace(uuid)){
            uuid = new StringBuffer(getLevel()).append(SysContants.CHAR_UNLINE).append(getParentId()).append(SysContants.CHAR_UNLINE).append(getId()).toString();
        }
        return uuid;
    }
}
