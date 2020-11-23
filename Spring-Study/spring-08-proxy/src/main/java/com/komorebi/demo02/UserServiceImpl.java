package com.komorebi.demo02;

// 真实对象
public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("Add");
    }

    public void delete() {
        System.out.println("delete");
    }

    public void update() {
        System.out.println("Update");
    }

    public void query() {
        System.out.println("Query");
    }
}
