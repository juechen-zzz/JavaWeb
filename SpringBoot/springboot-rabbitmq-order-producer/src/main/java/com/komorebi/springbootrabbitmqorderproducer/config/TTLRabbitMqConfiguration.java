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
 * @description: 设置过期时间
 * @author: Komorebi
 * @time: 2021/3/21 15:40
 */
@Configuration
public class TTLRabbitMqConfiguration {
    // 1 声明注册direct模式的交换机
    @Bean
    public DirectExchange ttlDirectExchange() {
        return new DirectExchange("ttl_direct_exchange", true, false);
    }

    // 2 声明队列
    @Bean
    public Queue ttlDirectQueue() {
        // 设置过期时间
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", 5000);
        // 设置死信队列
        args.put("x-dead-letter-exchange", "dead_direct_exchange");
        args.put("x-dead-letter-routing-key", "dead"); // 死信队列是direct模式，需要routing-key
        return new Queue("ttl.direct.queue", true, false, false, args);
    }

    // 3 完成绑定关系（队列和交换机完成绑定关系）
    @Bean
    public Binding ttlDirectBinding() {
        return BindingBuilder.bind(ttlDirectQueue()).to(ttlDirectExchange()).with("ttl");
    }
}
