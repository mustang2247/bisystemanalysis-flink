package com.mybitop.biaflink.test;

import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class PostgreSQLSink extends RichSinkFunction<Tuple3<String,String,String>> {

    private static final long serialVersionUID = 1L;

    private Connection connection;
    private PreparedStatement preparedStatement;
    /**
     * open方法是初始化方法，会在invoke方法之前执行，执行一次。
     */
    @Override
    public void open(Configuration parameters) throws Exception {
        // JDBC连接信息
        String USERNAME = "postgres" ;
        String PASSWORD = "********";
        String DRIVERNAME = "org.postgresql.Driver";
        String DBURL = "jdbc:postgresql://192.168.1.213/flink";
        // 加载JDBC驱动
        Class.forName(DRIVERNAME);
        // 获取数据库连接
        connection = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        String sql = "insert into kafka_message(timeseq, thread, message) values (?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        super.open(parameters);
    }

    /**
     * invoke()方法解析一个元组数据，并插入到数据库中。
     * @param data 输入的数据
     * @throws Exception
     */
    @Override
    public  void invoke(Tuple3<String,String,String> data) throws Exception{
        try {
            String timeseq = data.getField(0);
            String thread = data.getField(1);
            String message = data.getField(2);
            preparedStatement.setString(1,timeseq);
            preparedStatement.setString(2,thread);
            preparedStatement.setString(3,message);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    };

    /**
     * close()是tear down的方法，在销毁时执行，关闭连接。
     */
    @Override
    public void close() throws Exception {
        if(preparedStatement != null){
            preparedStatement.close();
        }
        if(connection != null){
            connection.close();
        }
        super.close();
    }
}