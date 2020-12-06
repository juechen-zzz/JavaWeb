package com.komorebi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.komorebi.pojo.User;
import com.komorebi.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @RequestMapping("/j1")
//    @ResponseBody           // 不走视图解析器，直接返回一个字符串
    public String json1() throws JsonProcessingException {
        // jsakson, ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        User user = new User("komorebi1", 18, "man");

        String s = mapper.writeValueAsString(user);
        return s;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();

        List<User> userList = new ArrayList<User>();

        User user1 = new User("komorebi1", 18, "man");
        User user2 = new User("komorebi2", 18, "man");
        User user3 = new User("komorebi3", 18, "man");
        User user4 = new User("komorebi4", 18, "man");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String s = mapper.writeValueAsString(userList);
        return s;
    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        // 自定义日期的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 1 Java方式输出
//        String s = mapper.writeValueAsString(sdf.format(date));     // ObjectMapper，时间解析器后的默认格式为：Timestamp,时间戳

        // 2 使用ObjectMapper解决
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setDateFormat(sdf);
        String s = mapper.writeValueAsString(date);
        return s;
    }

    @RequestMapping("/j4")
    public String json4() throws JsonProcessingException{
        Date date = new Date();
        String t = JsonUtils.getJson(date);
        return t;
    }

    @RequestMapping("/j5")
    public String json5(){
        //创建一个对象
        User user1 = new User("K1号", 30, "男");
        User user2 = new User("K2号", 30, "男");
        User user3 = new User("K3号", 30, "男");
        User user4 = new User("K4号", 30, "男");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSONString(list)==>" + str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>" + str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jpUser1 = JSON.parseObject(str2, User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>" + jpUser1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>" + jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User toJavaUser = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>" + toJavaUser);
        return str1;
    }
}
