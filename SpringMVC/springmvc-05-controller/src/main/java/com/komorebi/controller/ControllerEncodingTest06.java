package com.komorebi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerEncodingTest06 {
    @RequestMapping("/e/t1")
    public String test1(String name, Model model) {
        model.addAttribute("message", name);              //获取表单提交的值
        return "test";                                      //跳转到test页面显示输入的值
    }
}
