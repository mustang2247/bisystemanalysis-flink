package com.mybitop.biaflink.conf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static Map<String, String> getFlinkConfs(Map conf) {
        String kafkaBrokers = getKafkaBrokers(conf);
        String zookeeperServers = getZookeeperServers(conf);

        Map<String, String> flinkConfs = new HashMap<String, String>();
        flinkConfs.put("topic", getKafkaTopic(conf));
        flinkConfs.put("bootstrap.servers", kafkaBrokers);
        flinkConfs.put("zookeeper.connect", zookeeperServers);
        flinkConfs.put("jedis_server", getRedisHost(conf));
        flinkConfs.put("group.id", "myGroup");

        return flinkConfs;
    }

    /**
     * 获取zookeeper配置文件
     * @param conf
     * @return
     */
    private static String getZookeeperServers(Map conf) {
        if(!conf.containsKey("zookeeper.servers")) {
            throw new IllegalArgumentException("Not zookeeper servers found!");
        }
        return listOfStringToString((List<String>) conf.get("zookeeper.servers"), String.valueOf(conf.get("zookeeper.port")));
    }

    /**
     * 获取kafka配置文件
     * @param conf
     * @return
     */
    private static String getKafkaBrokers(Map conf) {
        if(!conf.containsKey("kafka.brokers")) {
            throw new IllegalArgumentException("No kafka brokers found!");
        }
        if(!conf.containsKey("kafka.port")) {
            throw new IllegalArgumentException("No kafka port found!");
        }
        return listOfStringToString((List<String>) conf.get("kafka.brokers"), String.valueOf(conf.get("kafka.port")));
    }

    /**
     * 获取kafka topic
     * @param conf
     * @return
     */
    private static String getKafkaTopic(Map conf) {
        if(!conf.containsKey("kafka.topic")) {
            throw new IllegalArgumentException("No kafka topic found!");
        }
        return (String)conf.get("kafka.topic");
    }

    /**
     * 获取redis host
     * @param conf
     * @return
     */
    private static String getRedisHost(Map conf) {
        if(!conf.containsKey("redis.host")) {
            throw new IllegalArgumentException("No redis host found!");
        }
        return (String)conf.get("redis.host");
    }

    public static String listOfStringToString(List<String> list, String port) {
        String val = "";
        for(int i=0; i<list.size(); i++) {
            val += list.get(i) + ":" + port;
            if(i < list.size()-1) {
                val += ",";
            }
        }
        return val;
    }

}
