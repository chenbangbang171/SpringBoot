package com.czj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class Controller {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/testString")
    public String test(){

        //redisTemplate.opsForValue();//操作字符串
        //redisTemplate.opsForList();//操作List
        //redisTemplate.opsForSet();//操作Set
        //redisTemplate.opsForZSet();//操作ZSet
        //redisTemplate.opsForHash();//操作Map

        redisTemplate.opsForValue().set("username","jack");
        String username = (String)redisTemplate.opsForValue().get("username");
        System.out.println(username);

        stringRedisTemplate.opsForValue().set("password","123");
        String password = stringRedisTemplate.opsForValue().get("password");

        System.out.println(password);

        return "success";
    }
}
