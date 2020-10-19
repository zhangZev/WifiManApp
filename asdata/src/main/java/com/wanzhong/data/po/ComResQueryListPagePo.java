package com.wanzhong.data.po;


import com.wanzhong.common.po.BasePo;

import java.util.List;

public class ComResQueryListPagePo<T> extends BasePo {

    private int count;
    private int totalPage;
    private List<T> query;
    private List<T> datas;

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getQuery() {
        return query;
    }

    public void setQuery(List<T> query) {
        this.query = query;
    }
}
