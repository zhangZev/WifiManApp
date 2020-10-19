package com.wanzhong.data.po;


public class ComResDataPo<T> extends ComRespPo {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
