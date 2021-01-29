package com.czj.service.impl;

import com.czj.mapper.PermissionMapper;
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

    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public List<Permission> queryAllPermission(int userid) {
        return userMapper.queryAllPermissionsByUserId(userid);
    }

    @Override
    public List<String> queryAllPermissionsByUserName(String userName) {
        return userMapper.queryAllPermissionsByUserName(userName);
    }

    @Override
    public User queryUserByNameAndPwd(String userName, String userPwd) {
        return userMapper.queryUserByNameAndPwd(userName,userPwd);
    }
}
