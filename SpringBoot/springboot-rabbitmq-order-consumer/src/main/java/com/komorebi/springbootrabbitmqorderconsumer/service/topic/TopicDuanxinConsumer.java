package com.komorebi.springbootrabbitmqorderconsumer.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Komorebi
 * @time: 2021/3/21 16:21
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "duanxin.topic.queue", durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange", type = ExchangeTypes.TOPIC),
        key = "#.duanxin.#"
))
public class TopicDuanxinConsumer {
    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("Duanxin topic 接收到消息：" + message);
    }
}
