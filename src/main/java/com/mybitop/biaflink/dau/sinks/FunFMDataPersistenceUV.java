package com.mybitop.biaflink.dau.sinks;

import com.mybitop.biaflink.conf.ConfigMysql;
import com.mybitop.biaflink.utils.PropUtil;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 将数据写入MySQL中 5
 * 或者缓存到Redis中
 * 参考：http://www.jianshu.com/p/b1023b55facb
 */
public class FunFMDataPersistenceUV extends RichSinkFunction<Tuple3<String, String, String>> {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(FunFMDataPersistenceUV.class);

    private Connection connection;
    //准备执行语句
    private PreparedStatement preparedStatement;

    ConfigMysql configMysql = null;

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
//            preparedStatement = connection.prepareStatement(sql);//准备执行语句
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.open(parameters);
    }

    /**
     * invoke()方法解析一个元组数据，并插入到数据库中
     *
     * @param stringStringStringTuple3
     * @throws Exception
     */
    @Override
    public void invoke(Tuple3<String, String, String> stringStringStringTuple3) throws Exception {
//        try {
//            String timeseq = data.getField(0);
//            String thread = data.getField(1);
//            String message = data.getField(2);
//            preparedStatement.setString(1,timeseq);
//            preparedStatement.setString(2,thread);
//            preparedStatement.setString(3,message);
//            preparedStatement.executeUpdate();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

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
