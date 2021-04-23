package com.komorebi.springbootrabbitmqorderconsumer.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Komorebi
 * @time: 2021/3/21 16:22
 */
@Component
@RabbitListener(queues = {"sms.direct.queue"})
public class DirectSmsConsumer {
    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("Sms direct 接收到消息：" + message);
    }
}
