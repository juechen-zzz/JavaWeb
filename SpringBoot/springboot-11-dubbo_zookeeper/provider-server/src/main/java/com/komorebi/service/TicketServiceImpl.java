package com.komorebi.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

// zookeeper：服务注册与发现
@Component          // 使用了Dubbo后尽量不用Service注解
@DubboService       // 可以被扫描到，在项目一启动就自动注册到注册中心
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "komorebi";
    }
}
