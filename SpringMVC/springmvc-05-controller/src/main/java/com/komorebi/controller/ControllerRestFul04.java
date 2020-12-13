package com.komorebi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerRestFul04 {
    // 原来:      localhost:8080/add?a=2&b=3
    // RestFul:  localhost:8080/add/2/3

    @RequestMapping(value = "/add/{a}/{b}", method = {RequestMethod.GET})
    public String test1(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("message", "结果为：" + res);
        return "test";
    }
}
