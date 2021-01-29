package com.czj.controller;

import com.czj.pojo.City;
import com.czj.pojo.User;
import com.czj.service.CityService;
import com.czj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/carsys")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

    @RequestMapping("toLogin")
    public String toLogin(){
        return "/pagehome/login";
    }

    @RequestMapping("user/login.do")
    @ResponseBody
    public Map<String,String> login(String tel, String password, HttpServletRequest request){
        User user = userService.login(tel, password);
        HashMap<String, String> map = new HashMap<>();
        if (user != null){
            request.getSession().setAttribute("user",user);
            map.put("code","1");
        }else {
            map.put("info","用户不存在");
        }
        return map;
    }

    @RequestMapping("toIndex")
    public String toIndex(){
        return "/pagehome/loginsuccess";
    }

    @RequestMapping("toRent")
    public String toRent(){
        List<City> cities = cityService.queryAllCity();


        return "/shortRent/shortRent";
    }
}
