package com.mybitop.biaflink.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * quest
 *
 * @author Mustang
 */
public class BiQuest implements Serializable {
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
     * 当前任务/关卡/副本的编号或名称
     */
    private String questid;

    /**
     * 当前任务/关卡/副本的状态，有如下三种类型：开始：a完成：c失败：f
     */
    private String queststatus;

    /**
     * 当前任务/关卡/副本的类型，例如： 新手任务：new 主线任务：main 支线任务：sub 开发者也可以根据自己游戏的特点自定义类型
     */
    private String questtype;

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

    public String getQuestid() {
        return questid;
    }

    public void setQuestid(String questid) {
        this.questid = questid;
    }

    public String getQueststatus() {
        return queststatus;
    }

    public void setQueststatus(String queststatus) {
        this.queststatus = queststatus;
    }

    public String getQuesttype() {
        return questtype;
    }

    public void setQuesttype(String questtype) {
        this.questtype = questtype;
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
        BiQuest other = (BiQuest) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getAppid() == null ? other.getAppid() == null : this.getAppid().equals(other.getAppid()))
                && (this.getWho() == null ? other.getWho() == null : this.getWho().equals(other.getWho()))
                && (this.getDeviceid() == null ? other.getDeviceid() == null : this.getDeviceid().equals(other.getDeviceid()))
                && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
                && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
                && (this.getQuestid() == null ? other.getQuestid() == null : this.getQuestid().equals(other.getQuestid()))
                && (this.getQueststatus() == null ? other.getQueststatus() == null : this.getQueststatus().equals(other.getQueststatus()))
                && (this.getQuesttype() == null ? other.getQuesttype() == null : this.getQuesttype().equals(other.getQuesttype()))
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
        result = prime * result + ((getQuestid() == null) ? 0 : getQuestid().hashCode());
        result = prime * result + ((getQueststatus() == null) ? 0 : getQueststatus().hashCode());
        result = prime * result + ((getQuesttype() == null) ? 0 : getQuesttype().hashCode());
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
        sb.append(", questid=").append(questid);
        sb.append(", queststatus=").append(queststatus);
        sb.append(", questtype=").append(questtype);
        sb.append(", serverid=").append(serverid);
        sb.append(", channelid=").append(channelid);
        sb.append(", level=").append(level);
        sb.append(", clientV=").append(clientV);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}