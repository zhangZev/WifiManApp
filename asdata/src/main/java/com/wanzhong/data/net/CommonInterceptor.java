package com.wanzhong.data.net;

/**
 * 开发者: ZhangZev
 * 时间: 2019/1/21
 * 描述：
 */


import android.text.TextUtils;

import com.wanzhong.common.util.SysContants;
import com.wanzhong.core.BaseApp;
import com.wanzhong.core.utils.CommonUtil;
import com.wanzhong.core.utils.SharePUtil;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * 封装公共参数（Key和密码）
 * <p>
 */
public class CommonInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();

        //模块名称截取完成
        String token = SharePUtil.getInstance(BaseApp.getInstance()).getString(SharePUtil.TOKEN);
        if (token == null) {
            token = "";
        }
        String address = SharePUtil.getInstance(BaseApp.getInstance()).getString(SharePUtil.WADDRESS);
        if (address == null) {
            address = "";
        }
        String lang = SharePUtil.getInstance(BaseApp.getInstance()).getString(SharePUtil.LANGUAGE);
        if (lang == null) {
            lang = "CN";
        }

        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                .newBuilder()
                .scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host());
        RequestBody formBody = oldRequest.body();
        if (formBody instanceof FormBody) {
            FormBody.Builder bodyBuilder = new FormBody.Builder();
            for (int i = 0; i < ((FormBody) oldRequest.body()).size(); i++) {
                bodyBuilder.addEncoded(((FormBody) oldRequest.body()).encodedName(i), ((FormBody) oldRequest.body()).encodedValue(i));
            }
            formBody = bodyBuilder
                    .addEncoded(SysContants.TOKEN_ID, token)
                    .addEncoded(SysContants.USER_ID, address)
                    .addEncoded("lang", lang)
                    .build();
            CommonUtil.log("HTTP", "formBody.toString()  " + formBody.toString());
        } else {
            authorizedUrlBuilder.addQueryParameter(SysContants.USER_ID, address)
                    .addQueryParameter(SysContants.TOKEN_ID, token);
        }

        // 新的请求
        Request newRequest2 = oldRequest.newBuilder()
                .method(oldRequest.method(), formBody)
                .url(authorizedUrlBuilder.build())
                .build();

        return chain.proceed(newRequest2);
        /*}*/


    }

    private boolean canInjectIntoBody(Request request) {
        if (request == null) {
            return false;
        }
        if (!TextUtils.equals(request.method(), "POST")) {
            return false;
        }
        RequestBody body = request.body();
        if (body == null) {
            return false;
        }
        MediaType mediaType = body.contentType();
        if (mediaType == null) {
            return false;
        }
        if (!TextUtils.equals(mediaType.subtype(), "x-www-form-urlencoded")) {
            return false;
        }
        return true;
    }

    private String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }
}
