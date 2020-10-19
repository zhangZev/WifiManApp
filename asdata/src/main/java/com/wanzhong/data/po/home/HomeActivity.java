package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;

public class HomeActivity extends BasePo {
    private String pic;

    private String name;

    private String url;

    public String getPic() {
        return StringUtil.changeNullDefault(pic);
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return StringUtil.changeNullDefault(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return StringUtil.changeNull(url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
