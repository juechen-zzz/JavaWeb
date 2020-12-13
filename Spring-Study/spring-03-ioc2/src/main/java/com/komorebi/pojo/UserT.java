package com.komorebi.pojo;

public class UserT {
    private String name;

    public UserT() {
        System.out.println("UserT no args!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("name: " + name);
    }
}
