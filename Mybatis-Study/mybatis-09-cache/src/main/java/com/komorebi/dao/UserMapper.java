package com.komorebi.dao;

import com.komorebi.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    // 根据ID查询用户
    User quertUserById(@Param("id") int id);
}
