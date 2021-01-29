package com.czj.controller;

import com.czj.pojo.User;
import com.czj.service.UserService;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String index() {
        return "/index";
    }

    @RequestMapping("main")
    public String main() {
        return "/main";
    }

    @RequestMapping("login3")
    public String login3() {
        return "/login-3";
    }

//    @RequestMapping("guangchang")
//    public String guangchang() {
//        return "/guangchang";
//    }

     @RequestMapping("public")
    public  String toPublic( )  {
        //去数据库查到所有的订单，带到前端
        return "/allOrders";
    }

    @RequestMapping("publish")
    public  String publish()  {
        return  "/publishOrder";
    }

    @RequestMapping("userLogin")
    @ResponseBody
    public Map<String,String> userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("username");
        String passWord = request.getParameter("password");
//        PrintWriter writer = response.getWriter();
        Map<String, String> map = new HashMap<>();
        User user = userService.login(id, passWord);
        if (user != null) {
            System.out.println(user.getUserId());
            request.getSession().setAttribute("id", user.getUserId());
            map.put("msg","success");
            return map;
        } else {
            map.put("msg","false");
            return map;
        }
    }
}
