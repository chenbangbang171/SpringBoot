package com.czj.service;

import com.czj.pojo.User;

import java.util.List;

public interface UserService {

    List<User> queryAllUser();

    void addUser(User user);

    User queryUserById(int id);

}
