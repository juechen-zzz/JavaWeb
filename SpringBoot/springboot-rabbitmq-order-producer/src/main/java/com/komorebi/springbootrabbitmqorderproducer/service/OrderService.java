package com.komorebi.springbootrabbitmqorderproducer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @description:
 * @author: Komorebi
 * @time: 2021/3/21 15:15
 */
@Service
public class OrderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * @description
     * @date 2021/3/21
     * @param [userId, productId, num]
     * @return
     */
    public void makeOrder(String userId, String productId, int num) {
        // 1 根据商品ID查询库存
        // 2 保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功" + orderId);

        // 3 通过MQ完成消息的分发
        // 参数1：交换机  参数2：路由key/queue队列名称  参数3：消息内容
        String exchangeName = "fanout_order_exchange";
        String routingKey = "";
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId);
    }

    /**
     * @description
     * @date 2021/3/22
     * @param [userId, productId, num]
     * @return
     */
    public void makeOrderDirect(String userId, String productId, int num) {
        // 1 根据商品ID查询库存
        // 2 保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功" + orderId);

        // 3 通过MQ完成消息的分发
        // 参数1：交换机  参数2：路由key/queue队列名称  参数3：消息内容
        String exchangeName = "direct_order_exchange";
        rabbitTemplate.convertAndSend(exchangeName, "email", orderId);
        rabbitTemplate.convertAndSend(exchangeName, "duanxin", orderId);
    }

    /**
     * @description
     * @date 2021/3/22
     * @param [userId, productId, num]
     * @return
     */
    public void makeOrderTopic(String userId, String productId, int num) {
        // 1 根据商品ID查询库存
        // 2 保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功" + orderId);

        // 3 通过MQ完成消息的分发
        // 参数1：交换机  参数2：路由key/queue队列名称  参数3：消息内容
        String exchangeName = "topic_order_exchange";
        String routingKey = "com.email.duanxin";
        // "#.duanxin.#"    duanxin
        // "*.email.#"      email
        // "com.#"          sms
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId);
    }

    /**
     * @description
     * @date 2021/3/22
     * @param [userId, productId, num]
     * @return
     */
    public void makeOrderTTL(String userId, String productId, int num) {
        // 1 根据商品ID查询库存
        // 2 保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功" + orderId);

        // 3 通过MQ完成消息的分发
        // 参数1：交换机  参数2：路由key/queue队列名称  参数3：消息内容
        String exchangeName = "ttl_direct_exchange";
        String routingKey = "ttl";
        // "#.duanxin.#"    duanxin
        // "*.email.#"      email
        // "com.#"          sms
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId);
    }
}
