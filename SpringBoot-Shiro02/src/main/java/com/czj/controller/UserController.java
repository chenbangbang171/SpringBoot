package com.czj.controller;

import com.czj.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("toLogin")
    public String toLogin() {
        System.out.println("toLogin");

        return "/login";
    }

    @RequestMapping("login")
    public String login(User user, boolean rememberMe) {
        System.out.println("login" + user);

        if (user.getUser_name() != null) {
            String username = user.getUser_name();
            String passwrod = user.getUser_pwd();
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, passwrod, rememberMe);
            subject.login(token);

            if (subject.isAuthenticated()) {
                return "/index";
            }
        }
        return "/login";
    }


    @RequestMapping("refuse")
    public String refuse() {
        System.out.println("refuse");
        return "/refuse";
    }


    @RequestMapping("index")
    public String index() {
        System.out.println("index");
        return "/index";
    }


    @RequestMapping("add")
    public String add() {
        System.out.println("add");
        return "/add";
    }

    @RequestMapping("delete")
    public String delete() {
        System.out.println("delete");
        return "/delete";
    }

    @RequestMapping("update")
    public String update() {
        System.out.println("update");
        return "/update";
    }

    @RequestMapping("query")
    public String query() {
        System.out.println("query");
        return "/query";
    }


}
