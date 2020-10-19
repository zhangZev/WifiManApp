package com.wanzhong.data.net;

import android.text.TextUtils;
import android.util.Log;

import com.wanzhong.common.util.StringUtil;
import com.wanzhong.core.BaseApp;
import com.wanzhong.core.utils.BaseConsts;
import com.wanzhong.core.utils.CommonUtil;
import com.wanzhong.core.utils.NetWorkUtil;
import com.wanzhong.core.utils.SPUtil;
import com.wanzhong.data.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * 开发者: ZhangZev
 * 时间: 2019/1/25 16:54
 * 描述：网络请求工具类
 */

public class RetrofitProvider {
    private static final String TAG = "HTTP";
    private static Retrofit retrofit;
    private static Retrofit mAdminretrofit;

    private static BaseAppApis appApis;
    private static AdminApis mAdminApis;


    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = chain -> {

        Response originalResponse = chain.proceed(chain.request());
        if (TextUtils.isEmpty(chain.request().headers().get("Cache-Control"))) {
            return originalResponse;
        }
        if (NetWorkUtil.isNetWorkAvailable(BaseApp.getInstance())) {
            int maxAge = 60 * 5; // 在线缓存在5分钟内可读取
            return originalResponse.newBuilder().header("Cache-Control", "public, max-age=" +
                    maxAge).build();
        } else {
            int maxStale = 60 * 60 * 60; // 离线时缓存保存1小时
            Log.i("CACHE", "离线缓存");
            return originalResponse.newBuilder().header("Cache-Control", "public, only-if-cached," +
                    "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + " max-stale=" +
                    maxStale).build();
        }
    };

    private static File httpCacheDirectory = new File(BaseApp.getInstance().getCacheDir(),
            "WzCache");
    private static int cacheSize = 10 * 1024 * 1024; // 10 MiB
    private static Cache cache = new Cache(httpCacheDirectory, cacheSize);

    private RetrofitProvider() {
    }

    private static String mBaseUrl;

    private static String getBaseUrl() {
        if (StringUtil.isNullOrSpace(mBaseUrl)) {
            mBaseUrl = (String) SPUtil.getInstant(BaseApp.getInstance()).get(BaseConsts.Pref.BASE_URL, BaseApp.getInstance().getApplicationContext().getString(R.string.base_url));
            if (StringUtil.isNullOrSpace(mBaseUrl)) {
                mBaseUrl = BaseApp.getInstance().getApplicationContext().getString(R.string.base_url);
            }
        }
        return mBaseUrl;
    }


    public static void resetBaseUrl(String url) {
        SPUtil.getInstant(BaseApp.getInstance()).save(BaseConsts.Pref.BASE_URL, url);
        mBaseUrl = null;
    }

    private static Retrofit getInstance() {
        if (retrofit == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message -> {
                CommonUtil.log(TAG, message);
                //Log.e("HTTP", message);
            });
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().
                    addInterceptor(new CommonInterceptor()).
                    addInterceptor(httpLoggingInterceptor)
                    .connectTimeout(5, TimeUnit.MINUTES)
                    .readTimeout(5, TimeUnit.MINUTES)
                    .writeTimeout(5, TimeUnit.MINUTES).build();
            //此处调用setCertificates设置证书
            retrofit = new Retrofit.Builder().baseUrl(getBaseUrl()).client(client).addConverterFactory
                    (CustomGsonConverterFactory.create()).addCallAdapterFactory
                    (RxJava2CallAdapterFactory.create()).build();
        }
        return retrofit;
    }

    private static Retrofit getAdminInstance() {
        if (mAdminretrofit == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message -> {
                CommonUtil.log(TAG, message);
                //Log.e("HTTP", message);
            });
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().
                    addInterceptor(new CommonInterceptor()).
                    addInterceptor(httpLoggingInterceptor)
                    .connectTimeout(5, TimeUnit.MINUTES)
                    .readTimeout(5, TimeUnit.MINUTES)
                    .writeTimeout(5, TimeUnit.MINUTES).build();
            //此处调用setCertificates设置证书
            mAdminretrofit = new Retrofit.Builder().baseUrl(getBaseUrl()).client(client).addConverterFactory
                    (CustomGsonConverterFactory.create()).addCallAdapterFactory
                    (RxJava2CallAdapterFactory.create()).build();
        }
        return mAdminretrofit;
    }

    /**
     * 通过okhttpClient来设置证书
     *
     * @param clientBuilder OKhttpClient.builder
     * @param certificates  读取证书的InputStream
     */
    public void setCertificates(OkHttpClient.Builder clientBuilder, InputStream... certificates) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int index = 0;
            for (InputStream certificate : certificates) {
                String certificateAlias = Integer.toString(index++);
                keyStore.setCertificateEntry(certificateAlias, certificateFactory
                        .generateCertificate(certificate));
                try {
                    if (certificate != null)
                        certificate.close();
                } catch (IOException e) {
                }
            }
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(
                    TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:"
                        + Arrays.toString(trustManagers));
            }
            X509TrustManager trustManager = (X509TrustManager) trustManagers[0];
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            clientBuilder.sslSocketFactory(sslSocketFactory, trustManager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BaseAppApis getApiInstance() {
        if (appApis == null) {
            appApis = getInstance().create(BaseAppApis.class);
        }
        return appApis;
    }

    public static AdminApis getAdminApiInstance() {
        if (mAdminApis == null) {
            mAdminApis = getInstance().create(AdminApis.class);
        }
        return mAdminApis;
    }

}
/*
        ┏┛┻━━━┛┻┓
        ┃｜｜｜｜｜｜｜┃
        ┃　　　━　　　┃
        ┃　┳┛ 　┗┳ 　┃
        ┃　　　　　　　┃
        ┃　　　┻　　　┃
        ┃　　　　　　　┃
        ┗━┓　　　┏━┛
        　　┃　史　┃　　
        　　┃　诗　┃　　
        　　┃　之　┃　　
        　　┃　宠　┃
        　　┃　　　┗━━━┓
        　　┃神宠镇楼  　 ┣┓
        　　┃BUG滚犊子    |
        　　┗┓┓┏━┳┓┏┛
        　　　┃┫┫　┃┫┫
        　　　┗┻┛　┗┻┛*/
