package com.komorebi.controller;

import com.komorebi.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerUserTest05 {
    // localhost:8080/user/t1?name=xxx
    @GetMapping("/user/t1")
    public String test1(@RequestParam("name") String name1, Model model){
        // 1 接收前端参数
        System.out.println("get : " + name1);

        // 2 将返回的结果传递给前端
        model.addAttribute("message", name1);

        // 3 跳转视图
        return "test";
    }

    // localhost:8080/user/t2?id=1&name=xxx&age=18
    @GetMapping("/user/t2")
    public String test2(User user){
        System.out.println(user);
        return "test";
    }

    @GetMapping("/user/t3")
    public String test3(ModelMap map){
        map.addAttribute("message", "ModelMap");
        return "test";
    }
}
