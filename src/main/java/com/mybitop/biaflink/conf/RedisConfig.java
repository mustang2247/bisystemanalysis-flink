/**
 * Author: guanxin
 * Date: 2015-07-24
 */

package com.mybitop.biaflink.conf;

import com.mybitop.biaflink.utils.PropUtil;

import java.util.Properties;

/**
 * redis config
 */
public class RedisConfig {

    public int REDIS_PORT;

    public String REDIS_HOST;

    public String password;

    public String jedisName;

    public boolean init(String filePath) {
        return init(PropUtil.getProps(filePath));
    }

    public boolean init(Properties props) {
        REDIS_HOST = props.getProperty("redis.host").trim();
        jedisName = props.getProperty("redis.name").trim();
        password = props.getProperty("redis.password").trim();
        REDIS_PORT = Integer.parseInt(props.getProperty("redis.port").trim());
        return extraInit(props);
    }

    public boolean extraInit(Properties props) {
        return true;
    }
}
