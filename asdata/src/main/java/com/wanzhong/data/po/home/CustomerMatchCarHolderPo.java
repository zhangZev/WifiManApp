package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;

import java.util.List;

/**
 * {
 *         "all_car": 所有车辆集合[
 *             {
 *                 "cover_chart": "封面图",
 *                 "car_brand_name": "品牌",
 *                 "car_series_name": "车系",
 *                 "car_specimens_name": "车型",
 *                 "begin_register_dt": "上牌日期，格式2019年02月",
 *                 "travel_mileage": 里程数，单位万,
 *                 "car_price": 标价，单位万,
 *                 "car_id": “车辆id”
 *             }
 *         ],
 *         "shop_car": 本店车辆集合[
 *             {
 *                 "cover_chart": "封面图",
 *                 "car_brand_name": "品牌",
 *                 "car_series_name": "车系",
 *                 "car_specimens_name": "车型",
 *                 "begin_register_dt": "上牌日期，格式2019年02月",
 *                 "travel_mileage": 里程数，单位万,
 *                 "car_price": 标价，单位万,
 *                 "car_id": “车辆id”
 *             }
 *         ],
 *         "shop_num": "本店数量",
 *         "all_num": “所有数量”
 *     }
 * */
public class CustomerMatchCarHolderPo extends BasePo {

    private List<CarBySeriesNamePo> all_car;

    private List<CarBySeriesNamePo> shop_car;

    private String shop_num;

    private String all_num;

    public List<CarBySeriesNamePo> getAll_car() {
        return all_car;
    }

    public void setAll_car(List<CarBySeriesNamePo> all_car) {
        this.all_car = all_car;
    }

    public List<CarBySeriesNamePo> getShop_car() {
        return shop_car;
    }

    public void setShop_car(List<CarBySeriesNamePo> shop_car) {
        this.shop_car = shop_car;
    }

    public String getShop_num() {
        return StringUtil.changeNullInt(shop_num);
    }

    public void setShop_num(String shop_num) {
        this.shop_num = shop_num;
    }

    public String getAll_num() {
        return StringUtil.changeNullInt(all_num);
    }

    public void setAll_num(String all_num) {
        this.all_num = all_num;
    }

    public int getShopNumInt(){
        int count = 0 ;
        try{
            count = Integer.parseInt(getShop_num());
        } catch (NumberFormatException e){

        }
        return count;
    }
    public int getAllNumInt(){
        int count = 0 ;
        try{
            count = Integer.parseInt(getAll_num());
        } catch (NumberFormatException e){

        }
        return count;
    }

}
