package com.wanzhong.data.po;

import com.wanzhong.common.po.BasePo;

public class HeaderSupportBasePo extends BasePo {

    private String headerName;

    private String text;

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
