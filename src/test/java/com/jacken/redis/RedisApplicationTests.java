package com.jacken.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {
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
       // stringRedisTemplate.opsForValue().set("test","100",60*10, TimeUnit.SECONDS);
        //获取值
//        String test = stringRedisTemplate.opsForValue().get("test");
////        System.out.println(test);
        //val做减一操作
//        Long test = stringRedisTemplate.boundValueOps("test").increment(-1);
//        System.out.println(test);
        //val做+1操作
//        Long test = stringRedisTemplate.boundValueOps("test").increment(1);
//        System.out.println(test);
        //根据key获取过期时间
//        Long test1 = stringRedisTemplate.getExpire("test",TimeUnit.SECONDS);
//        System.out.println(test1);

       // stringRedisTemplate.opsForValue().set("test1","50");
       // stringRedisTemplate.delete("test1");
//        Boolean key = stringRedisTemplate.hasKey("test1");
//        System.out.println(key);

        //获取全部
//        List<String> myList = stringRedisTemplate.opsForList().range("myList", 0, -1);
//        for (String s : myList) {
//            System.out.println(s);
//        }

//        String myList = stringRedisTemplate.opsForList().index("myList", 2);
//        System.out.println(myList);

       // stringRedisTemplate.opsForList().rightPush("myList","B","C");
//        Long myList = stringRedisTemplate.opsForList().size("myList");
//        System.out.println(myList);

        // stringRedisTemplate.opsForList().remove("myList", 0, "w");
       // stringRedisTemplate.opsForList().rightPush("myList","w");
//        List<String> myList = stringRedisTemplate.opsForList().range("myList", 0, -1);
//        myList.stream().distinct().forEach(s -> System.out.println(s));

    }

}
