package com.czj.filter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filter")
public class filterTest {

    @RequestMapping("/login")
    public  String login(){
        System.out.println("登录");
        return "login";
    }

}
