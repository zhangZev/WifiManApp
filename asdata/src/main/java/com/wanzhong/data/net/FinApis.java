package com.wanzhong.data.net;

import com.wanzhong.data.po.ComRespPo;
import com.wanzhong.data.po.fincal.AccountRespPo;
import com.wanzhong.data.po.fincal.CarDetailsRespPo;
import com.wanzhong.data.po.fincal.FincalOrderRespPo;
import com.wanzhong.data.po.fincal.FincalRepayRespPo;
import com.wanzhong.data.po.fincal.FincalRespPo;
import com.wanzhong.data.po.fincal.SingalCarRespPo;
import com.wanzhong.data.po.fincal.SingalOrderRespPo;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 金融模块接口
 */
public interface FinApis {

    /**
     * TODO金融页面接口
     */
    @POST("/wzapp/fin/finMain")
    Observable<FincalRespPo> homeMain();

    /**
     * TODO申请授信
     */
    @POST("/wzapp/fin/finApply")
    Observable<ComRespPo> finApply();

    /**
     * TODO账号管理
     */
    @POST("/wzapp/fin/finAccount")
    Observable<AccountRespPo> finAccount();

    /**
     * TODO银行卡信息
     */
    @POST("/wzapp/fin/finBindDetail")
    Observable<AccountRespPo> finBindDetail();

    /**
     * TODO添加/修改银行卡
     */
    @POST("/wzapp/fin/finModifyBind")
    Observable<AccountRespPo> finModifyBind(@Query("bank_user") String bank_user,
                                            @Query("bank_no") String bank_no,
                                            @Query("bank_area") String bank_area);
   /**
     * TODO单车/库融借款
     */
    @POST("/wzapp/fin/finApplyLoan")
    Observable<AccountRespPo> finApplyLoan(@Query("amount") String amount,
                                           @Query("product_type") String product_type,
                                            @Query("loan_limit") String loan_limit);

    /**
     * TODO立即提现
     */
    @POST("/wzapp/fin/finWithdraw")
    Observable<ComRespPo> finWithdraw(@Body RequestBody data);

    /**
     * TODO开通存管账户
     */
    @POST("/wzapp/fin/finOpenAccount")
    Observable<ComRespPo> finOpenAccount(@Body RequestBody data);

    /**
     * TODO银行卡绑定
     */
    @POST("/wzapp/fin/finBindBank")
    Observable<ComRespPo> finBindBank(@Body RequestBody data);

    /**
     * TODO银行卡解绑
     */
    @POST("/wzapp/fin/finUnbindBank")
    Observable<ComRespPo> finUnbindBank(@Body RequestBody data);

    /**
     * TODO修改交易密码
     */
    @POST("/wzapp/fin/finUpdatePwd")
    Observable<ComRespPo> finUpdatePwd(@Body RequestBody data);

    /**
     * TODO修改银行卡预留手机号
     */
    @POST("/wzapp/fin/finUpdateMobile")
    Observable<ComRespPo> finUpdateMobile(@Body RequestBody data);

    /**
     * TODO单车金融列表
     *  排序字段 1 最后还款日 2 申请日期 3放款日期
     */
    @POST("/wzapp/fin/finOneOrders")
    Observable<SingalCarRespPo> finOneOrders(
            @Query("pageIndex") int page,
            @Query("cond01") String cond01);

    /**
     * TODO单车借款
     */
    @POST("/wzapp/fin/finOneApply")
    Observable<ComRespPo> finOneApply(@Body RequestBody data);

    /**
     * TODO立即还款初始化
     */
    @POST("/wzapp/fin/finOneReplayInit")
    Observable<SingalOrderRespPo> finOneReplayInit(@Query("keyId")String keyId);

    /**
     * TODO确认立即还款
     * @param keyId 还款列表json
     * @param keyId01 凭证id
     * @param keyId02 订单id
     */
    @POST("/wzapp/fin/finOneReplayOk")
    Observable<ComRespPo> finOneReplayOk(@Query("keyId")String keyId,
                                         @Query("keyId01")String keyId01,
                                         @Query("keyId02")String keyId02);

    /**
     * TODO单车订单详情
     */
    @POST("/wzapp/fin/finOneOrderDetail")
    Observable<SingalOrderRespPo> finOneOrderDetail(@Query("keyId")String keyId);

    /**
     * TODO单车车辆详情
     */
    @POST("/wzapp/fin/finOneCarDetail")
    Observable<CarDetailsRespPo> finOneCarDetail(@Query("keyId")String keyId);

    /**
     * TODO库存金融列表
     */
    @POST("/wzapp/fin/finLibOrders")
    Observable<SingalCarRespPo> finLibOrders( @Query("pageIndex") int page,
                                        @Query("cond01") String cond01);
    /**
     * TODO库存借款
     */
    @POST("/wzapp/fin/finLibApply")
    Observable<ComRespPo> finLibApply(@Body RequestBody data);

    /**
     * TODO库存还款
     * @param keyId 还款计划parent_key_id
     * @param keyId 子订单id
     * @param fileId 凭证id
     * @param keyType 主订单id
     */
    @POST("/wzapp/fin/finLibReplay")
    Observable<ComRespPo> finLibReplay(@Query("keyId")String parent_key_id,
                                       @Query("keyId01")String keyId,
                                       @Query("keyId02")String fileId,
                                       @Query("keyType")String keyType);

    /**
     * TODO库存订单详情
     */
    @POST("/wzapp/fin/finLibOrderDetail")
    Observable<FincalOrderRespPo> finLibOrderDetail(@Query("keyId")String keyId);

    /**
     * TODO库存车辆详情
     */
    @POST("/wzapp/fin/finLibCarDetail")
    Observable<CarDetailsRespPo> finLibCarDetail(@Query("keyId")String keyId);

    /**
     * TODO库存申请置换
     */
    @POST("/wzapp/fin/finLibCarTrans")
    Observable<ComRespPo> finLibCarTrans(@Query("keyId")String keyId);

    /**
     * TODO还款记录列表
     */
    @POST("/wzapp/fin/finRepays")
    Observable<FincalRepayRespPo> finRepays(
            @Query("pageIndex") int page,
            @Query("cond01") String cond01, @Query("cond02") String cond02);
}