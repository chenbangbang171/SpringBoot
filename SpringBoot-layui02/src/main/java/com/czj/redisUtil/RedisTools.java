package com.czj.redisUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@Component
public class RedisTools {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public static String EXPIRE_USEREMAIL= "EXPIRE_USEREMAIL:";

    public static String FRIZE_USER_FOR_ONE_HOURE = "FRIZED:";

    public void setKeyExpire(String key, long time, TimeUnit timeUnit){
        stringRedisTemplate.opsForValue().getOperations().expire(key,time, timeUnit);

    }

    public void frizeUser(String email){
        String key = FRIZE_USER_FOR_ONE_HOURE + email;
        //达到三次冻结账号，创建一个冻结标记，该标记持续一个小时
        stringRedisTemplate.opsForValue().set(key,email);
        this.setKeyExpire(key,1,TimeUnit.HOURS);
    }




}
