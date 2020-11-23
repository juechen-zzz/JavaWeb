package com.komorebi.config;

import com.komorebi.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 这个也会被Spring容器托管，注册到容器中，因为其本身就是一个Component，@Configuration代表这是一个配置类（beans.xml）
@Configuration
@ComponentScan("com.komorebi.pojo")
@Import(KomorebiConfig2.class)
public class KomorebiConfig {
    // 注册一个Bean，就相当于我们之前写的一个Bean标签
    // 这个方法的名字，就相当于Bean标签中的ID属性
    // 这个方法的返回值，就相当于Bean标签中的class属性
    @Bean
    public User getUser(){
        return new User();      // 就是返回要注入到Bean中的对象
    }
}
