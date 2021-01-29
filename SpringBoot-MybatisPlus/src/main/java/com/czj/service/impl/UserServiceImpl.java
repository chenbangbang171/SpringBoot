package com.czj.service.impl;

import com.czj.mapper.UserMapper;
import com.czj.pojo.User;
import com.czj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAllUser() {
        return userMapper.selectList(null);
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User queryUserById(int id) {
        return userMapper.selectById(id);
    }
}
