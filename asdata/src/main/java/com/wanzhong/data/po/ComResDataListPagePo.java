package com.wanzhong.data.po;


import com.wanzhong.data.po.admin.AnalysisVinEntity;

import java.util.List;

public class ComResDataListPagePo<T> extends ComRespPo {

    private String count;
    private String totalPage;
    private List<T> data;
    private List<T> tokens;

    public List<T> getTokens() {
        return tokens;
    }

    public void setTokens(List<T> tokens) {
        this.tokens = tokens;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
