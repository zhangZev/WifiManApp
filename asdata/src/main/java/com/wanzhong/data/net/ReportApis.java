package com.wanzhong.data.net;

import com.wanzhong.data.po.report.ReportCarRespPo;
import com.wanzhong.data.po.report.ReportCustomRespPo;
import com.wanzhong.data.po.report.ReportEmployerRespPo;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 车源模块接口
 */
public interface ReportApis {

    /**
     * TODO新报表主页面 keyId 开始时间 keyId01 结束时间 keyType 类型0 车辆统计 1 客户统计 2 员工统计
     */
    @POST("/wzapp/report/reportMain")
    Observable<ReportCarRespPo> reportMain(@Query("keyId") String keyId,
                                           @Query("keyId01") String keyId01,
                                           @Query("keyType") String keyType);

    /**
     * TODO新报表主页面 keyId 开始时间 keyId01 结束时间 keyType 类型0 车辆统计 1 客户统计 2 员工统计
     */
    @POST("/wzapp/report/reportMain")
    Observable<ReportCustomRespPo> reportCustomMain(@Query("keyId") String keyId,
                                                    @Query("keyId01") String keyId01,
                                                    @Query("keyType") String keyType);

    /**
     * TODO新报表主页面 keyId 开始时间 keyId01 结束时间 keyType 类型0 车辆统计 1 客户统计 2 员工统计
     */
    @POST("/wzapp/report/reportMain")
    Observable<ReportEmployerRespPo> reportEmployMain(@Query("keyId") String keyId,
                                                      @Query("keyId01") String keyId01,
                                                      @Query("keyType") String keyType);

}