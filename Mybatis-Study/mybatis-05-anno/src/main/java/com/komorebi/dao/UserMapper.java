package com.komorebi.dao;

import com.komorebi.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select id, name, pwd as password from User")
    List<User> getUsers();

    // 方法存在多个参数，所有的参数前面必须加上@Param注解
    @Select("select id, name, pwd as password from User where id = #{id}")
    User getUserByID(@Param("id") int id);

    @Insert("insert into user(id, name, pwd) values (#{id}, #{name}, #{password})")
    int addUser(User user);

    @Update("update user set name = #{name}, pwd = #{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);
}
