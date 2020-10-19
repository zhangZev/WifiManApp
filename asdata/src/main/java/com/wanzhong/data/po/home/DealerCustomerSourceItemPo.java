package com.wanzhong.data.po.home;

import com.wanzhong.common.util.StringUtil;

/**
 * {
 *                 "source_name": "名称",
 *                 "source_id": "主键",
 *                 "is_common": “是否常用：0是1否”
 *             }
 * */
public class DealerCustomerSourceItemPo extends SimpleSingleChooseItemPo {

    private String source_name;

    private String source_id;

    private String is_common;

    public String getSource_name() {
        return StringUtil.changeNullDefault(source_name);
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getSource_id() {
        return StringUtil.changeNull(source_id);
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getIs_common() {
        return StringUtil.changeNullInt(is_common);
    }

    public void setIs_common(String is_common) {
        this.is_common = is_common;
    }

    @Override
    public String getId() {
        return getSource_id();
    }

    @Override
    public void setId(String id) {
        setSource_id(id);
    }

    @Override
    public String getText() {
        return getSource_name();
    }

    @Override
    public void setText(String text) {
        setSource_name(text);
    }
}
