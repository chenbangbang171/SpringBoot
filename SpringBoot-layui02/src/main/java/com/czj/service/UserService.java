package com.czj.service;

import com.czj.pojo.Order;
import com.czj.pojo.Permission;
import com.czj.pojo.User;

import java.util.List;

public interface UserService {
    User login(String phone, String pwd);

    List<Permission> queryAllPermissionsByUserId(int id);

    List<String> queryAllPermissionsByUserName(String userName);

    List<User> queryAllUsers();//查询所有用户

    int deleteUserByUserId(int id);//根据用户id删除用户

    int updateUserByUserId(User user);//根据用户id修改用户信息



}
