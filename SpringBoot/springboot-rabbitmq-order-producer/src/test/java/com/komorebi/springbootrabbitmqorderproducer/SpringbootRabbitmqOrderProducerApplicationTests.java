package com.komorebi.springbootrabbitmqorderproducer;

import com.komorebi.springbootrabbitmqorderproducer.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRabbitmqOrderProducerApplicationTests {
    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        orderService.makeOrder("1", "1", 12);
    }

    @Test
    void testOrderDirect() {
        orderService.makeOrderDirect("1", "2", 3);
    }

    @Test
    void testOrderTopic() {
        orderService.makeOrderTopic("1", "2", 3);
    }

    @Test
    void testOrderTTL() {
        orderService.makeOrderTTL("1", "2", 3);
    }
}
