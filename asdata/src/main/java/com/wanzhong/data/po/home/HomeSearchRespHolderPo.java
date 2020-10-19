package com.wanzhong.data.po.home;

import com.wanzhong.data.po.ComResQueryListPagePo;

/**
 *
 * {
 *     "data": 响应数据主体{
 *         "totalPage": 总页码,
 *         "countCar": 车型数量,
 *         "countCustomer": 客户数量,
 *         "countVIN": 车辆数量
 *         "query": [
 *         ],
 *         "count": 总条数
 *     },
 *     "retCode": "000000",
 *     "retMsg": “”
 * }
 * */
public class HomeSearchRespHolderPo<T> extends ComResQueryListPagePo<T> {

    private String countCar;
    private String countCustomer;
    private String countVIN;

    public String getCountCar() {
        return countCar;
    }

    public void setCountCar(String countCar) {
        this.countCar = countCar;
    }

    public String getCountCustomer() {
        return countCustomer;
    }

    public void setCountCustomer(String countCustomer) {
        this.countCustomer = countCustomer;
    }

    public String getCountVIN() {
        return countVIN;
    }

    public void setCountVIN(String countVIN) {
        this.countVIN = countVIN;
    }


}
