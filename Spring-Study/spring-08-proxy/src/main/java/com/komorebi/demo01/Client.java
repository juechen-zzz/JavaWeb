package com.komorebi.demo01;

public class Client {
    public static void main(String[] args) {
        Host host = new Host();

        Proxy proxy = new Proxy(host);
        proxy.rent();
        proxy.seeHouse();       // 附属操作
    }
}
