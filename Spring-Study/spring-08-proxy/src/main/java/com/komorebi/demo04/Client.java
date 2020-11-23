package com.komorebi.demo04;

import com.komorebi.demo02.UserService;
import com.komorebi.demo02.UserServiceImpl;
import com.komorebi.demo03.Host;
import com.komorebi.demo03.Rent;

public class Client {
    public static void main(String[] args) {
        // 真实角色
        UserServiceImpl userService = new UserServiceImpl();

        // 代理角色
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        pih.setTarget(userService); // 设置要代理的对象

        // 动态生成代理类
        UserService proxy = (UserService) pih.getProxy();
        proxy.add();

//        Host host = new Host();
//
//        ProxyInvocationHandler pih = new ProxyInvocationHandler();
//        pih.setTarget(host);
//
//        Rent proxy = (Rent) pih.getProxy();
//        proxy.rent();
    }
}
