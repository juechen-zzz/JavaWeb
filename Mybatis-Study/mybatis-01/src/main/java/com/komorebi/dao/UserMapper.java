package com.komorebi.dao;

import com.komorebi.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();

    // 根据ID查询用户
    User getUserById(int id);

    // insert一个用户
    int addUser(User user);

    // 修改用户
    int updateUser(User user);

    // 删除一个用户
    int deleteUser(int id);

    // 用map作为输入
    int addUser2(Map<String, Object> map);

    // 模糊查询
    List<User> getUserLike(String value);
}
