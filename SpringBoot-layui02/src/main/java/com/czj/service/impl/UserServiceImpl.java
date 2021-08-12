package com.czj.service.impl;

import com.czj.mapper.UserMapper;
import com.czj.pojo.Permission;
import com.czj.pojo.User;
import com.czj.redisUtil.RedisConfig;
import com.czj.redisUtil.RedisTools;
import com.czj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    @Resource
    private RedisTools redisTools;

    @Override
    public User login(String phone, String pwd) {
        return userMapper.login(phone,pwd);
    }

    @Override
    public List<Permission> queryAllPermissionsByUserId(int id) {
        return userMapper.queryAllPermissionsByUserId(id);
    }

    @Override
    public List<String> queryAllPermissionsByUserName(String userName) {
        return userMapper.queryAllPermissionsByUserName(userName);
    }

    @Override
    public List<User> queryAllUsers() {
        return userMapper.queryAllUsers();
    }

    @Override
    public int deleteUserByUserId(int id) {
        return userMapper.deleteUserByUserId(id);
    }

    @Override
    public int updateUserByUserId(User user) {
        return userMapper.updateUserByUserId(user);
    }

    @Override
    public User queryUserByEmail(String email) {
        return userMapper.queryUserByEmail(email);
    }

    @Override
    public Map<String, String> loginFail(String email) {
        String key  = RedisTools.EXPIRE_USEREMAIL+email;
        StringRedisTemplate stringRedisTemplate = RedisConfig.stringRedisTemplate(redisConnectionFactory);
        Boolean hasKey = stringRedisTemplate.hasKey(key);
        HashMap<String, String> map = new HashMap<>();
        Boolean isFrized = stringRedisTemplate.hasKey(RedisTools.FRIZE_USER_FOR_ONE_HOURE + email);

        if(isFrized){
            map.put("msg","账号被冻结");
            return map;
        }
        //判断是否是第一次输入错误
        if (hasKey) {
            long size = stringRedisTemplate.opsForList().size(key);
            if( 3 == size || 2 == size){
                redisTools.frizeUser(email);
                stringRedisTemplate.delete(key);
                map.put("msg","十分钟内输错密码三次，冻结账号一个小时");
                return map;
            }else {
                stringRedisTemplate.opsForList().leftPush(key,"1");
                map.put("msg","输入错误，请重试");
                return map;
            }
        } else {
            //第一次或第二次输入错误,创建集合，并设置过期时间为10分钟
            stringRedisTemplate.opsForList().leftPush(key,"1");
            redisTools.setKeyExpire(key,10, TimeUnit.MINUTES);
            map.put("msg","输入错误，请重试");
        }
        return map;
    }


}
