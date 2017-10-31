package com.mybitop.biaflink.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mustang
 */
public class BiUser implements Serializable {
    private Integer id;

    /**
     * 设备id
     */
    private String deviceid;

    /**
     * 游戏appid
     */
    private String appID;

    /**
     * 玩家用户id
     */
    private String userID;

    /**
     * user open id
     */
    private String userOpenID;

    /**
     * 玩家数据信息
     */
    private String userName;

    /**
     * 金币
     */
    private String userGold;

    /**
     * 砖石
     */
    private String userDiamond;

    /**
     * 性别
     */
    private String userSex;

    /**
     * 等级
     */
    private String userLevel;

    /**
     * 经验
     */
    private String userExp;

    /**
     * 是否充值过
     */
    private String userIsRecharged;

    /**
     * vip经验
     */
    private String userVIPExp;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

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

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserOpenID() {
        return userOpenID;
    }

    public void setUserOpenID(String userOpenID) {
        this.userOpenID = userOpenID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGold() {
        return userGold;
    }

    public void setUserGold(String userGold) {
        this.userGold = userGold;
    }

    public String getUserDiamond() {
        return userDiamond;
    }

    public void setUserDiamond(String userDiamond) {
        this.userDiamond = userDiamond;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserExp() {
        return userExp;
    }

    public void setUserExp(String userExp) {
        this.userExp = userExp;
    }

    public String getUserIsRecharged() {
        return userIsRecharged;
    }

    public void setUserIsRecharged(String userIsRecharged) {
        this.userIsRecharged = userIsRecharged;
    }

    public String getUserVIPExp() {
        return userVIPExp;
    }

    public void setUserVIPExp(String userVIPExp) {
        this.userVIPExp = userVIPExp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        BiUser other = (BiUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getDeviceid() == null ? other.getDeviceid() == null : this.getDeviceid().equals(other.getDeviceid()))
                && (this.getAppID() == null ? other.getAppID() == null : this.getAppID().equals(other.getAppID()))
                && (this.getUserID() == null ? other.getUserID() == null : this.getUserID().equals(other.getUserID()))
                && (this.getUserOpenID() == null ? other.getUserOpenID() == null : this.getUserOpenID().equals(other.getUserOpenID()))
                && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
                && (this.getUserGold() == null ? other.getUserGold() == null : this.getUserGold().equals(other.getUserGold()))
                && (this.getUserDiamond() == null ? other.getUserDiamond() == null : this.getUserDiamond().equals(other.getUserDiamond()))
                && (this.getUserSex() == null ? other.getUserSex() == null : this.getUserSex().equals(other.getUserSex()))
                && (this.getUserLevel() == null ? other.getUserLevel() == null : this.getUserLevel().equals(other.getUserLevel()))
                && (this.getUserExp() == null ? other.getUserExp() == null : this.getUserExp().equals(other.getUserExp()))
                && (this.getUserIsRecharged() == null ? other.getUserIsRecharged() == null : this.getUserIsRecharged().equals(other.getUserIsRecharged()))
                && (this.getUserVIPExp() == null ? other.getUserVIPExp() == null : this.getUserVIPExp().equals(other.getUserVIPExp()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getClientV() == null ? other.getClientV() == null : this.getClientV().equals(other.getClientV()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeviceid() == null) ? 0 : getDeviceid().hashCode());
        result = prime * result + ((getAppID() == null) ? 0 : getAppID().hashCode());
        result = prime * result + ((getUserID() == null) ? 0 : getUserID().hashCode());
        result = prime * result + ((getUserOpenID() == null) ? 0 : getUserOpenID().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserGold() == null) ? 0 : getUserGold().hashCode());
        result = prime * result + ((getUserDiamond() == null) ? 0 : getUserDiamond().hashCode());
        result = prime * result + ((getUserSex() == null) ? 0 : getUserSex().hashCode());
        result = prime * result + ((getUserLevel() == null) ? 0 : getUserLevel().hashCode());
        result = prime * result + ((getUserExp() == null) ? 0 : getUserExp().hashCode());
        result = prime * result + ((getUserIsRecharged() == null) ? 0 : getUserIsRecharged().hashCode());
        result = prime * result + ((getUserVIPExp() == null) ? 0 : getUserVIPExp().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
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
        sb.append(", deviceid=").append(deviceid);
        sb.append(", appID=").append(appID);
        sb.append(", userID=").append(userID);
        sb.append(", userOpenID=").append(userOpenID);
        sb.append(", userName=").append(userName);
        sb.append(", userGold=").append(userGold);
        sb.append(", userDiamond=").append(userDiamond);
        sb.append(", userSex=").append(userSex);
        sb.append(", userLevel=").append(userLevel);
        sb.append(", userExp=").append(userExp);
        sb.append(", userIsRecharged=").append(userIsRecharged);
        sb.append(", userVIPExp=").append(userVIPExp);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", clientV=").append(clientV);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}