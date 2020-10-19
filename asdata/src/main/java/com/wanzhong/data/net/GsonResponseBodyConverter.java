package com.wanzhong.data.net;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.wanzhong.core.BaseApp;
import com.wanzhong.core.utils.SharePUtil;
import com.wanzhong.data.po.aswap.TokenBena;


import java.io.IOException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Converter;


final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> adapter;

    GsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.adapter = adapter;
    }


    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
            JsonParser parser = new JsonParser();
            JsonElement root = parser.parse(new JsonReader(value.charStream()));
            Log.e("====JSON", root.toString());
            if (root instanceof JsonObject) {
                JsonElement resultCodeEle = ((JsonObject) root).get("code");
                JsonElement errorMessage = ((JsonObject) root).get("msg");
                //JsonElement message = ((JsonObject) root).get("message");
                if (resultCodeEle instanceof JsonPrimitive) {
                    int resultCode = resultCodeEle.getAsInt();
                    //如果responseCode 不为 “0”，抛出 RuntimeException，或者自定义的异常类型
                    if (resultCode == -9999) {
                        getToken();
                    }
                }
            }
            return adapter.fromJsonTree(root);
        } finally {
            value.close();
        }
    }

    private void getToken() {
        String address = SharePUtil.getInstance(BaseApp.getInstance()).getString(SharePUtil.WADDRESS);
        if (!TextUtils.isEmpty(address)) {
            RetrofitProvider.getAdminApiInstance().getToken()
                    .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new BaseSubscriber<TokenBena>(false) {
                        @Override
                        public void onNext(TokenBena retPo) {
                            super.onNext(retPo);
                            if (retPo.isResultOk()) {
                                if (retPo.getData() != null) {
                                    SharePUtil.getInstance(BaseApp.getInstance()).putString(SharePUtil.TOKEN, retPo.getData());
                                }
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            super.onError(e);
                        }

                    });
        }
    }

}