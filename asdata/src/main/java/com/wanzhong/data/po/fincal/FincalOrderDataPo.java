package com.wanzhong.data.po.fincal;

import java.io.Serializable;
import java.util.List;

/**
 * 库融详情
 */
public class FincalOrderDataPo implements Serializable {
    public List<FincalCarInfoPo> cars;
    public List<FincalOrderPlanPo> periods;
    public SingalOrderPo orderDetail;
}
