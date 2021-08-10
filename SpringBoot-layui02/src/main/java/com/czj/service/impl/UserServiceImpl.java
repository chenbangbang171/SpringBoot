package com.czj.service.impl;

import com.czj.mapper.UserMapper;
import com.czj.pojo.Permission;
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
}
