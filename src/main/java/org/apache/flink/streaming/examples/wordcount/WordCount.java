/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.streaming.examples.wordcount;

import com.mybitop.biaflink.test.MySQLSink;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.examples.wordcount.util.WordCountData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements the "WordCount" program that computes a simple word occurrence
 * histogram over text files in a streaming fashion.
 * <p>
 * <p>The input is a plain text file with lines separated by newline characters.
 * <p>
 * <p>Usage: <code>WordCount --input &lt;path&gt; --output &lt;path&gt;</code><br>
 * If no parameters are provided, the program is run with default data from
 * {@link WordCountData}.
 * <p>
 * <p>This example shows how to:
 * <ul>
 * <li>write a simple Flink Streaming program,
 * <li>use tuple data types,
 * <li>write and use user-defined functions.
 * </ul>
 */
public class WordCount {

    // *************************************************************************
    // PROGRAM
    // *************************************************************************
    private static final Logger logger = LoggerFactory.getLogger( WordCount.class );

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
            text = env.fromElements(WordCountData.WORDS);
        }

        DataStream<Tuple2<String, Integer>> counts =
                // split up the lines in pairs (2-tuples) containing: (word,1)
                // 拆分一行
                text.flatMap(new Tokenizer())
                        // group by the tuple field "0" and sum up tuple field "1"
                        // 按元组字段“0”分组，并汇总元组字段“1”
                        .keyBy(0).sum(1);

        //sink
        counts.addSink(new MySQLSink());

        // emit result
        // 发射结果
//        if (params.has("output")) {
//            counts.writeAsText(params.get("output"));
//        } else {
//            System.out.println("Printing result to stdout. Use --output to specify output path.");
//            counts.print();
//        }

        // execute program
        // 执行程序
        env.execute("Streaming WordCount");

        logger.info("execute program ");
    }

}
