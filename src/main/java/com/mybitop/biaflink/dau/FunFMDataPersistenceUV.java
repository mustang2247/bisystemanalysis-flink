package com.mybitop.biaflink.dau;

import com.mybitop.biaflink.redis.RedisManager;
import org.apache.flink.api.common.io.OutputFormat;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.io.IOException;

/**
 * 将数据写入MySQL中 5
 * 或者缓存到Redis中
 */
public class FunFMDataPersistenceUV implements OutputFormat<Tuple2<String, Integer>> {
    private static final Logger logger = LoggerFactory.getLogger( FunFMDataPersistenceUV.class );

    private Jedis jedis = null;
    @Override
    public void configure(Configuration configuration) {
        RedisManager.getJedis();
        logger.info("FunFMDataPersistenceUV   configure");
    }

    @Override
    public void open(int i, int i1) throws IOException {
        if(jedis == null){
            jedis = RedisManager.getJedis();
        }

        logger.info("FunFMDataPersistenceUV   open");
    }

    @Override
    public void writeRecord(Tuple2<String, Integer> record) throws IOException {
        logger.info("FunFMDataPersistenceUV   writeRecord");
        jedis.hset("startup", record.getField(0), record.getField(1));
    }

    @Override
    public void close() throws IOException {

    }
}
