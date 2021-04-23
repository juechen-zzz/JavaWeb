package com.komorebi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    2 用注解的形式
 */

@Controller
public class ControllerDemo02 {
    @RequestMapping("/t2")
    public String test1(Model model) {
        model.addAttribute("message", "ControllerTest2");
        return "test";
    }

    @RequestMapping("/t3")
    public String test2(Model model) {
        model.addAttribute("message", "ControllerTest2");
        return "test";
    }

    @RequestMapping("/t4")
    public String test3(Model model) {
        model.addAttribute("message", "Redirect");
        return "redirect:/index.jsp";
    }
}
