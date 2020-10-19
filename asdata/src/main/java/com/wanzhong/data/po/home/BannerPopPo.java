package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;

/**
 * :{"pic":"http://10.10.20.52:8062/common/queryFile?keyId=5d8b1616be782643b27f8d08","name":"官微9月首绑礼：领最高5000元现金红包1！","url":"https://www.kameng98.com/youhui
 * /details/47911"}
 * */
public class BannerPopPo extends BasePo {
    private String pic;
    private String name;
    private String url;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
