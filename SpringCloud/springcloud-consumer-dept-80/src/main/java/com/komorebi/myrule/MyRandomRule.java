package com.komorebi.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MyRandomRule extends AbstractLoadBalancerRule {
    // 每个服务，访问5次，换下一个服务(3个)

    private int total = 0;  // 被调用的测试
    private int currentIdx = 0; // 当前提供服务的索引

    //@edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers(); // 获取存活的服务
            List<Server> allList = lb.getAllServers();      // 获取全部的服务

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            // int index = chooseRandomInt(serverCount);   // 生成区间随机数
            // server = upList.get(index);                 // 从活着的服务中随机获取一个

            // ===============自定义部分==============

            server = upList.get(currentIdx);
            total += 1;

            // 如果调用了五次，那么切换到下一个服务
            if (total == 5) {
                currentIdx = (currentIdx + 1) % upList.size();
                total = 0;
            }

            // =====================================

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }

        return server;

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
