package com.mybitop.biaflink.dau.sinks;

import com.mybitop.biaflink.redis.RedisManager;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

public class SinkDataPersistenceUV extends RichSinkFunction<Tuple2<String, Integer>> {
    private static final Logger logger = LoggerFactory.getLogger( SinkDataPersistenceUV.class );

    private Jedis jedis = null;

    @Override
    public void open(Configuration parameters) throws Exception {
//        super.open(parameters);
        jedis = RedisManager.getJedis();
    }

    @Override
    public void invoke(Tuple2<String, Integer> record) throws Exception {
        logger.info("FunFMDataPersistenceUV   writeRecord");
        jedis.hset("startup", record.getField(0), record.getField(1));
    }

    @Override
    public void close() throws Exception {
        super.close();
    }
}
