package com.mybitop.biaflink.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mustang
 */
public class BiEconomy implements Serializable {
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
     * 游戏内虚拟物品的名称/ID
     */
    private String itemname;

    /**
     * 交易的数量
     */
    private String itemamount;

    /**
     * 交易的总价
     */
    private String itemtotalprice;

    /**
     * 服务器ID
     */
    private String serverid;

    /**
     * 渠道ID
     */
    private String channelid;

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

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItemamount() {
        return itemamount;
    }

    public void setItemamount(String itemamount) {
        this.itemamount = itemamount;
    }

    public String getItemtotalprice() {
        return itemtotalprice;
    }

    public void setItemtotalprice(String itemtotalprice) {
        this.itemtotalprice = itemtotalprice;
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
        BiEconomy other = (BiEconomy) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getAppid() == null ? other.getAppid() == null : this.getAppid().equals(other.getAppid()))
                && (this.getWho() == null ? other.getWho() == null : this.getWho().equals(other.getWho()))
                && (this.getDeviceid() == null ? other.getDeviceid() == null : this.getDeviceid().equals(other.getDeviceid()))
                && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
                && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
                && (this.getItemname() == null ? other.getItemname() == null : this.getItemname().equals(other.getItemname()))
                && (this.getItemamount() == null ? other.getItemamount() == null : this.getItemamount().equals(other.getItemamount()))
                && (this.getItemtotalprice() == null ? other.getItemtotalprice() == null : this.getItemtotalprice().equals(other.getItemtotalprice()))
                && (this.getServerid() == null ? other.getServerid() == null : this.getServerid().equals(other.getServerid()))
                && (this.getChannelid() == null ? other.getChannelid() == null : this.getChannelid().equals(other.getChannelid()))
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
        result = prime * result + ((getItemname() == null) ? 0 : getItemname().hashCode());
        result = prime * result + ((getItemamount() == null) ? 0 : getItemamount().hashCode());
        result = prime * result + ((getItemtotalprice() == null) ? 0 : getItemtotalprice().hashCode());
        result = prime * result + ((getServerid() == null) ? 0 : getServerid().hashCode());
        result = prime * result + ((getChannelid() == null) ? 0 : getChannelid().hashCode());
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
        sb.append(", itemname=").append(itemname);
        sb.append(", itemamount=").append(itemamount);
        sb.append(", itemtotalprice=").append(itemtotalprice);
        sb.append(", serverid=").append(serverid);
        sb.append(", channelid=").append(channelid);
        sb.append(", level=").append(level);
        sb.append(", clientV=").append(clientV);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}