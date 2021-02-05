package com.czj.controller;

import com.czj.pojo.Order;
import com.czj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("queryAllOrders")
    @ResponseBody
    public ModelAndView queryAllOrders(ModelAndView modelAndView){
        modelAndView.addObject("orderList",orderService.queryAllOrders());
        System.out.println(orderService.queryAllOrders());
        modelAndView.setViewName("/allOrders");
        return modelAndView;
    }


    @RequestMapping("queryPackages")
    @ResponseBody
    public ModelAndView queryPackages(ModelAndView modelAndView){
        modelAndView.addObject("orderList",orderService.queryPackages());
        System.out.println(orderService.queryPackages());
        modelAndView.setViewName("/allOrders");
        return modelAndView;
    }

    @RequestMapping("queryMealOrders")
    @ResponseBody
    public ModelAndView queryMealOrders(ModelAndView modelAndView){
        modelAndView.addObject("orderList",orderService.queryMealOrders());
        System.out.println(orderService.queryMealOrders());
        modelAndView.setViewName("/allOrders");
        return modelAndView;
    }

    @RequestMapping("queryDidiOrders")
    @ResponseBody
    public ModelAndView queryDidiOrders(ModelAndView modelAndView){
        modelAndView.addObject("orderList",orderService.queryDidiOrders());
        System.out.println(orderService.queryDidiOrders());
        modelAndView.setViewName("/allOrders");
        return modelAndView;
    }

    @RequestMapping("queryLostOrders")
    @ResponseBody
    public ModelAndView queryLostOrders(ModelAndView modelAndView){
        modelAndView.addObject("orderList",orderService.queryLostOrders());
        System.out.println(orderService.queryLostOrders());
        modelAndView.setViewName("/allOrders");
        return modelAndView;
    }

    @RequestMapping("queryFileOrders")
    @ResponseBody
    public ModelAndView queryFileOrders(ModelAndView modelAndView){
        modelAndView.addObject("orderList",orderService.queryFileOrders());
        System.out.println(orderService.queryFileOrders());
        modelAndView.setViewName("/allOrders");
        return modelAndView;
    }

    @RequestMapping("queryBuyOrders")
    @ResponseBody
    public ModelAndView queryBuyOrders(ModelAndView modelAndView){
        modelAndView.addObject("orderList",orderService.queryBuyOrders());
        System.out.println(orderService.queryBuyOrders());
        modelAndView.setViewName("/allOrders");
        return modelAndView;
    }



    @RequestMapping("makeNewOrder")
    @ResponseBody
    public ModelAndView makeNewOrder(ModelAndView modelAndView, Order order, HttpServletRequest request){
        int id = (int)request.getSession().getAttribute("id");
        order.setOrderFromUserId(id);
        order.setOrderStatus(0);//设置订单的初始状态为0，即没有人接单
        orderService.makeNewOrder(order);
        modelAndView.addObject("orderList",orderService.queryAllOrders());
        modelAndView.setViewName("/allOrders");
        return modelAndView;
    }


    @RequestMapping("orderManagement")
    public  String orderManagement()  {
        return  "/orderManagement";
    }


}
