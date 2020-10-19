package com.wanzhong.data.net;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.data.po.ComResDataListPagePo;
import com.wanzhong.data.po.ComResDataPo;
import com.wanzhong.data.po.ComResQueryListPagePo;
import com.wanzhong.data.po.ComRespPo;
import com.wanzhong.data.po.CustomerBasePo;
import com.wanzhong.data.po.admin.AdminUserInfo;
import com.wanzhong.data.po.admin.CarInInventoryHistoryListPo;
import com.wanzhong.data.po.admin.CarInInventoryListPo;
import com.wanzhong.data.po.admin.InventoryEnterItemPo;
import com.wanzhong.data.po.admin.InventoryHistoryQueryListPagePo;
import com.wanzhong.data.po.aswap.CoinsBean;
import com.wanzhong.data.po.aswap.HomeExBean;
import com.wanzhong.data.po.aswap.MarketBean;
import com.wanzhong.data.po.aswap.MarketInfoBean;
import com.wanzhong.data.po.aswap.MeBean;
import com.wanzhong.data.po.aswap.MeHeightBean;
import com.wanzhong.data.po.aswap.SignBean;
import com.wanzhong.data.po.aswap.TokenBena;
import com.wanzhong.data.po.aswap.TradingBean;
import com.wanzhong.data.po.aswap.TradingBeanResp;
import com.wanzhong.data.po.aswap.TradingDescBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * 管理端模块接口
 */
public interface AdminApis {

    /**
     * 获取token
     */
    @POST("/aswap/app/token")
    Observable<TokenBena> getToken();

    /**
     * 查询用户交易记录 分页查询
     */
    @POST("/aswap/app/queryUserTradeRecords")
    Observable<ComResDataPo<TradingBeanResp>> queryUserTradeRecords(@QueryMap HashMap<String, String> options);

    /**
     * 获取区块高度
     */
    @POST("/aswap/app/queryHeight")
    Observable<ComResDataPo<String>> queryHeight();

    /**
     * 获取币种列表及用户余额
     */
    @POST("/aswap/app/queryTokensByUserBal")
    Observable<ComResDataListPagePo<CoinsBean>> queryTokensByUserBal();

    /**
     * 钱包转账币种及余额
     */
    @POST("/aswap/app/walletTransferCurrencys")
    Observable<ComResDataPo<ComResDataListPagePo<CoinsBean>>> walletTransferCurrencys();

    /**
     * 我的页面接口
     */
    @POST("/aswap/app/mePage")
    Observable<ComResDataPo<MeBean>> mePage();

    /**
     * 查询用户提供的流动性
     */
    @POST("/aswap/app/queryProvideLiquidity")
    Observable<ComResDataListPagePo<MarketBean>> queryProvideLiquidity();

    /**
     * 查询用户提供的流动性详情
     */
    @POST("/aswap/app/queryProvideLiquidityDetail")
    Observable<ComResDataPo<MarketInfoBean>> queryProvideLiquidityDetail(@QueryMap HashMap<String, String> options);

    /**
     * 我的页面接口
     */
    @POST("/aswap/app/submitTransfer")
    Observable<ComResDataPo<CoinsBean>> submitTransfer(@Query("rawtx") String rawtx);

    /**
     * 兑换前选择币种数量后计算
     */
    @POST("/aswap/app/exchangeForward")
    Observable<ComResDataPo<HomeExBean>> exchangeForward(@Query("currency1") String currency1,
                                                         @Query("currency2") String currency2,
                                                         @Query("num1") double num1);

    /**
     * 兑换前选择币种数量后计算
     */
    @POST("/aswap/app/redeem")
    Observable<ComResDataPo<SignBean>> redeem(@Query("currency1") String currency1,
                                              @Query("currency2") String currency2,
                                              @Query("subId") String sub_id,
                                              @Query("num1") String num1);

    /**
     * 加入流动池前选择币种数量后计算
     */
    @POST("/aswap/app/provideLiquidityForward")
    Observable<ComResDataPo<HomeExBean>> provideLiquidityForward(@Query("currency1") String currency1,
                                                                 @Query("currency2") String currency2,
                                                                 @Query("num1") double num1);

    /**
     * 加入流动池
     */
    @POST("/aswap/app/provideLiquidity")
    Observable<ComResDataPo<SignBean>> provideLiquidity(@Query("currency1") String currency1,
                                                        @Query("currency2") String currency2,
                                                        @Query("num1") double num1);

    /**
     * 加入流动池
     */
    @POST("/aswap/app/provideLiquidityFirst")
    Observable<ComResDataPo<SignBean>> provideLiquidityFirst(@Query("currency1") String currency1,
                                                             @Query("currency2") String currency2,
                                                             @Query("num1") String num1,
                                                             @Query("num2") String num2);

    /**
     * 兑换前选择币种数量后计算
     */
    @POST("/aswap/app/exchange")
    Observable<ComResDataPo<SignBean>> exchange(@QueryMap HashMap<String, String> options);

    /**
     * 创建市场 特殊情况两种交易
     */
    @POST("/aswap/app/createTradeDouble")
    Observable<ComResDataPo<SignBean>> createTradeDouble(@QueryMap HashMap<String, String> options);

    /**
     * 提交合约交易
     */
    @POST("/aswap/app/submitTx")
    Observable<ComResDataPo<SignBean>> submitTx(@Query("rawtx") String rawtx,
                                                @Query("signature") String signature);

    /**
     * 查询交易是否已确认
     */
    @POST("/aswap/app/queryTxIsCommited")
    Observable<ComResDataPo<Boolean>> queryTxIsCommited(@Query("txid") String txid);

    /**
     * 激活Regid
     */
    @POST("/aswap/app/activationRegid")
    Observable<ComResDataPo<MeHeightBean>> activationRegid();
   /* *
     * 查询交易详情
     */
    @POST("/aswap/app/queryTradeDetail")
    Observable<ComResDataPo<TradingDescBean>> queryTradeDetail(@Query("txid") String txid);

}