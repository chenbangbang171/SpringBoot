package com.czj.service.impl;

import com.czj.mapper.UserMapper;
import com.czj.pojo.User;
import com.czj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String phone, String pwd) {
        return userMapper.login(phone,pwd);
    }
}
