package com.komorebi;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        jsonObject.put("name", "komorebi");

        // 开启事务
        Transaction multi = jedis.multi();
        String s = jsonObject.toJSONString();

        try {
            multi.set("user1", s);          // 执行事务
            multi.set("user2", s);
            multi.exec();
        } catch (Exception e) {
            multi.discard();                // 放弃事务
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();                  // 关闭连接
        }

        jedis.flushDB();
    }
}
