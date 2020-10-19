package com.wanzhong.data.po.fincal;

import java.io.Serializable;
import java.util.List;

public class CarDetailsDataPo implements Serializable {
    public CarDetailsPo carDetail;
    //库融详情有这个
    public List<FincalCarInfoPo> hisCars;
}
