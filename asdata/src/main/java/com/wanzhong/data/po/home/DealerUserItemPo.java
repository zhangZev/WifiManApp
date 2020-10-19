package com.wanzhong.data.po.home;

import com.wanzhong.common.util.StringUtil;

/**
 * 车商销售归属列表
 * {
 *             "sales_id": "销售id(用户id)",
 *             "sales_name": “销售姓名”
 *         }
 * */
public class DealerUserItemPo extends SimpleSingleChooseItemPo {

    private String sales_id;
    private String sales_name;

    public String getSales_id() {
        return StringUtil.changeNull(sales_id);
    }

    public void setSales_id(String sales_id) {
        this.sales_id = sales_id;
    }

    public String getSales_name() {
        return StringUtil.changeNullDefault(sales_name);
    }

    public void setSales_name(String sales_name) {
        this.sales_name = sales_name;
    }

    @Override
    public String getId() {
        return getSales_id();
    }

    @Override
    public String getText() {
        return getSales_name();
    }
}
