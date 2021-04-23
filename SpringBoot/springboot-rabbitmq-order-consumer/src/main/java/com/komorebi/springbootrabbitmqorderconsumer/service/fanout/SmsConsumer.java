package com.komorebi.springbootrabbitmqorderconsumer.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Komorebi
 * @time: 2021/3/21 16:22
 */
@Component
@RabbitListener(queues = {"sms.fanout.queue"})
public class SmsConsumer {
    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("Sms fanout 接收到消息：" + message);
    }
}
