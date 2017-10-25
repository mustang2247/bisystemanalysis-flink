package com.mybitop.biaflink.conf;

/**
 * 配置文件
 */
public class ConfigConstent {

    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)
    public final static int MAX_ACTIVE = 5000;
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8
    public final static int MAX_IDLE = 800;
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException
    public final static int MAX_WAIT = 10000;
    public final static int TIMEOUT = 10 * 1000;


    //================date================
    public static final String LOG_CHANNEL = "log";

}
