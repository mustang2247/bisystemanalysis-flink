package com.mybitop.biaflink.dau;

import com.mybitop.biaflink.entity.Startup;
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

    private int sum = 0;

    @Override
    public void flatMap(String value, Collector<Tuple2<String, Integer>> out)
            throws Exception {
        // normalize and split the line
        // 正常化并拆分该行
        String[] tokens = value.split("\t");
        Startup startup;
        try {
            startup = new Startup(tokens);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
        sum ++ ;
        out.collect(new Tuple2<String, Integer>(startup.getDeviceid(), sum));
        logger.info("  world: " + startup.getChannelid() + "  value:  " + sum);
    }
}
