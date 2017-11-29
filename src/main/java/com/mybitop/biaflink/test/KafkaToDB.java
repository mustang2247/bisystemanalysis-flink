package com.mybitop.biaflink.test;

import com.mybitop.biaflink.test.sources.PostgreSQLSink;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;

/**
 * 1 获得一个 execution environment
 * 2 加载/创建初始数据（Source）
 * 3 指定在该数据上进行的转换（Transformations）
 * 4 指定计算结果的存储地方（Sink）
 * 5 启动程序执行。
 */
public class KafkaToDB {

    public static void main(String[] args) throws Exception {
        // 解析参数
        final ParameterTool parameterTool = ParameterTool.fromArgs(args);
        if (parameterTool.getNumberOfParameters() < 4) {
            System.out.println("Missing parameters!");
            System.out.println("\nUsage: Kafka --topic <topic> " +
                    "--bootstrap.servers <kafka brokers> " +
                    "--zookeeper.connect <zk quorum> --group.id <some id>");
            return;
        }

        // 获取StreamExecutionEnvironment。
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.getConfig().disableSysoutLogging();
        env.getConfig().setRestartStrategy(RestartStrategies.fixedDelayRestart(4, 10000));
        // create a checkpoint every 5 secodns
        env.enableCheckpointing(5000);
        // make parameters available in the web interface
        env.getConfig().setGlobalJobParameters(parameterTool);

        // source
        DataStream<String> sourceStream = env.addSource(
                new FlinkKafkaConsumer010<String>(parameterTool.getRequired("topic"),
                        new SimpleStringSchema(), parameterTool.getProperties()));
        // Transformation，这里仅仅是过滤了null。
        DataStream<Tuple3<String, String, String>> messageStream = sourceStream
                .map(new InputMap())
                .filter(new NullFilter());
        //sink
        messageStream.addSink(new PostgreSQLSink());

        env.execute("Write into PostgreSQL");
    }

    // 过滤Null数据。
    public static class NullFilter implements FilterFunction<Tuple3<String, String, String>> {
        @Override
        public boolean filter(Tuple3<String, String, String> value) throws Exception {
            return value != null;
        }
    }

    // 对输入数据做map操作。
    public static class InputMap implements MapFunction<String, Tuple3<String, String, String>> {
        private static final long serialVersionUID = 1L;

        @Override
        public Tuple3<String, String, String> map(String line) throws Exception {
            // normalize and split the line
            String[] arr = line.toLowerCase().split(",");
            if (arr.length > 2) {
                return new Tuple3<>(arr[0], arr[1], arr[2]);
            }
            return null;
        }
    }

}