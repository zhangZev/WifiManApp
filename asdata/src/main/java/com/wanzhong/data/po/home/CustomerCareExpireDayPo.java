package com.wanzhong.data.po.home;

import com.wanzhong.common.util.StringUtil;

/**
 *  {
 *                 "car_id": "车辆id",
 *                 "car_brand_name": "品牌名称",
 *                 "car_series_name": "车系名称",
 *                 "shelf_id": "VIN码",
 *                 "grade": "客户等级（0其他1H级2A级3B级4C级5无效6成交）",
 *                 "ucname": "客户姓名",
 *                 "phone": "客户电话",
 *                 "weixin": 客户微信,
 *                 "customer_id": "客户id",
 *                 "expire_data": "保险到期日（格式：09/04）",
 *                 "create_name": “销售姓名”
 *             }
 * */
public class CustomerCareExpireDayPo extends CustomerCareBirthDayPo {

    private String car_id;
    private String car_brand_name;
    private String car_series_name;
    private String shelf_id;

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getCar_brand_name() {
        return StringUtil.changeNullDefault(car_brand_name);
    }

    public void setCar_brand_name(String car_brand_name) {
        this.car_brand_name = car_brand_name;
    }

    public String getCar_series_name() {
        return StringUtil.changeNullDefault(car_series_name);
    }

    public void setCar_series_name(String car_series_name) {
        this.car_series_name = car_series_name;
    }

    public String getShelf_id() {
        return StringUtil.changeNullDefault(shelf_id);
    }

    public void setShelf_id(String shelf_id) {
        this.shelf_id = shelf_id;
    }
}
