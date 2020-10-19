package com.wanzhong.data.po.scar;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyCarResSubPo implements Serializable {

    /**
     * arg3 :
     * arg2 : 100万以上
     * arg1 : nullnullnull
     * datas : []
     * keyId : b693da12b1094835b690ff6b2051db1e
     * dataCount : 0
     */

    private String arg3;
    private String arg2;
    private String arg1;
    private String keyId;
    private int dataCount;
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

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
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
            if (!TextUtils.isEmpty(arg1)){
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
