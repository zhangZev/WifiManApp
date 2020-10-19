package com.wanzhong.data.po;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;

import java.util.List;

public class FollowResQueryListPagePo<T> extends BasePo {
    private String followNum;
    private String followRate;

    private int count;
    private int totalPage;
    private List<T> query;

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

    public String getFollowNum() {
        return StringUtil.changeNullDefault(followNum);
    }

    public void setFollowNum(String followNum) {
        this.followNum = followNum;
    }

    public String getFollowRate() {
        return StringUtil.changeNullDefault(followRate);

    }

    public void setFollowRate(String followRate) {
        this.followRate = followRate;
    }
}



