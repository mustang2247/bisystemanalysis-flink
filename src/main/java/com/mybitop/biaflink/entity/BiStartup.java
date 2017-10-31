package com.mybitop.biaflink.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Mustang
 *
 * @author
 */
public class BiStartup implements Serializable {
    private Integer id;

    /**
     * 应用id
     */
    private String appid;

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
     * 设备日期
     */
    private Date date;

    /**
     * 设备时间
     */
    private Date time;

    /**
     * 广告标识符
     */
    private String idfa;

    /**
     * Vindor标示符
     */
    private String idfv;

    /**
     * 渠道ID
     */
    private String channelid;

    /**
     * ip
     */
    private String ip;

    /**
     * 网络制式2G,3G,WIFI
     */
    private String network;

    /**
     * 设备类型 机型 iphone4s
     */
    private String devicetype;

    /**
     * 操作系统 ios7.0
     */
    private String os;

    /**
     * 运营商
     */
    private String op;

    /**
     * 分辨率
     */
    private String resolution;

    /**
     * 时区
     */
    private String tz;

    /**
     * 前端版本
     */
    private String clientV;

    /**
     * 额外信息
     */
    private String extra;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getClientV() {
        return clientV;
    }

    public void setClientV(String clientV) {
        this.clientV = clientV;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
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
        BiStartup other = (BiStartup) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getAppid() == null ? other.getAppid() == null : this.getAppid().equals(other.getAppid()))
                && (this.getDeviceid() == null ? other.getDeviceid() == null : this.getDeviceid().equals(other.getDeviceid()))
                && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
                && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
                && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
                && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
                && (this.getIdfa() == null ? other.getIdfa() == null : this.getIdfa().equals(other.getIdfa()))
                && (this.getIdfv() == null ? other.getIdfv() == null : this.getIdfv().equals(other.getIdfv()))
                && (this.getChannelid() == null ? other.getChannelid() == null : this.getChannelid().equals(other.getChannelid()))
                && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
                && (this.getNetwork() == null ? other.getNetwork() == null : this.getNetwork().equals(other.getNetwork()))
                && (this.getDevicetype() == null ? other.getDevicetype() == null : this.getDevicetype().equals(other.getDevicetype()))
                && (this.getOs() == null ? other.getOs() == null : this.getOs().equals(other.getOs()))
                && (this.getOp() == null ? other.getOp() == null : this.getOp().equals(other.getOp()))
                && (this.getResolution() == null ? other.getResolution() == null : this.getResolution().equals(other.getResolution()))
                && (this.getTz() == null ? other.getTz() == null : this.getTz().equals(other.getTz()))
                && (this.getClientV() == null ? other.getClientV() == null : this.getClientV().equals(other.getClientV()))
                && (this.getExtra() == null ? other.getExtra() == null : this.getExtra().equals(other.getExtra()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppid() == null) ? 0 : getAppid().hashCode());
        result = prime * result + ((getDeviceid() == null) ? 0 : getDeviceid().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getIdfa() == null) ? 0 : getIdfa().hashCode());
        result = prime * result + ((getIdfv() == null) ? 0 : getIdfv().hashCode());
        result = prime * result + ((getChannelid() == null) ? 0 : getChannelid().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getNetwork() == null) ? 0 : getNetwork().hashCode());
        result = prime * result + ((getDevicetype() == null) ? 0 : getDevicetype().hashCode());
        result = prime * result + ((getOs() == null) ? 0 : getOs().hashCode());
        result = prime * result + ((getOp() == null) ? 0 : getOp().hashCode());
        result = prime * result + ((getResolution() == null) ? 0 : getResolution().hashCode());
        result = prime * result + ((getTz() == null) ? 0 : getTz().hashCode());
        result = prime * result + ((getClientV() == null) ? 0 : getClientV().hashCode());
        result = prime * result + ((getExtra() == null) ? 0 : getExtra().hashCode());
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
        sb.append(", deviceid=").append(deviceid);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", date=").append(date);
        sb.append(", time=").append(time);
        sb.append(", idfa=").append(idfa);
        sb.append(", idfv=").append(idfv);
        sb.append(", channelid=").append(channelid);
        sb.append(", ip=").append(ip);
        sb.append(", network=").append(network);
        sb.append(", devicetype=").append(devicetype);
        sb.append(", os=").append(os);
        sb.append(", op=").append(op);
        sb.append(", resolution=").append(resolution);
        sb.append(", tz=").append(tz);
        sb.append(", clientV=").append(clientV);
        sb.append(", extra=").append(extra);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}