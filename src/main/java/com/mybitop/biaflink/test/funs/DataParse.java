package com.mybitop.biaflink.test.funs;

import com.mybitop.biaflink.entity.BiPayment;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.util.Collector;

import java.util.Date;

public class DataParse implements FlatMapFunction<BiPayment, Tuple4<String, String, Date, Integer>> {
    @Override
    public void flatMap(BiPayment biPayment, Collector<Tuple4<String, String, Date, Integer>> collector) throws Exception {
        if (biPayment != null){

            String channelId = "_default_";
            if(biPayment.getChannelid() != null && !biPayment.getChannelid().isEmpty()){
                channelId = biPayment.getChannelid();
            }

            String appid = "1";
            if(biPayment.getAppid() != null && !biPayment.getAppid().isEmpty()){
                appid = biPayment.getAppid();
            }

            collector.collect(new Tuple4<String, String, Date, Integer>(appid, channelId, biPayment.getCreatetime(), Integer.parseInt(biPayment.getCurrencyamount())));
        }
    }
}
