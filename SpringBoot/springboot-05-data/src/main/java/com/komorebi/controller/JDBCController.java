package com.komorebi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 查询数据库的所有信息
    @GetMapping("/userlist")
    @ResponseBody
    public List<Map<String, Object>> userList(){
        String sql = "select * from mybatis.user";
        List<Map<String, Object>> listMaps = jdbcTemplate.queryForList(sql);
        return listMaps;
    }

    // 增加用户
    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into mybatis.user(id,name,pwd) values(5, 'kk', '123')";
        jdbcTemplate.update(sql);
        return "redirect:/userlist";
    }

    // 修改用户
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update mybatis.user set name=?,pwd=? where id=" + id;
        Object[] objects = new Object[2];
        objects[0] = "ming1";
        objects[1] = "123123";
        jdbcTemplate.update(sql, objects);
        return "redirect:/userlist";
    }

    // 删除用户
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from mybatis.user where id=?";
        jdbcTemplate.update(sql, id);
        return "redirect:/userlist";
    }
}
