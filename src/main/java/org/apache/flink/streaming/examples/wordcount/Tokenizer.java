package org.apache.flink.streaming.examples.wordcount;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实现字符串tokenizer拆分成词的句子为
 * Implements the string tokenizer that splits sentences into words as a
 * user-defined FlatMapFunction. The function takes a line (String) and
 * splits it into multiple pairs in the form of "(word,1)" ({@code Tuple2<String,
 * Integer>}).
 */
public class Tokenizer implements FlatMapFunction<String, Tuple2<String, Integer>> {

    private static final Logger logger = LoggerFactory.getLogger( WordCount.class );
    private static final long serialVersionUID = 1L;

    @Override
    public void flatMap(String value, Collector<Tuple2<String, Integer>> out)
            throws Exception {
        // normalize and split the line
        // 正常化并拆分该行
        String[] tokens = value.toLowerCase().split("\\W+");

        // emit the pairs
        // 发出对
        for (String token : tokens) {
            if (token.length() > 0) {
                out.collect(new Tuple2<String, Integer>(token, 1));
                logger.info("  world: " + token + "  value:  " + 1);
            }
        }
    }
}
