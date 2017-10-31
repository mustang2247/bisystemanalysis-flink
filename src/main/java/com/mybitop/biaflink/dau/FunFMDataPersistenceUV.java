package com.mybitop.biaflink.dau;

import com.mybitop.biaflink.redis.RedisManager;
import org.apache.flink.api.common.io.OutputFormat;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 将数据写入MySQL中 5
 * 或者缓存到Redis中
 */
public class FunFMDataPersistenceUV extends RichSinkFunction<Tuple3<String, String, String>> {
    private static final Logger logger = LoggerFactory.getLogger( FunFMDataPersistenceUV.class );

    private Connection connection;
    private PreparedStatement preparedStatement;

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
    }

    @Override
    public void invoke(Tuple3<String, String, String> stringStringStringTuple3) throws Exception {

    }

    @Override
    public void close() throws Exception {
        super.close();
    }

}
