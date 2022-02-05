package com.fouo.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HyperLogLogOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String helloRedis() {
//        redisTemplate.boundValueOps("k1").set("zhangsan");
        HyperLogLogOperations hp = redisTemplate.opsForHyperLogLog();


        hp.add("k7", 1,2,3,4,5 );
        Long k7 = hp.size("k7");
        System.out.println(k7);
        hp.delete(k7);
        return "hello";
    }

}
