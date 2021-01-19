package com.komorebi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.komorebi.pojo.User;
import com.komorebi.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
        // redisTemplate
        // opsForValue  操作字符串，类似String
        // opsForList   操作List，类似List...
        // 常用的方法可以直接通过template操作，比如事务

        // 获取连接
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();

        redisTemplate.opsForValue().set("mykey", "komorebi");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }

    @Test
    public void test() throws JsonProcessingException {
        // 真实开发用json传送对象
        User user = new User("komorebi", 18);
//        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Test
    public void test1() {
        redisUtil.set("name", "komorebi");
        redisUtil.set("name2", "komorebi");
        redisUtil.set("name3", "komorebi");
        System.out.println(redisUtil.get("name"));
        redisUtil.del("name", "name2");
    }
}