package com.wanzhong.data.po.inter;

import java.io.Serializable;
import java.util.List;

public class InterGoodsPagePo implements Serializable {
    public List<InterGoodsPo> datas;
    public int totalPage;
    public int count;
}
