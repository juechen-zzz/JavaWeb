package com.komorebi.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc3 {

    @Test
    public void test() {
        // 配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false";
        String username = "root";
        String password = "123456";

        Connection connection = null;

        // 1 加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // 2 连接数据库
            connection = DriverManager.getConnection(url, username, password);

            // 3 通知数据库开启事务,false是开启
            connection.setAutoCommit(false);
            String sql1 = "update account set money = money+100 where name = 'A'";
            connection.prepareStatement(sql1).executeUpdate();

            // 制造错误
            int i = 1 / 0;

            String sql2 = "update account set money = money-100 where name = 'B'";
            connection.prepareStatement(sql2).executeUpdate();

            connection.commit();
            System.out.println("提交成功");

        } catch (Exception e) {
            // 如果出现异常，就通知数据库回滚事务
            try {
                connection.rollback();
                System.out.println("Error");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            // 4 关闭
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
