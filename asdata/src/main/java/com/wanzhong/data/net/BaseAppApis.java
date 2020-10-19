package com.wanzhong.data.net;

import com.wanzhong.data.po.ComResDataListPagePo;
import com.wanzhong.data.po.FileUploadRespPo;
import com.wanzhong.data.po.VersionRespPo;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

public interface BaseAppApis {

    //登录
    @FormUrlEncoded
    @POST("login/login")
    Observable test(@FieldMap Map<String, String> options);

    /**上传文件*/
    @Multipart
    @POST("common/uploadFile")
    @Streaming
    Observable<ComResDataListPagePo<FileUploadRespPo>> uploadFile(@Part MultipartBody.Part file);

    /**上传多文件*/
    @Multipart
    @POST("common/uploadFile")
    Call<ComResDataListPagePo<FileUploadRespPo>> uploadFile(@PartMap Map<String, RequestBody> files);

    //版本更新
    @POST("common/appVersionUpdate")
    Observable<VersionRespPo> appVersionUpdate(@Query("keyId") int keyId);
}