package com.komorebi.controller;

import com.komorebi.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // 默认请求：/error
    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    // 只要接口中返回值存在实体类，就会被扫描到swagger中
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }

    @ApiOperation("hello控制类")
    @GetMapping(value = "/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello" + username;
    }

    @ApiOperation("post控制类")
    @PostMapping(value = "/postTest")
    public String postTest(@ApiParam("用户") User user){
        return "hello" + user;
    }
}
