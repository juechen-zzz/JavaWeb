package com.komorebi.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: RabbitMQ基础实现
 * @author: Komorebi
 * @time: 2021/3/16 15:17
 */
public class Producer {
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
        Connection connection = connectionFactory.newConnection("生产者");

        // 3：通过连接获取通道Channel
        Channel channel = connection.createChannel();

        // 4：通过通道创建交换机，声明队列，绑定关系，路由Key，发送消息和接收消息
        String queueName = "queue1";
        /**
         * @params1 队列的名称
         * @params2 是否要持久化durable=false
         * @params3 排他性，是否是独占
         * @params4 是否自动删除，随着最后一个消费者消息完毕后是否把队列自动删除
         * @params5 携带附属参数
         */
        channel.queueDeclare(queueName, false, false, false, null);

        // 5：发送消息内容
        String message = "hello rabbitmq";

        // 6：发送消息给队列queue
        /**
         * @params1：交换机
         * @params2：队列，路由key
         * @params3：消息的状态控制
         * @params4：消息主题
         */
        channel.basicPublish("", queueName, null, message.getBytes());
        System.out.println("消息发送成功");

        // 7：关闭连接
        if (channel != null && channel.isOpen()) {
            channel.close();
        }

        // 8：关闭通道
        if (connection != null && connection.isOpen()) {
            connection.close();
        }
    }
}
