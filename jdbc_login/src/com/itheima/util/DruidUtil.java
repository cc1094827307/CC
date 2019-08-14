package com.itheima.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtil {
    //1、初始化数据源：仅需1次即可
    private static DataSource dataSource;
    static{
        try {
            //加载配置文件
            InputStream inputStream = DruidUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties props = new Properties();
            props.load(inputStream);
            //使用工厂创建数据源即可
            dataSource = DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            throw new RuntimeException("初始化Druid数据源失败，请检查您的配置文件",e);
        }
    }
    //2、提供公共的获取数据源的方法
    public static DataSource getDataSource(){
        return dataSource;
    }
    //3、提供公共的获取数据库连接的方法（要从数据源中获取）
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("从连接池中获取连接失败，请稍后再试",e);
        }
    }

    //测试一下
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
