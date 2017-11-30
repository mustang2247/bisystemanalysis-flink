package com.mybitop.biaflink.dau.sources;

import com.mybitop.biaflink.conf.ConfigMysql;
import com.mybitop.biaflink.entity.BiPayment;
import com.mybitop.biaflink.utils.PropUtil;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SourceMySQL extends RichSourceFunction<BiPayment> {
//    private String sqlinsert = "insert into bi_user (deviceid,appID,userID,userOpenID,userName,userGold,userDiamond,userSex,userLevel,userExp,userIsRecharged,userVIPExp,createTime,updateTime,clientV) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//    private String sqlupdate = "update bi_user set userName=?, userGold=?, userDiamond=?, userSex=?, userLevel=?, userExp=?, userIsRecharged=?, userVIPExp=?, updateTime=?, clientV=? where deviceid=? and appID=? and userID=?";
//    private String selectsql = "select * from bi_user where appID=? and userID=?";
    private String selectsql = "select * from bi_payment";

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(SourceMySQL.class);

    private Connection connection;
    //准备执行语句
    private PreparedStatement preparedStatement;

    ConfigMysql configMysql = null;

    /**
     * 一、open()方法中建立连接，这样不用每次invoke的时候都要建立连接和释放连接。
     * @param parameters
     * @throws Exception
     */
    @Override
    public void open(Configuration parameters) throws Exception {
        // 初始化JDBC连接信息
        if (configMysql == null) {
            String envDir = PropUtil.getProp("/env.properties", "envdir");
            configMysql = new ConfigMysql();
            configMysql.init("/" + envDir + "sourcemysql.properties");
        }

        try {
            //1.加载驱动
            Class.forName(configMysql.DRIVER);
            //2.创建连接
            connection = DriverManager.getConnection(configMysql.ADDR, configMysql.LOGIN_NAME, configMysql.LOGIN_PASS);

            //3.获得执行语句
            preparedStatement = connection.prepareStatement(selectsql);//准备执行语句
        } catch (Exception e) {
            e.printStackTrace();
        }

        super.open(parameters);
    }

    /**
     * 二、DataStream调用一次run()方法用来获取数据
     * @param sourceContext
     * @throws Exception
     */
    @Override
    public void run(SourceContext sourceContext) throws Exception {
        try {
            //4.执行查询，封装数据
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BiPayment biPayment = new BiPayment(
                resultSet.getInt("id"),
                resultSet.getString("appid").trim(),
                resultSet.getString("who").trim(),
                resultSet.getString("deviceid").trim(),
                resultSet.getDate("createtime"),

                resultSet.getDate("updatetime"),
                resultSet.getString("transactionid").trim(),
                resultSet.getString("paymenttype").trim(),
                resultSet.getString("currencytype").trim(),
                resultSet.getString("currencyamount").trim(),

                resultSet.getString("virtualcoinamount").trim(),
                resultSet.getString("iapname").trim(),
                resultSet.getString("iapamount").trim(),
                resultSet.getString("serverid").trim(),
                resultSet.getString("channelid").trim(),

                resultSet.getString("idfa").trim(),
                resultSet.getString("idfv").trim(),
                resultSet.getString("level").trim(),
                resultSet.getString("clientV").trim()
                );

                sourceContext.collect(biPayment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 三、 程序执行完毕就可以进行，关闭连接和释放资源的动作了
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        //5.关闭连接和释放资源
        super.close();
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public void cancel() {

    }
}
