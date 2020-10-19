package com.wanzhong.data.po.inter;

import java.io.Serializable;

public class InterPeasListPo implements Serializable {

    /**
     * ref_desc : 兑换抵用卷
     * chg_wdou : 1000
     * createdt : 2019-09-09 09:08
     */

    private String ref_desc;
    private String chg_wdou;
    private String createdt;

    public String getRef_desc() {
        return ref_desc;
    }

    public void setRef_desc(String ref_desc) {
        this.ref_desc = ref_desc;
    }

    public String getChg_wdou() {
        return chg_wdou;
    }

    public void setChg_wdou(String chg_wdou) {
        this.chg_wdou = chg_wdou;
    }

    public String getCreatedt() {
        return createdt;
    }

    public void setCreatedt(String createdt) {
        this.createdt = createdt;
    }
}
