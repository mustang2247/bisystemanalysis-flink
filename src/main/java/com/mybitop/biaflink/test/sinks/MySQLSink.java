package com.mybitop.biaflink.test.sinks;

import com.mybitop.biaflink.conf.ConfigMysql;
import com.mybitop.biaflink.utils.PropUtil;
import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * 将数据写入MySQL中 5
 * 或者缓存到Redis中
 * 参考：http://www.jianshu.com/p/b1023b55facb
 */
public class MySQLSink extends RichSinkFunction<Tuple4<String, String, Date, Integer>> {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(MySQLSink.class);

    private Connection connection;
    //准备执行语句
    private PreparedStatement preparedStatement;
    private PreparedStatement preparedSelectStatement;
    private PreparedStatement preparedUpdateStatement;

    ConfigMysql configMysql = null;


    private String selectsql = "select * from bi_install where appid=? and channelid=? and datetime=?";
    private String sqlupdate = "update bi_install set count=? where id=?";

    /**
     * open方法是初始化方法，会在invoke方法之前执行，执行一次。
     *
     * @param parameters
     * @throws Exception
     */
    @Override
    public void open(Configuration parameters) throws Exception {

        // 初始化JDBC连接信息
        if (configMysql == null) {
            String envDir = PropUtil.getProp("/env.properties", "envdir");
            configMysql = new ConfigMysql();
            configMysql.init("/" + envDir + "mysql.properties");
        }

        try {
            // 加载JDBC驱动
            Class.forName(configMysql.DRIVER);
            // 获取数据库连接
            connection = DriverManager.getConnection(configMysql.ADDR, configMysql.LOGIN_NAME, configMysql.LOGIN_PASS);

            String sql = "insert into bi_install ( appid, channelid, datetime, count) values (?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);//准备执行语句
            preparedSelectStatement = connection.prepareStatement(selectsql);//准备执行语句
            preparedUpdateStatement = connection.prepareStatement(sqlupdate);//准备执行语句
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.open(parameters);
    }

    /**
     * invoke()方法解析一个元组数据，并插入到数据库中
     *
     * @param data
     * @throws Exception
     */
    @Override
    public void invoke(Tuple4<String, String, Date, Integer> data) throws Exception {
        try {
            String appid = data.getField(0);
            String channelid = data.getField(1);
            Date datetime = data.getField(2);
            Integer count = data.getField(3);

            preparedSelectStatement.setString(1,appid);
            preparedSelectStatement.setString(2,channelid);
            preparedSelectStatement.setDate(3, new java.sql.Date(datetime.getTime()));

            int id = -1;
            ResultSet rowsAffected = preparedSelectStatement.executeQuery();
            if(rowsAffected.next()){
                id = rowsAffected.getInt(1);
            }
            if (id > 0){
                preparedUpdateStatement.setInt(1,count);
                preparedUpdateStatement.setInt(2,id);
                preparedUpdateStatement.executeUpdate();
            }else {
                preparedStatement.setString(1,appid);
                preparedStatement.setString(2,channelid);
                preparedStatement.setDate(3, new java.sql.Date(datetime.getTime()));
                preparedStatement.setInt(4,count);
                preparedStatement.executeUpdate();
            }


//            logger.info("MySQLSink  invoke:  world :  " + world + "  count: " + count);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * close()是tear down的方法，在销毁时执行，关闭连接
     *
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        super.close();
    }

}
