package com.mybitop.biaflink.dau;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 解析数据并分组 1
 */
public class FunFMDataParse implements FlatMapFunction<String, Tuple2<String, Integer>> {

    private static final Logger logger = LoggerFactory.getLogger( FunFMDataParse.class );
    private static final long serialVersionUID = 1L;

    @Override
    public void flatMap(String value, Collector<Tuple2<String, Integer>> out)
            throws Exception {
        // normalize and split the line
        // 正常化并拆分该行
//        String[] tokens = value.toLowerCase().split("\\W+");
        out.collect(new Tuple2<String, Integer>(value, 1));
        logger.info("  world: " + value + "  value:  " + 1);
        // emit the pairs
        // 发出对
//        for (String token : tokens) {
//            if (token.length() > 0) {
//                out.collect(new Tuple2<String, Integer>(token, 1));
//                logger.info("  world: " + token + "  value:  " + 1);
//            }
//        }
    }
}
