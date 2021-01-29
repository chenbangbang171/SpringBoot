package com.czj.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Value("${name}")
    private String name;

    @Value("${user.username}")
    private String username;

    @Value("${user.password}")
    private String userPassWord;

    @Value("${array}")
    private String[] array;

    @RequestMapping("/test")
    public String test() {
//        System.out.println("success");
        System.out.println(name);
        System.out.println(username);
        System.out.println(userPassWord);
        System.out.println(array[0]);
        return "success";
    }

}
