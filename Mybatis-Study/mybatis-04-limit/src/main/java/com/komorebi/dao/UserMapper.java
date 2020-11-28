package com.komorebi.dao;

import com.komorebi.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 根据ID查询用户
    User getUserById(int id);

    // limit分页查询
    List<User> getUserByLimit(Map<String, Integer> map);

    // RowBounds分页
    List<User> getUserByRowBounds();
}
