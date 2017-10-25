package com.mybitop.biaflink.entity;

import java.util.Date;

public class Startup {
    private int id;

    private String appid;
    private String deviceid;

    private String createtime;
    private String updatetime;
    private String date;
    private String time;

    private String idfa;
    private String idfv;
    private String channelid;
    private String ip;

    private String network;
    private String devicetype;
    private String os;
    private String op;

    private String resolution;
    private String tz;

    private String clientV;
    private String extra;

    public Startup(String[] startup) {
        this.id = Integer.parseInt(startup[0]);
        this.appid = startup[1];
        this.deviceid = startup[2];
        this.createtime = startup[3];
        this.updatetime = startup[4];
        this.date = startup[5];
        this.time = startup[6];
        this.idfa = startup[7];
        this.idfv = startup[8];
        this.channelid = startup[9];
        this.ip = startup[10];
        this.network = startup[11];
        this.devicetype = startup[12];
        this.os = startup[13];
        this.op = startup[14];
        this.resolution = startup[15];
        this.tz = startup[16];

        this.clientV = startup[17];
        this.extra = startup[18];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
    public String toString() {
        return "Startup{" +
                ", appid='" + appid + '\'' +
                ", deviceid='" + deviceid + '\'' +
                ", createtime='" + createtime + '\'' +
                ", updatetime='" + updatetime + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", idfa='" + idfa + '\'' +
                ", idfv='" + idfv + '\'' +
                ", channelid='" + channelid + '\'' +
                ", ip='" + ip + '\'' +
                ", network='" + network + '\'' +
                ", devicetype='" + devicetype + '\'' +
                ", os='" + os + '\'' +
                ", op='" + op + '\'' +
                ", resolution='" + resolution + '\'' +
                ", tz='" + tz + '\'' +
                '}';
    }
}
