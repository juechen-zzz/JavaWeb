package com.komorebi.springbootrabbitmqorderconsumer.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Komorebi
 * @time: 2021/3/21 16:19
 */
@Component
@RabbitListener(queues = {"email.direct.queue"})
public class DirectEmailConsumer {
    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("Email direct 接收到消息：" + message);
    }
}
