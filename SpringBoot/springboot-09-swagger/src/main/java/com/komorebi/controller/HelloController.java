package com.komorebi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // 默认请求：/error
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
