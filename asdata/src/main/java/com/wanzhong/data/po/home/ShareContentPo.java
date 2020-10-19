package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;

/**
 *  {
 *     "subTitle": "",
 *     "icon": "https://teststatic.wanzhong.xin/appIcon/home.png",
 *     "keyId": "1a50a669d4184ea08604002c48ca006e",
 *     "title": "小黄向您推荐15辆好车，万众认证值得购买——老干爹辣椒",
 *     "url": "https://testwww.wanzhong.xin/wzweb/wd/carList?wdId=20190604000004&refUser=20190604000004&keyId=1a50a669d4184ea08604002c48ca006e"
 *   },
 * */
public class ShareContentPo extends BasePo {
    private String keyId;
    private String title;
    private String subTitle;
    private String icon;
    private String url;

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getTitle() {
        return StringUtil.changeNull(title)
                ;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return StringUtil.changeNull(subTitle);
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getIcon() {
        return StringUtil.changeNull(icon);
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return StringUtil.changeNull(url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
