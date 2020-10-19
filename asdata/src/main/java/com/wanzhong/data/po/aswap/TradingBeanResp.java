package com.wanzhong.data.po.aswap;

import java.io.Serializable;
import java.util.List;

/**
 * @time:{2020/9/27}
 * @auhor:{ZhangXW}
 */
public class TradingBeanResp implements Serializable {

    private int totalPage;
    private int count;
    private List<TradingBean> datas;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<TradingBean> getDatas() {
        return datas;
    }

    public void setDatas(List<TradingBean> datas) {
        this.datas = datas;
    }
}
