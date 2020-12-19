package com.komorebi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot05DataApplicationTests {

    @Autowired
    DataSource datasource;

    @Test
    void contextLoads() throws SQLException {
        // 查看默认的数据源  class com.zaxxer.hikari.HikariDataSource
        System.out.println(datasource.getClass());

        // 获得数据库连接
        Connection connection = datasource.getConnection();
        System.out.println(connection);

        // xxx Template: springboot已经配置好的模板bean


        // 关闭
        connection.close();
    }
}
