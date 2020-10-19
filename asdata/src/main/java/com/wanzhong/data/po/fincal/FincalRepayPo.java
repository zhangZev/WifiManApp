package com.wanzhong.data.po.fincal;

import java.io.Serializable;
import java.util.List;

/**
 * 还款记录
 */
public class FincalRepayPo implements Serializable {
    public List<FincalRepayListPo> datas;
    public int totalPage;
    public int count;
}
