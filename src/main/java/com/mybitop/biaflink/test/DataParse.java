package com.mybitop.biaflink.test;

import com.mybitop.biaflink.entity.BiPayment;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class DataParse implements FlatMapFunction<BiPayment, Tuple2<String, Integer>> {
    @Override
    public void flatMap(BiPayment biPayment, Collector<Tuple2<String, Integer>> collector) throws Exception {
        if (biPayment != null){

            String channelId = "_default_";
            if(biPayment.getChannelid() != null && !biPayment.getChannelid().isEmpty()){
                channelId = biPayment.getChannelid();
            }

            collector.collect(new Tuple2<>(channelId, Integer.parseInt(biPayment.getCurrencyamount())));
        }
    }
}
