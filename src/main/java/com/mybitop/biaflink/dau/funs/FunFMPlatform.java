package com.mybitop.biaflink.dau.funs;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Android设备处理 2
 */
public class FunFMPlatform implements FlatMapFunction<Tuple2<String, Integer>, Tuple2<String, Integer>> {
    private static final Logger logger = LoggerFactory.getLogger( FunFMPlatform.class );
    private static final long serialVersionUID = 2L;
    @Override
    public void flatMap(Tuple2<String, Integer> stringIntegerTuple2, Collector<Tuple2<String, Integer>> collector) throws Exception {
        collector.collect(new Tuple2<String, Integer>(stringIntegerTuple2.getField(0), stringIntegerTuple2.getField(1)));
//        logger.info("  world: " + stringIntegerTuple2.getField(0) + "  value:  " + stringIntegerTuple2.getField(1));



    }
}
