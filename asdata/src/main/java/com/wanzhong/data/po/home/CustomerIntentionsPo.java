package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;

import java.util.List;

/**意向车型
 * {
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
 * */
public class CustomerIntentionsPo extends BasePo {

    private List<CarBySeriesNamePo> cars;

    private String name;

    public List<CarBySeriesNamePo> getCars() {
        return cars;
    }

    public void setCars(List<CarBySeriesNamePo> cars) {
        this.cars = cars;
    }

    public String getName() {
        return StringUtil.changeNullDefault(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
