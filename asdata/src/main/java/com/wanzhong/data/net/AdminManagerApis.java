package com.wanzhong.data.net;

import com.wanzhong.data.po.ComResDataListPagePo;
import com.wanzhong.data.po.ComResDataPo;
import com.wanzhong.data.po.ComResQueryListPagePo;
import com.wanzhong.data.po.ComRespPo;
import com.wanzhong.data.po.FileUploadRespPo;
import com.wanzhong.data.po.admin.CarInfoListEntity;
import com.wanzhong.data.po.admin.CarRecordEntity;
import com.wanzhong.data.po.admin.CarReplaceEntity;
import com.wanzhong.data.po.admin.ComRespForCar;
import com.wanzhong.data.po.admin.MePermissionEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

/**
 * 管理端模块接口
 */
public interface AdminManagerApis {

    // TODO 以下是评估的接口

    /**
     * 查询车辆补录列表
     */
    @FormUrlEncoded
    @POST("wzapp/assess/queryAssess")
    Observable<ComResDataPo<ComResQueryListPagePo<CarRecordEntity>>> queryAssess(@Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    /**
     * 查询补录信息车辆列表
     */
    @FormUrlEncoded
    @POST("wzapp/assess/queryAssessCar")
    Observable<ComResDataListPagePo<CarInfoListEntity>> queryAssessCar(@Field("keyId") String keyId);

    /**
     * 查询置换车辆列表
     */
    @FormUrlEncoded
    @POST("wzapp/changcar/changingCarListQuery")
    Observable<ComResDataPo<ComResQueryListPagePo<CarReplaceEntity>>> changingCarListQuery(@Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    /**
     * 查询置换车辆列表
     */
    @FormUrlEncoded
    @POST("wzapp/changcar/cancelApplyChangCar")
    Observable<ComRespPo> cancelApplyChangCar(@Field("keyId") String keyId);

    /**
     * 查询补录信息车辆列表
     */
    @FormUrlEncoded
    @POST("wzapp/assess/orderCarApply")
    Observable<ComRespPo> orderCarApply(@FieldMap HashMap<String, Object> info);

    /**
     * 评估车辆提交
     */
    @FormUrlEncoded
    @POST("wzapp/assess/orderCarAssess")
    Observable<ComRespPo> orderCarAssess(@FieldMap HashMap<String, Object> info);

    /**
     * 现金
     */
    @FormUrlEncoded
    @POST("wzapp/changcar/updateChangeCarCash")
    Observable<ComRespPo> updateChangeCarCash(@FieldMap HashMap<String, Object> info);

    /**
     * 车辆置换提交
     */
    @FormUrlEncoded
    @POST("wzapp/changcar/updateChangeCar")
    Observable<ComRespPo> updateChangeCar(@FieldMap HashMap<String, Object> info);

    /**
     * 查询车辆评估列表
     */
    @FormUrlEncoded
    @POST("wzapp/assess/queryAssessOrders")
    Observable<ComResDataPo<ComResQueryListPagePo<CarRecordEntity>>> queryAssessOrders(@Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    /**
     * 查询补录信息车辆列表
     */
    @FormUrlEncoded
    @POST("wzapp/assess/queryAssessCars")
    Observable<ComResDataListPagePo<CarInfoListEntity>> queryAssessCars(@Field("keyId") String keyId);

    /**
     * 删除补录信息车辆
     */
    @FormUrlEncoded
    @POST("wzapp/assess/deleteApplyCar")
    Observable<ComRespPo> deleteApplyCar(@Field("keyId") String keyId);

    /**
     * 完成补录提交
     */
    @FormUrlEncoded
    @POST("wzapp/assess/orderApplySubmit")
    Observable<ComRespPo> orderApplySubmit(@Field("keyId") String keyId);

    /**
     * 上传文件
     */
    @Multipart
    @POST("common/uploadFile")
    @Streaming
    Observable<ComResDataListPagePo<FileUploadRespPo>> uploadFile(@Part MultipartBody.Part file);

    /**
     * 行驶证识别
     */
    @Multipart
    @POST("common/uploadFileOCR")
    @Streaming
    Observable<ComResDataListPagePo<FileUploadRespPo>> uploadFileOCR(@Query("keyType") String keyType, @Part MultipartBody.Part file);

    /**
     * 评估车辆描述提交
     * keyId 车辆评估id
     * keyId01 评估描述
     */
    @FormUrlEncoded
    @POST("wzapp/assess/orderAssessSubmit")
    Observable<ComRespPo> orderAssessSubmit(@Field("keyId") String keyId,
                                            @Field("keyId01") String keyId01);

    /*
     *查询车辆信息
     */
    @FormUrlEncoded
    @POST("wzapp/assess/queryOrderCar")
    Observable<ComRespForCar> queryOrderCar(@Field("keyId") String keyId);

    /*
     *查询车辆信息
     */
    @FormUrlEncoded
    @POST("wzapp/changcar/carListQuery")
    Observable<ComResDataPo<ComResQueryListPagePo<CarInfoListEntity>>> carListQuery(@Field("cond01") String cond01,
                                                                                    @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);


    /*
     *查询车辆信息
     */
    @POST("wzapp/user/queryPKMenus")
    Observable<ComResDataListPagePo<MePermissionEntity>> queryPKMenus();


}