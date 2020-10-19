package com.wanzhong.data.po.aswap;

import java.io.Serializable;

/**
 * @time:{2020/9/27}
 * @auhor:{ZhangXW}
 */
public class TradingBean implements Serializable {

    /**
     * id : 22d9a47f77884030364256a7986121435ed80c20176679a2952913b65a5f9c83
     * type : 存入
     * amount : 1534227-2;1534227-2
     * status : 区块已确认
     * createdt : 2020-09-26 18:25:18
     */

    private String id;
    private String type;
    private String amount;
    private String status;
    private String createdt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedt() {
        return createdt;
    }

    public void setCreatedt(String createdt) {
        this.createdt = createdt;
    }
}
