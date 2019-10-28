package com.edu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtils {
    public  static  SqlSession getSession(){
        /**1，读取配置文件
         2，生成SqlSessionFactory
         为SqlSession的工厂，用于建立与数据库的会话。
         3，建立SqlSession
         用于执行sql语句
         4，调用MyBatis提供的api
         5，查询MAP配置
         6，返回结果
         7，关闭SqlSession
         */
            String resource = "map/MyBatisConfig.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
                .build(reader);
        session = sqlMapper.openSession();
        return session;

    }
}
