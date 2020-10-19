package com.wanzhong.data.po.me;

import com.wanzhong.data.po.home.CarInQueryCarPo;

public class CarInStaffCarListPo extends CarInQueryCarPo {
    @Override
    public CharSequence getLine2Text() {
        return null;
    }

    @Override
    public CharSequence getLine3Text() {
        return getBegin_register_dt()+" | "+getTravel_mileage()+"万公里";
    }
}
