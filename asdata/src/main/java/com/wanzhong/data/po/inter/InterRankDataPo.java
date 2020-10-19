package com.wanzhong.data.po.inter;

import java.io.Serializable;
import java.util.List;

public class InterRankDataPo implements Serializable {
    public List<InterRankPo> rankings;
    public int currentRanking;//当前用户排名
}
