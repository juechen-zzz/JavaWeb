package com.komorebi.rabbitmq.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @author: Komorebi
 * @time: 2021/3/16 15:17
 */
public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 所有的中间件技术都是基于tcp/ip协议基础之上构建新型的协议规范，只不过rabbitmq遵循的是amqp

        // 1：创建连接工程
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("47.110.157.73");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("komorebi");
        connectionFactory.setPassword("123456");
        connectionFactory.setVirtualHost("/");

        // 2：创建连接Connection
        Connection connection = connectionFactory.newConnection("消费者");

        // 3：通过连接获取通道Channel
        Channel channel = connection.createChannel();

        // 4：通过通道创建交换机，声明队列，绑定关系，路由Key，发送消息和接收消息
        channel.basicConsume("queue1", true, new DeliverCallback() {
            public void handle(String s, Delivery message) throws IOException {
                System.out.println("收到消息是" + new String(message.getBody(), "UTF-8"));
            }
        }, new CancelCallback() {
            public void handle(String s) throws IOException {
                System.out.println("接收失败了...");
            }
        });
        System.out.println("开始接收消息");
        System.in.read();

        // 5：关闭连接
        if (channel != null && channel.isOpen()) {
            channel.close();
        }

        // 6：关闭通道
        if (connection != null && connection.isOpen()) {
            connection.close();
        }
    }
}
