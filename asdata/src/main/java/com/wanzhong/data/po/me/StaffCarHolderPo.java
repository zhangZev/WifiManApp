package com.wanzhong.data.po.me;

import com.wanzhong.common.util.StringUtil;
import com.wanzhong.data.po.ComResQueryListPagePo;

/**
 *
 * {
 *     "data": {
 *         "amount": 数量,
 *         "total_prices": 总价（单位万）,
 *         "totalPage": 总页码,
 *         "query": [
 *             {
 *                 "car_id": "车辆id",
 *                 "cover_chart": "封面图",
 *                 "car_brand_name": "品牌名称",
 *                 "car_series_name": "车系名称",
 *                 "car_specimens_name": "车型名称",
 *                 "begin_register_dt": "初次上牌（格式2019/08）",
 *                 "travel_mileage": 里程数（单位万）,
 *                 "car_price": 销售价格（单位万）,
 *                 "status": “状态（0在售，1预订，2已售）”
 *             }
 *         ],
 *         "count": 总条数
 *     },
 *     "retCode": "000000",
 *     "retMsg": “”
 * }
 */
public class StaffCarHolderPo<T> extends ComResQueryListPagePo<T> {

    private String amount;
    private String total_prices;

    public String getAmount() {
        return StringUtil.changeNullDefault(amount);
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTotal_prices() {
        return StringUtil.formatDecimal2(total_prices);
    }

    public void setTotal_prices(String total_prices) {
        this.total_prices = total_prices;
    }
}
