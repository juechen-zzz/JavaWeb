package com.komorebi.springbootrabbitmqorderproducer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 死信队列
 * @author: Komorebi
 * @time: 2021/3/21 15:40
 */
@Configuration
public class DeadRabbitMqConfiguration {
    // 1 声明注册direct模式的交换机
    @Bean
    public DirectExchange deadDirectExchange() {
        return new DirectExchange("dead_direct_exchange", true, false);
    }

    // 2 声明队列
    @Bean
    public Queue deadDirectQueue() {
        return new Queue("dead.direct.queue", true);
    }

    // 3 完成绑定关系（队列和交换机完成绑定关系）
    @Bean
    public Binding deadDirectBinding() {
        return BindingBuilder.bind(deadDirectQueue()).to(deadDirectExchange()).with("dead");
    }
}
