package com.mybitop.biaflink.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * payment
 * @author Mustang
 */
public class BiPayment implements Serializable {
    private Integer id;

    /**
     * 应用id
     */
    private String appid;

    /**
     * 用户id
     */
    private String who;

    /**
     * 设备id
     */
    private String deviceid;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 交易的流水号
     */
    private String transactionid;

    /**
     * 支付类型，例如支付宝，银联，苹果、谷歌官方等,如果是系统赠送的，paymentType为：free
     */
    private String paymenttype;

    /**
     * 货币类型，按照国际标准组织ISO 4217中规范的3位字母，例如CNY人民币、USD美金等，详情请点击
     */
    private String currencytype;

    /**
     * 支付的真实货币的金额
     */
    private String currencyamount;

    /**
     * 通过充值获得的游戏内货币的数量
     */
    private String virtualcoinamount;

    /**
     * 游戏内购买道具的名称
     */
    private String iapname;

    /**
     * 游戏内购买道具的数量
     */
    private String iapamount;

    /**
     * 服务器ID
     */
    private String serverid;

    /**
     * 渠道ID
     */
    private String channelid;

    /**
     * 广告标识符
     */
    private String idfa;

    /**
     * Vindor标示符
     */
    private String idfv;

    /**
     * 账户等级
     */
    private String level;

    /**
     * 前端版本
     */
    private String clientV;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String getCurrencytype() {
        return currencytype;
    }

    public void setCurrencytype(String currencytype) {
        this.currencytype = currencytype;
    }

    public String getCurrencyamount() {
        return currencyamount;
    }

    public void setCurrencyamount(String currencyamount) {
        this.currencyamount = currencyamount;
    }

    public String getVirtualcoinamount() {
        return virtualcoinamount;
    }

    public void setVirtualcoinamount(String virtualcoinamount) {
        this.virtualcoinamount = virtualcoinamount;
    }

    public String getIapname() {
        return iapname;
    }

    public void setIapname(String iapname) {
        this.iapname = iapname;
    }

    public String getIapamount() {
        return iapamount;
    }

    public void setIapamount(String iapamount) {
        this.iapamount = iapamount;
    }

    public String getServerid() {
        return serverid;
    }

    public void setServerid(String serverid) {
        this.serverid = serverid;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getIdfv() {
        return idfv;
    }

    public void setIdfv(String idfv) {
        this.idfv = idfv;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getClientV() {
        return clientV;
    }

    public void setClientV(String clientV) {
        this.clientV = clientV;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BiPayment other = (BiPayment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppid() == null ? other.getAppid() == null : this.getAppid().equals(other.getAppid()))
            && (this.getWho() == null ? other.getWho() == null : this.getWho().equals(other.getWho()))
            && (this.getDeviceid() == null ? other.getDeviceid() == null : this.getDeviceid().equals(other.getDeviceid()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getTransactionid() == null ? other.getTransactionid() == null : this.getTransactionid().equals(other.getTransactionid()))
            && (this.getPaymenttype() == null ? other.getPaymenttype() == null : this.getPaymenttype().equals(other.getPaymenttype()))
            && (this.getCurrencytype() == null ? other.getCurrencytype() == null : this.getCurrencytype().equals(other.getCurrencytype()))
            && (this.getCurrencyamount() == null ? other.getCurrencyamount() == null : this.getCurrencyamount().equals(other.getCurrencyamount()))
            && (this.getVirtualcoinamount() == null ? other.getVirtualcoinamount() == null : this.getVirtualcoinamount().equals(other.getVirtualcoinamount()))
            && (this.getIapname() == null ? other.getIapname() == null : this.getIapname().equals(other.getIapname()))
            && (this.getIapamount() == null ? other.getIapamount() == null : this.getIapamount().equals(other.getIapamount()))
            && (this.getServerid() == null ? other.getServerid() == null : this.getServerid().equals(other.getServerid()))
            && (this.getChannelid() == null ? other.getChannelid() == null : this.getChannelid().equals(other.getChannelid()))
            && (this.getIdfa() == null ? other.getIdfa() == null : this.getIdfa().equals(other.getIdfa()))
            && (this.getIdfv() == null ? other.getIdfv() == null : this.getIdfv().equals(other.getIdfv()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getClientV() == null ? other.getClientV() == null : this.getClientV().equals(other.getClientV()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppid() == null) ? 0 : getAppid().hashCode());
        result = prime * result + ((getWho() == null) ? 0 : getWho().hashCode());
        result = prime * result + ((getDeviceid() == null) ? 0 : getDeviceid().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getTransactionid() == null) ? 0 : getTransactionid().hashCode());
        result = prime * result + ((getPaymenttype() == null) ? 0 : getPaymenttype().hashCode());
        result = prime * result + ((getCurrencytype() == null) ? 0 : getCurrencytype().hashCode());
        result = prime * result + ((getCurrencyamount() == null) ? 0 : getCurrencyamount().hashCode());
        result = prime * result + ((getVirtualcoinamount() == null) ? 0 : getVirtualcoinamount().hashCode());
        result = prime * result + ((getIapname() == null) ? 0 : getIapname().hashCode());
        result = prime * result + ((getIapamount() == null) ? 0 : getIapamount().hashCode());
        result = prime * result + ((getServerid() == null) ? 0 : getServerid().hashCode());
        result = prime * result + ((getChannelid() == null) ? 0 : getChannelid().hashCode());
        result = prime * result + ((getIdfa() == null) ? 0 : getIdfa().hashCode());
        result = prime * result + ((getIdfv() == null) ? 0 : getIdfv().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getClientV() == null) ? 0 : getClientV().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appid=").append(appid);
        sb.append(", who=").append(who);
        sb.append(", deviceid=").append(deviceid);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", transactionid=").append(transactionid);
        sb.append(", paymenttype=").append(paymenttype);
        sb.append(", currencytype=").append(currencytype);
        sb.append(", currencyamount=").append(currencyamount);
        sb.append(", virtualcoinamount=").append(virtualcoinamount);
        sb.append(", iapname=").append(iapname);
        sb.append(", iapamount=").append(iapamount);
        sb.append(", serverid=").append(serverid);
        sb.append(", channelid=").append(channelid);
        sb.append(", idfa=").append(idfa);
        sb.append(", idfv=").append(idfv);
        sb.append(", level=").append(level);
        sb.append(", clientV=").append(clientV);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}