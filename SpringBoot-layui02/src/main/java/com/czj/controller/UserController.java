package com.czj.controller;

import com.czj.pojo.User;
import com.czj.service.UserService;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
import java.util.List;
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

    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("id");
        request.getSession().invalidate();
        return "/login-3";
    }

     @RequestMapping("public")
    public  String toPublic( )  {
        //去数据库查到所有的订单，带到前端
        return "/allOrders";
    }

  @RequestMapping("myOrders")
    public  String myOrders( )  {
       //跳转到我的订单页面，下面有俩选项，一个我的发布，一个我的接收
        return "/myOrders";
    }

     @RequestMapping("toMyPublish")
    public  String toMyPublish( )  {
        //跳转到我的发布
        return "/myPublish";
    }

     @RequestMapping("toMyRecive")
    public  String toMyRecive( )  {
        //跳转到我的接收
        return "/myRecive";
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
        boolean rememberMe = false;
        Map<String, String> map = new HashMap<>();


        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(id, passWord, rememberMe);
        subject.login(token);

        if (subject.isAuthenticated()) {
            User user = userService.login(id, passWord);
            System.out.println(user.getUserId());
            request.getSession().setAttribute("id", user.getUserId());
            map.put("msg","success");
            return map;
        }else {
            map.put("msg","false");
            return map;
        }
    }

    @RequestMapping("updateUserByUserId")
    @ResponseBody
    public  HashMap<String,String> updateUserByUserId(User user)  {
        userService.updateUserByUserId(user);

        HashMap<String, String> map = new HashMap<>();

        map.put("msg","success");
        return map;
    }


  @RequestMapping("deleteUserByUserId")
    @ResponseBody
    public  HashMap<String,String> deleteUserByUserId(User user)  {
        userService.deleteUserByUserId(user.getUserId());

        HashMap<String, String> map = new HashMap<>();

        map.put("msg","success");
        return map;
    }

    @RequestMapping("userManagement")
    @ResponseBody
    public  ModelAndView userManagement(ModelAndView modelAndView)  {
        modelAndView.setViewName("/userManagement");
        return modelAndView ;
    }



    @RequestMapping("getDatas")
    @ResponseBody
    public  Map<String, Object> getData()  {
        List<User> users = userService.queryAllUsers();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","ok");
        map.put("count",users.size());
        map.put("data",users);
        return map;
    }

}
