package com.wanzhong.data.po.aswap;

import java.io.Serializable;

/**
 * @time:{2020/9/29}
 * @auhor:{ZhangXW}
 */
public class MeHeightBean implements Serializable {

    /**
     * symbol : WICC
     * fees : 100000
     * desregid : 12199ee3eb15bdc041927f918e15fb3537c8b16b
     * desaddr : wMH8nGW8dBPTKc4yjHhvgg7u2MVPqpzAWv
     * txid : ba73a9fb09d5a10718a4ce654e30e4496fcb43a7940d266df38beac2bafd608b
     * confirmations : 0
     * blockhash :
     * money : 200000
     * feesymbol : WICC
     * rawtx : 0b0182e5ef34210391246338a63bf71d455ff40d5ac14838ff0ba5b8d6dde91924e12125054b4b170457494343858c20011412199ee3eb15bdc041927f918e15fb3537c8b16b04574943438b99401774657374207472616e7366657220666f72207265676964463044022069ab7bec2ae5a4d52d6cae2380894f69b99b3ca40280cf8346be31124869b846022049601dbe21ad17736eecd9b1776e01cb4e73d40d51f0307919a05049e19cca82
     * regid : 0391246338a63bf71d455ff40d5ac14838ff0ba5b8d6dde91924e12125054b4b17
     * addr : wZ6k2bzRK6jvueXPVDF6iMY4fgjqZyP8et
     * coinsymbol : WICC
     * txtype : UCOIN_TRANSFER_TX
     * hash : ba73a9fb09d5a10718a4ce654e30e4496fcb43a7940d266df38beac2bafd608b
     * height : 7977012
     */

    private String symbol;
    private int fees;
    private String desregid;
    private String desaddr;
    private String txid;
    private int confirmations;
    private String blockhash;
    private int money;
    private String feesymbol;
    private String rawtx;
    private String regid;
    private String addr;
    private String coinsymbol;
    private String txtype;
    private String hash;
    private String height;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public String getDesregid() {
        return desregid;
    }

    public void setDesregid(String desregid) {
        this.desregid = desregid;
    }

    public String getDesaddr() {
        return desaddr;
    }

    public void setDesaddr(String desaddr) {
        this.desaddr = desaddr;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public int getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(int confirmations) {
        this.confirmations = confirmations;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
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

    public String getRegid() {
        return regid;
    }

    public void setRegid(String regid) {
        this.regid = regid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
