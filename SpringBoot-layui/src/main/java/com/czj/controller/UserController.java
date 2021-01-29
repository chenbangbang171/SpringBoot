package com.czj.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("index")
    public String index(){
        return "/index";
    }

    @RequestMapping("login")
    public String login(){
        return "/login";
    }

}
