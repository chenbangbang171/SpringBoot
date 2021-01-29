package com.czj.service;

import com.czj.pojo.User;

public interface UserService {
    User login(String phone, String pwd);
}
