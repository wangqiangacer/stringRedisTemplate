package com.jacken.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests2 {
        @Autowired
        private StringRedisTemplate stringRedisTemplate;

    @Test
    public void listPushResitTest(){


    }
    @Test
    public  void insert(){
      //  向redis中存入数据和缓存时间
        stringRedisTemplate.opsForValue().set("test","100",60*10, TimeUnit.SECONDS);
       // 做减一操作
        stringRedisTemplate.boundValueOps("test").increment(-1);
       // 根据key获取redis中的val
        String s = stringRedisTemplate.opsForValue().get("test");
        System.out.println(s);
        //做加一操作
        stringRedisTemplate.boundValueOps("test").increment(1);
        System.out.println(stringRedisTemplate.opsForValue().get("test"));
       // 根据key获取过期时间
        System.out.println(stringRedisTemplate.getExpire("test"));
        stringRedisTemplate.opsForValue().set("mongey","100",10,TimeUnit.SECONDS);
        System.out.println(stringRedisTemplate.opsForValue().get("mongey"));
        System.out.println(stringRedisTemplate.getExpire("test", TimeUnit.MINUTES));
        //根据key删除缓存
        Boolean name = stringRedisTemplate.delete("name");
        System.out.println(name);
        //判断key是否存在
        System.out.println(stringRedisTemplate.hasKey("test"));

    }

}
