package com.komorebi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nhp")
public class HelloController {

    @RequestMapping("/hello")           // 真实访问地址   Localhost:8080/nhp/hello
    public String hello(Model model) {
        // 封装数据
        model.addAttribute("message", "Hello, SpringMVC Annotation!");
        return "hello";         // 会被视图解析器处理, /WEB-INF/jsp/hello.jsp
    }
}
