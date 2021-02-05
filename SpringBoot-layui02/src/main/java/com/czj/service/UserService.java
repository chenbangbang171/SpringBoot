package com.czj.service;

import com.czj.pojo.Permission;
import com.czj.pojo.User;

import java.util.List;

public interface UserService {
    User login(String phone, String pwd);

    List<Permission> queryAllPermissionsByUserId(int id);

    List<String> queryAllPermissionsByUserName(String userName);
}
