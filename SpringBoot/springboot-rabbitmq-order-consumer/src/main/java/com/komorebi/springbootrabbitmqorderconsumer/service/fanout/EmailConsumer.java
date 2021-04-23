package com.komorebi.springbootrabbitmqorderconsumer.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Komorebi
 * @time: 2021/3/21 16:19
 */
@Component
@RabbitListener(queues = {"email.fanout.queue"})
public class EmailConsumer {
    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("Email fanout 接收到消息：" + message);
    }
}
