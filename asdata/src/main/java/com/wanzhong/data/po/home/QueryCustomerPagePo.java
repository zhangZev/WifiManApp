package com.wanzhong.data.po.home;

import com.wanzhong.data.po.ComResQueryListPagePo;

public class QueryCustomerPagePo<T> extends ComResQueryListPagePo<T> {
    private QueryCustomerNumbsPo nums;

    public QueryCustomerNumbsPo getNums() {
        return nums;
    }

    public void setNums(QueryCustomerNumbsPo nums) {
        this.nums = nums;
    }
}
