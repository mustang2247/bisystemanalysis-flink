package com.mybitop.biaflink.dau;

import com.mybitop.biaflink.dau.util.PreLoadData;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAUTopology {

    private static final Logger logger = LoggerFactory.getLogger( DAUTopology.class );

    public static void main(String[] args) throws Exception {
        logger.info("let is begining^^^^^^");
        // Checking input parameters
        // 检查输入参数
        final ParameterTool params = ParameterTool.fromArgs(args);

        // set up the execution environment
        // 建立执行环境
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // make parameters available in the web interface
        // 使参数在Web接口中可用
        env.getConfig().setGlobalJobParameters(params);

        // get input data
        // 获取数据
        // 数据的不可变集合，而DataStream的数据是无界的。
        // 不可变意味着对它们增减元素，你也不能简单地检查里面的元素。
        // 一个集合通过在Flink程序中增加数据源初始化，而一个新的集合通过针对之前的集合map、filter转化得到。
        DataStream<String> text;
        if (params.has("input")) {
            // read the text file from given input path
            // 从给定输入路径读取文本文件
            text = env.readTextFile(params.get("input"));
        } else {
            System.out.println("Executing WordCount example with default input data set.");
            System.out.println("Use --input to specify file input.");
            // get default test text data
            // 获取默认测试文本数据
            PreLoadData.loader();
            text = env.fromElements(PreLoadData.WORDS);
        }

        DataStream<Tuple2<String, Integer>> counts =
                // split up the lines in pairs (2-tuples) containing: (word,1)
                // 拆分一行
                text.flatMap(new FunFMDataParse());

        // emit result
        // 发射结果
        if (params.has("output")) {
            counts.writeAsText(params.get("output"));
        } else {
            System.out.println("Printing result to stdout. Use --output to specify output path.");
            counts.print();
        }

        // execute program
        // 执行程序
        env.execute("Streaming WordCount");

        logger.info("execute program ");
    }

}