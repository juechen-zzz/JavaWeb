package com.komorebi.dao;

import com.komorebi.pojo.User;
import com.komorebi.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        logger.info("info:进入testGetUserById方法");

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
        logger.info("info:关闭testGetUserById方法");
    }

    @Test
    public void testLog4j() {
        logger.info("info:进入testLog4j");
        logger.debug("info:进入了Debug");
        logger.error("info:进入了error");
    }

    @Test
    public void testGetUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 1);
        map.put("pageSize", 2);

        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void testGetUserByRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 2);

        // 通过Java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.komorebi.dao.UserMapper.getUserByRowBounds", null, rowBounds);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
