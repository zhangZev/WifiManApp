package com.wanzhong.data.po.aswap;

import java.io.Serializable;
import java.util.List;

/**
 * @time:{2020/9/30}
 * @auhor:{ZhangXW}
 */
public class TradingDescBean implements Serializable {

    /**
     * fees : 100000
     * ver : 1
     * validheight : 7998737
     * confirmedtime : 1601430083
     * txid : 823953373452c6c5c0bb4597d52f9fc483210b55fecf2945b652c88c4e253e0d
     * confirmations : 823
     * fromaddr : 
     * blockhash : 303db392f7d575f426db13ed50ed810ac2ea0fa53412a4f6a6e4058737cb5c97
     * txuid : 
     * feesymbol : WICC
     * receiptlist : [{"toaddr":"","coinsymbol":"WICC","fromaddr":"wZ6k2bzRK6jvueXPVDF6iMY4fgjqZyP8et","coinamount":100000}]
     * rawtx : 640182e7991104dcd113020457494343858c200180e9ccd7beff0280cce5ce84d4b6feff0001ade888beff0280e0d7c8e980a692a9704902003091760100000200f0da5407000000c2eb0b000000000859534a3100000028737761703a59534a312d59534a323a312e39373535393931352059534a323a313533343232372d32004730450221009f48fa61b0132960d4aad3ac77a7d962729449dcac6267fd1fb6b671c91e2bfa02204e9b9f59c3a11b23c6a60b8fdc00b9827277eabc919d35d9bf21ef1d5be3d47a
     * confirmedheight : 7998739
     * coinsymbol : WICC
     * txtype : UNIVERSAL_TX
     * coinamount : 0
     */

    private double fees;
    private double ver;
    private double validheight;
    private double confirmedtime;
    private String txid;
    private double confirmations;
    private String fromaddr;
    private String blockhash;
    private String txuid;
    private String feesymbol;
    private String rawtx;
    private double confirmedheight;
    private String coinsymbol;
    private String txtype;
    private double coinamount;
    private List<ReceiptlistBean> receiptlist;

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public double getVer() {
        return ver;
    }

    public void setVer(double ver) {
        this.ver = ver;
    }

    public double getValidheight() {
        return validheight;
    }

    public void setValidheight(double validheight) {
        this.validheight = validheight;
    }

    public double getConfirmedtime() {
        return confirmedtime;
    }

    public void setConfirmedtime(double confirmedtime) {
        this.confirmedtime = confirmedtime;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public double getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(double confirmations) {
        this.confirmations = confirmations;
    }

    public String getFromaddr() {
        return fromaddr;
    }

    public void setFromaddr(String fromaddr) {
        this.fromaddr = fromaddr;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public String getTxuid() {
        return txuid;
    }

    public void setTxuid(String txuid) {
        this.txuid = txuid;
    }

    public String getFeesymbol() {
        return feesymbol;
    }

    public void setFeesymbol(String feesymbol) {
        this.feesymbol = feesymbol;
    }

    public String getRawtx() {
        return rawtx;
    }

    public void setRawtx(String rawtx) {
        this.rawtx = rawtx;
    }

    public double getConfirmedheight() {
        return confirmedheight;
    }

    public void setConfirmedheight(double confirmedheight) {
        this.confirmedheight = confirmedheight;
    }

    public String getCoinsymbol() {
        return coinsymbol;
    }

    public void setCoinsymbol(String coinsymbol) {
        this.coinsymbol = coinsymbol;
    }

    public String getTxtype() {
        return txtype;
    }

    public void setTxtype(String txtype) {
        this.txtype = txtype;
    }

    public double getCoinamount() {
        return coinamount;
    }

    public void setCoinamount(double coinamount) {
        this.coinamount = coinamount;
    }

    public List<ReceiptlistBean> getReceiptlist() {
        return receiptlist;
    }

    public void setReceiptlist(List<ReceiptlistBean> receiptlist) {
        this.receiptlist = receiptlist;
    }

    public static class ReceiptlistBean {
        /**
         * toaddr : 
         * coinsymbol : WICC
         * fromaddr : wZ6k2bzRK6jvueXPVDF6iMY4fgjqZyP8et
         * coinamount : 100000
         */

        private String toaddr;
        private String coinsymbol;
        private String fromaddr;
        private double coinamount;

        public String getToaddr() {
            return toaddr;
        }

        public void setToaddr(String toaddr) {
            this.toaddr = toaddr;
        }

        public String getCoinsymbol() {
            return coinsymbol;
        }

        public void setCoinsymbol(String coinsymbol) {
            this.coinsymbol = coinsymbol;
        }

        public String getFromaddr() {
            return fromaddr;
        }

        public void setFromaddr(String fromaddr) {
            this.fromaddr = fromaddr;
        }

        public double getCoinamount() {
            return coinamount;
        }

        public void setCoinamount(double coinamount) {
            this.coinamount = coinamount;
        }
    }
}
