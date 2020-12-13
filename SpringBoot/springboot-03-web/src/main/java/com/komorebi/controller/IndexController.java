package com.komorebi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

// 在templates目录下的所有页面，只能通过Controller跳转
// 需要模板引擎的支持
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/t1")
    public String test1(Model model){
        model.addAttribute("msg","Hello,Thymeleaf");
        return "test";
    }

    @RequestMapping("/t2")
    public String test2(Map<String,Object> map){
        //存入数据
        map.put("msg","<h1>Hello</h1>");
        map.put("users", Arrays.asList("k1","k2"));
        //classpath:/templates/test.html
        return "test2";
    }
}
