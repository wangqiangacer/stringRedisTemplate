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
public class RedisApplicationTests1 {
        @Autowired
        private StringRedisTemplate stringRedisTemplate;

    @Test
    public void listPushResitTest(){
        // leftPush依次由右边添加
        stringRedisTemplate.opsForList().rightPush("myList","1");
        stringRedisTemplate.opsForList().rightPush("myList","2");
        stringRedisTemplate.opsForList().rightPush("myList", "A");
        stringRedisTemplate.opsForList().rightPush("myList", "B");
        // leftPush依次由左边添加
        stringRedisTemplate.opsForList().leftPush("myList", "0");
    }
    @Test
    public  void insert(){
    //向Redis中插入数据并设置超时时间
        //stringRedisTemplate.opsForValue().set("test","100",60*10, TimeUnit.SECONDS);
        //val  做减一操作
       // stringRedisTemplate.boundValueOps("test").increment(-1);
//val  做加一操作
       /// stringRedisTemplate.boundValueOps("test").increment(1);
        //根据key获取过期时间
       // Long test = stringRedisTemplate.getExpire("test");
        //System.out.println(test);
        //Long aLong = stringRedisTemplate.getExpire("test", TimeUnit.SECONDS);
        //System.out.println(aLong);

        //检查key是否存在
       // Boolean key = stringRedisTemplate.hasKey("test");
      //  System.out.println(key);
        //向指定key中存放set集合
        //stringRedisTemplate.opsForSet().add("list","w","a","n","g");

        //设置过期时间
        //stringRedisTemplate.expire("test",10,TimeUnit.SECONDS);

        //根据key判断集合中是否有指定的数据
        //Boolean aBoolean = stringRedisTemplate.opsForSet().isMember("list", "x");
        //System.out.println(aBoolean);

        //获取集合中的所有数据
        Set<String> list = stringRedisTemplate.opsForSet().members("list");
        list.stream().forEach(s -> System.out.print(s));
    }

}
