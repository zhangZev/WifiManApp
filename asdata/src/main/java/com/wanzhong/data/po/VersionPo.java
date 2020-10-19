package com.wanzhong.data.po;

import android.content.Context;

import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;
import com.wanzhong.core.utils.BaseConsts;
import com.wanzhong.core.utils.CommonUtil;
import com.wanzhong.core.utils.SPUtil;

import java.io.Serializable;

/**
 * 开发者: ZhangZev
 * 时间: 2019/3/19
 * 描述：
 */
public class VersionPo implements Serializable {
    /**
     * "version_info": APP更新{
     *             "is_update": "是否需要更新，0是1否",
     *             "update_msg": “更新内容”
     *         }
     */

    private String is_compel;
    private String is_update;
    private String update_msg;
    private String download_link;
    private int versionCode;
    /**差分包起始版本*/
    private String patch_version;
    /**差分包下载地址*/
    private String patch_link;

    public String getIs_compel() {
        return StringUtil.changeNullInt(is_compel);
    }

    public void setIs_compel(String is_compel) {
        this.is_compel = is_compel;
    }

    public boolean isForceUpdate(){
        return SysContants.CHAR_0.equals(getIs_compel());
    }
    public String getUpdate_msg() {
        return StringUtil.changeNull(update_msg);
    }

    public void setUpdate_msg(String update_msg) {
        this.update_msg = update_msg;
    }


    public String getDownload_link() {
        return download_link;
    }

    public void setDownload_link(String download_link) {
        this.download_link = download_link;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getIs_update() {
        return StringUtil.changeNull(is_update);
    }

    public void setIs_update(String is_update) {
        this.is_update = is_update;
    }

    public boolean hasUpdate(){
        return SysContants.CHAR_0.equals(getIs_update());
    }

    public String getPatch_version() {
        return StringUtil.changeNull(patch_version,SysContants.CHAR_NEG_1);
    }

    public void setPatch_version(String patch_version) {
        this.patch_version = patch_version;
    }

    public String getPatch_link() {
        return StringUtil.changeNull(patch_link);
    }

    public void setPatch_link(String patch_link) {
        this.patch_link = patch_link;
    }

    public int getPatchVersionInt(){
        try{
            return Integer.parseInt(getPatch_version());
        } catch (NumberFormatException e){

        }
        return -1;
    }

    public boolean canUsePatch(Context context){
        return StringUtil.isNotNullAndSpace(getPatch_link()) && getPatchVersionInt() == CommonUtil.getVersionCode(context) && (boolean)SPUtil.getInstant(context).get(BaseConsts.Pref.PATCH_NEVER_FAILED,true);
    }


}
