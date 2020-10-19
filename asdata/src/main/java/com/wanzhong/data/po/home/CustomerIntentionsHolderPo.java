package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;

import java.util.List;

/**
 * "customer_need": 意向车型集合[
 *             {
 *                 "cars": 车辆集合[
 *                     {
 *                         "series_id": "意向车型名称id",
 *                         "car_brand_name": "车辆品牌名称",
 *                         "car_series_name": "车辆车系名称",
 *                         "car_specimens_name": "车辆车型名称",
 *                         "cover_chart": "车辆封面缩略图",
 *                         "begin_register_dt": "初次上牌，格式2019/02",
 *                         "travel_mileage": 里程数，单位万,
 *                         "car_price": 标价，单位万,
 *                         "car_id": “车辆id”
 *                     }
 *                 ],
 *                 "name": “意向车型名称”
 *             }
 *         ]
 * */
public class CustomerIntentionsHolderPo extends BasePo {

    private List<CustomerIntentionsPo> customer_need;

    public List<CustomerIntentionsPo> getCustomer_need() {
        return customer_need;
    }

    public void setCustomer_need(List<CustomerIntentionsPo> customer_need) {
        this.customer_need = customer_need;
    }
}
