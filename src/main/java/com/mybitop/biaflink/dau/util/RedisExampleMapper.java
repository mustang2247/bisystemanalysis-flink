package com.mybitop.biaflink.dau.util;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommand;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommandDescription;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisMapper;

public class RedisExampleMapper implements RedisMapper<Tuple2<String, Integer>> {
    @Override
    public RedisCommandDescription getCommandDescription() {
        return new RedisCommandDescription(RedisCommand.HSET, "startup");
    }

    @Override
    public String getKeyFromData(Tuple2<String, Integer> stringStringTuple2) {
        return stringStringTuple2.f0;
    }

    @Override
    public String getValueFromData(Tuple2<String, Integer> stringStringTuple2) {
        return String.valueOf(stringStringTuple2.f1);
    }
}
