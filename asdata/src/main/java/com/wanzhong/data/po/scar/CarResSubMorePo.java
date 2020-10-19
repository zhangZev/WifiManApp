package com.wanzhong.data.po.scar;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CarResSubMorePo implements Serializable {

    /**
     * arg3 :
     * arg2 : 33-258万
     * arg1 : nullnullnull
     * datas : [{"thumbnail_img":"5cac17ce8721630f684eea11","trademark":"福特","demio_name":"锐界(进口)","motorcycle_type":"2012款 2.0T 精锐天窗版","begin_register_dt":"2019-08-06","travel_mileage":"200","amount":"808800","key_id":"20190828000001","status":"0","age":"0.0767"},{"thumbnail_img":"5cac17ce8721630f684eea11","trademark":"标致","demio_name":"标致5008","motorcycle_type":"2017款 350THP 7座无界版","begin_register_dt":"2019-08-06","travel_mileage":"200","amount":"808800","key_id":"20190828000004","status":"0","age":"0.0767"},{"thumbnail_img":"5cac17ce8721630f684eea11","trademark":"奥迪","demio_name":"奥迪R8","motorcycle_type":"2017款 V10 Spyder","begin_register_dt":"2019-08-06","travel_mileage":"200","amount":"808800","key_id":"20190828000005","status":"0","age":"0.0767"},{"thumbnail_img":"5cac17ce8721630f684eea11","trademark":"奥迪","demio_name":"奥迪R8","motorcycle_type":"2014款 4.2 FSI quattro","begin_register_dt":"2019-08-06","travel_mileage":"200","amount":"808800","key_id":"20190828000006","status":"0","age":"0.0767"},{"thumbnail_img":"5cac17ce8721630f684eea11","trademark":"奥迪","demio_name":"奥迪R8","motorcycle_type":"2012款 5.2 FSI quattro 限量版","begin_register_dt":"2019-08-06","travel_mileage":"200","amount":"808800","key_id":"20190828000007","status":"0","age":"0.0767"},{"thumbnail_img":"5cac17ce8721630f684eea11","trademark":"宝马","demio_name":"宝马5系","motorcycle_type":"2014款 535Li 领先型","begin_register_dt":"2019-08-06","travel_mileage":"200","amount":"808800","key_id":"20190828000008","status":"0","age":"0.0767"},{"thumbnail_img":"5cac17ce8721630f684eea11","trademark":"奔驰","demio_name":"奔驰C级(进口)","motorcycle_type":"2016款 C 200 4MATIC 旅行轿车","begin_register_dt":"2019-08-06","travel_mileage":"200","amount":"808800","key_id":"20190828000009","status":"0","age":"0.0767"},{"thumbnail_img":"5cac17ce8721630f684eea11","trademark":"奔驰","demio_name":"奔驰C级(进口)","motorcycle_type":"2016款 C 200 轿跑版","begin_register_dt":"2019-08-06","travel_mileage":"200","amount":"808800","key_id":"20190828000010","status":"0","age":"0.0767"},{"thumbnail_img":"5cac17ce8721630f684eea11","trademark":"奔驰","demio_name":"奔驰C级(进口)","motorcycle_type":"2017款 C 300 旅行轿车","begin_register_dt":"2019-08-06","travel_mileage":"200","amount":"808800","key_id":"20190828000011","status":"0","age":"0.0767"},{"thumbnail_img":"5cac17ce8721630f684eea11","trademark":"奔驰","demio_name":"奔驰C级(进口)","motorcycle_type":"2017款 改款 C 200 轿跑版","begin_register_dt":"2019-08-06","travel_mileage":"200","amount":"808800","key_id":"20190828000012","status":"0","age":"0.0767"}]
     * totalPage : 2
     * count : 19
     */

    private String arg3;
    private String arg2;
    private String arg1;
    private int totalPage;
    private int count;
    private List<CarResDetailsPo> datas;
    private List<String> mTypeList;

    public String getArg3() {
        return arg3;
    }

    public void setArg3(String arg3) {
        this.arg3 = arg3;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<CarResDetailsPo> getDatas() {
        return datas;
    }

    public void setDatas(List<CarResDetailsPo> datas) {
        this.datas = datas;
    }


    public List<String> getmTypeList() {
        if (mTypeList == null) {
            mTypeList = new ArrayList<>();
        }
        if (!TextUtils.isEmpty(arg1)) {
            if (arg1.contains("null")) {
                arg1 = arg1.replace("null", "");
            }
            if (!TextUtils.isEmpty(arg1)) {
                mTypeList.add(arg1);
            }
        }
        if (!TextUtils.isEmpty(arg2)) {
            mTypeList.add(arg2);
        }
        if (!TextUtils.isEmpty(arg3)) {
            mTypeList.add(arg3);
        }
        return mTypeList;
    }

    public void setmTypeList(List<String> mTypeList) {
        this.mTypeList = mTypeList;
    }
}
