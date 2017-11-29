package com.mybitop.biaflink.redis;

import com.mybitop.biaflink.conf.ConfigConstent;
import com.mybitop.biaflink.conf.ConfigRedis;
import com.mybitop.biaflink.utils.PropUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis操作接口
 */
public class RedisManager {

    private static final Logger logger = LoggerFactory.getLogger(RedisManager.class);

    private static JedisPool pool = null;
    private static ConfigRedis redisConfig;

    /**
     * 构建redis连接池
     *
     * @return JedisPool
     */
    private static JedisPool getPool() {
        if (redisConfig == null) {
            String envDir = PropUtil.getProp("/env.properties", "envdir");
            redisConfig = new ConfigRedis();
            redisConfig.init("/" + envDir + "redis.properties");
        }

        if (pool == null) {

            JedisPoolConfig config = new JedisPoolConfig();
            //控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
            //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
            config.setMaxActive(ConfigConstent.MAX_ACTIVE);//500
            //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
            config.setMaxIdle(ConfigConstent.MAX_IDLE);//5
            //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
            config.setMaxWait(ConfigConstent.MAX_WAIT);//1000 * 100
            //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
            config.setTestOnBorrow(true);

            if(redisConfig.password == null || redisConfig.password.isEmpty()){
                pool = new JedisPool(config, redisConfig.REDIS_HOST, redisConfig.REDIS_PORT, ConfigConstent.TIMEOUT);
            }else {
                pool = new JedisPool(config, redisConfig.REDIS_HOST, redisConfig.REDIS_PORT, ConfigConstent.TIMEOUT, redisConfig.password);
            }

            logger.info("init JedisPool ok ");
        }
        return pool;
    }

    /**
     * 返还到连接池
     *
     * @param pool
     * @param redis
     */
    public static void returnResource(JedisPool pool, Jedis redis) {
        if (redis != null) {
            pool.returnResource(redis);
        }
    }

    /**
     * 获取数据
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        String value = null;
        try {
            value = getJedis().get(key);
        } catch (Exception e) {
            //释放redis对象
            e.printStackTrace();
        }

        return value;
    }

    /**
     * 写入数据
     *
     * @param key
     * @param value
     */
    public static void set(String key, String value) {
        try {
            getJedis().set(key, value);

            logger.info("set redis key: " + key + "  value:  " + value);
        } catch (Exception e) {
            //释放redis对象
            e.printStackTrace();
        }
    }

    /**
     * 返回jedis
     *
     * @return
     */
    public static Jedis getJedis() {
        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = getPool();
            jedis = pool.getResource();
        } catch (Exception e) {
            //释放redis对象
            if(jedis != null) {
                pool.returnBrokenResource(jedis);
            }
            e.printStackTrace();
        } finally {
            //返还到连接池
            returnResource(pool, jedis);
        }

        return jedis;
    }


}
