package com.komorebi.springbootrabbitmqorderproducer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: Komorebi
 * @time: 2021/3/21 15:40
 */
@Configuration
public class DirectRabbitMqConfiguration {
    // 1 声明注册direct模式的交换机
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_order_exchange", true, false);
    }

    // 2 声明队列
    @Bean
    public Queue directSmsQueue() {
        return new Queue("sms.direct.queue", true);
    }
    @Bean
    public Queue directDuanxinQueue() {
        return new Queue("duanxin.direct.queue", true);
    }
    @Bean
    public Queue directEmailQueue() {
        return new Queue("email.direct.queue", true);
    }

    // 3 完成绑定关系（队列和交换机完成绑定关系）
    @Bean
    public Binding directSmsBinding() {
        return BindingBuilder.bind(directSmsQueue()).to(directExchange()).with("sms");
    }
    @Bean
    public Binding directDuanxinBinding() {
        return BindingBuilder.bind(directDuanxinQueue()).to(directExchange()).with("email");
    }
    @Bean
    public Binding directEmailBinding() {
        return BindingBuilder.bind(directEmailQueue()).to(directExchange()).with("duanxin");
    }
}
