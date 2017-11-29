package com.mybitop.biaflink.test;

import com.mybitop.biaflink.entity.BiPayment;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class SourceFromMysqlTest {

    public static void main(String[] args) throws Exception {
        //1.创建流执行环境
        // Checking input parameters
        // 检查输入参数
        final ParameterTool params = ParameterTool.fromArgs(args);

        // set up the execution environment
        // 建立执行环境
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // make parameters available in the web interface
        // 使参数在Web接口中可用
        env.getConfig().setGlobalJobParameters(params);

        //2.从自定义source中读取数据
        DataStream<BiPayment> students = env.addSource(new MySQLSource());

        students.flatMap(new DataParse())
                .keyBy(0)
                .sum(1)
                .addSink(new MySQLSink());

        //sink

        //3.显示结果
//        students.print();

        //4.触发流执行
        env.execute();
    }

}
