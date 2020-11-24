package com.komorebi.mapper;

import com.komorebi.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> selectUser();

    // add
    public int addUser(User user);

    // delete
    public int deleteUser(int id);
}
