package com.komorebi.dao;

import com.komorebi.pojo.User;
import com.komorebi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.quertUserById(1);
        System.out.println(user1);
        sqlSession.close();

        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.quertUserById(1);
        System.out.println(user2);
        sqlSession2.close();
    }
}
