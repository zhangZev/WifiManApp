package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.core.interfaces.CommImgTvViewData;
import com.wanzhong.data.po.scar.ScarDetailsPo;

/**
 * {
 *         "car": 车辆信息{
 *             "car_img": "车辆封面缩略图",
 *             "trademark": "品牌名称",
 *             "demio_name": "车系名称",
 *             "motorcycle_type": "车型名称",
 *             "begin_register_dt": "2019/08",
 *             "travel_mileage": "200公里数",
 *             "status": “状态（0 在售 1 预订 2 已售）”
 *         },
 *         "customer": 客户信息（车辆状态为1预定时才会有）{
 *             "customer_id": "客户id",
 *             "customer_name": "客户姓名",
 *             "customer_phone": "客户电话",
 *             "source_id": "客户来源id",
 *             "source_name": "客户来源名称",
 *             "reserve_amount": “订金（单位元）”
 *         }
 *     }
 * */
public class CarSellInfoPo extends BasePo {

    private CarDetailSellInfoPo car;

    private CustomerSellInfoPo customer;

    public class CarDetailSellInfoPo extends ScarDetailsPo implements CommImgTvViewData {
        private String cover_chart;

        public String getCover_chart() {
            return cover_chart;
        }

        public void setCover_chart(String cover_chart) {
            this.cover_chart = cover_chart;
        }

        @Override
        public CharSequence getLine1Text() {
            return getMotorcycle_type();
        }

        @Override
        public CharSequence getLine2Text() {
            return getBegin_register_dt() +"  |  "+getTravel_mileage() +"公里";
        }

        @Override
        public CharSequence getLine3Text() {
            return null;
        }

        @Override
        public CharSequence getLine4Text() {
            return null;
        }

        @Override
        public CharSequence getLine5Text() {
            return null;
        }

        @Override
        public CharSequence getLine6Text() {
            return null;
        }

        @Override
        public String getImagePath() {
            return getCover_chart();
        }

        @Override
        public boolean showImg() {
            return true;
        }
    }

    public class CustomerSellInfoPo extends CustomerDetailPo {
        private String reserve_amount;

        public String getReserve_amount() {
            return reserve_amount;
        }

        public void setReserve_amount(String reserve_amount) {
            this.reserve_amount = reserve_amount;
        }
    }

    public CarDetailSellInfoPo getCar() {
        return car;
    }

    public void setCar(CarDetailSellInfoPo car) {
        this.car = car;
    }

    public CustomerSellInfoPo getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerSellInfoPo customer) {
        this.customer = customer;
    }
}
