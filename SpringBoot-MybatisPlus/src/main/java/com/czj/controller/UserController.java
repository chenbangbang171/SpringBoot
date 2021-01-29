package com.czj.controller;

import com.czj.pojo.User;
import com.czj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("queryAllUser")
    public void queryAllUser(){
        System.out.println(userService.queryAllUser());
    }

    @RequestMapping("addUser")
    public void addUser(){
        User user = new User();
        user.setId("1000");
        user.setUserName("狗子");
        user.setPassWord("gouzi");
        user.setEmail("1000");
        user.setFlag("1");
        user.setGender("男");

        userService.addUser(user);
    }

    @RequestMapping("queryUserById")
    public void queryUserById() {
       int id = 1000;

        System.out.println(userService.queryUserById(id));;
    }

}
