/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mybitop.biaflink.dau.util;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides the default data sets used for the WordCount example program.
 * The default data sets are used, if no parameters are given to the program.
 */
public class PreLoadData {

    public static String[] WORDS = new String[]{};

    public static void loader(){
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

			/* 读入TXT文件 */
            String fileName = "test.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            InputStream is = null;
            URL url = null;
            try {
                is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
                if (is == null) {
                    throw new FileNotFoundException(fileName + " file is not found");
                }

                url = Thread.currentThread().getContextClassLoader().getResource(fileName);

            } catch (IOException e) {
//                LOGGER.error("load properties file failure", e);
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
//                        LOGGER.error("close input stream failure", e);
                    }
                }
            }

            File filename = new File(url.getPath()); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";

            List<String> lines = new ArrayList<>();
            while (br.ready()) {
                line = br.readLine(); // 一次读入一行数据
                if(line != null && !line.isEmpty()){
                    lines.add(line);
                    System.out.println(line);
                }
            }
            WORDS = (String[]) lines.toArray(new String[lines.size()]);

            br.close();
            reader.close();
//            System.out.println(lines);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        loader();
    }

}
