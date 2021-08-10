package com.czj.controller;

import com.czj.pojo.Order;
import com.czj.pojo.User;
import com.czj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("queryAllOrders")
    @ResponseBody
    public ModelAndView queryAllOrders(ModelAndView modelAndView){
        modelAndView.addObject("orderList",orderService.queryPublishedOrders());
        modelAndView.setViewName("/allOrders");
        return modelAndView;
    }

    @RequestMapping("orderManagement")
    @ResponseBody
    public ModelAndView layuiPage(ModelAndView modelAndView){
//        modelAndView.addObject("orderList",orderService.queryAllOrders());
//        System.out.println(orderService.queryAllOrders());
        modelAndView.setViewName("/orderManagement");
        return modelAndView;
    }

    @RequestMapping("updateOrderByOrderId")
    @ResponseBody
    public HashMap<String,String> updateOrderByOrderId(Order order){
        orderService.updateOrderByOrderId(order);

        HashMap<String, String> map = new HashMap<>();
        map.put("msg","success");
        return map;
    }

    @RequestMapping("deleteOrderByOrderId")
    @ResponseBody
    public HashMap<String,String> deleteOrderByOrderId(Order order){
        orderService.deleteOrderByOrderId(order.getOrderId());

        HashMap<String, String> map = new HashMap<>();
        map.put("msg","success");
        return map;
    }

    @RequestMapping("getOrderDetail")
    @ResponseBody
    public HashMap<String,String> getOrderDetail(Order order){
        int orderId = order.getOrderId();

        HashMap<String, String> map = new HashMap<>();
        map.put("msg","success");
        return map;
    }




    @RequestMapping("getData")
    @ResponseBody
    public Map<String,Object> layuiPage(){
        List<Order> orders = orderService.queryAllOrders();
        for (Order order: orders) {
            if (order.getOrderStatus() == 0){
                order.setOrderNewStatus("等待中");
            }else if(order.getOrderStatus() ==1){
                order.setOrderNewStatus("进行中");
            }else {
                order.setOrderNewStatus("已结束");
            }
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","ok");
        map.put("count",orders.size());
        map.put("data",orders);
        return map;
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
        order.setOrderToUserId(0);
        orderService.makeNewOrder(order);
        modelAndView.addObject("orderList",orderService.queryAllOrders());
        modelAndView.setViewName("/allOrders");
        return modelAndView;
    }


    @RequestMapping("recive")
    @ResponseBody
    public Map<String,String> recive(String orderId, HttpServletRequest request,ModelAndView modelAndView){
        int userId = (int)request.getSession().getAttribute("id");
        System.out.println(orderId);
        System.out.println(userId);
        orderService.reciveOrder(userId, Integer.parseInt(orderId));
        orderService.updateOrderStatus(Integer.parseInt(orderId));
        Map<String, String> map = new HashMap<>();
        map.put("msg","success");

        return map;
    }


    @RequestMapping("endOrder")
    @ResponseBody
    public Map<String,String> endOrder(Order order){
        orderService.endOrder(order.getOrderId());

        HashMap<String, String> map = new HashMap<>();
        map.put("msg","success");
        return map;
    }




    //获取我发布的所有订单
    @RequestMapping("getMyPublish")
    @ResponseBody
    public  Map<String, Object> getMyPublish(HttpServletRequest request)  {
        int id = (int)request.getSession().getAttribute("id");
        List<Order> orders = orderService.getMyPublishde(id);

        for (Order order: orders) {
            if (order.getOrderStatus() == 0){
                order.setOrderNewStatus("等待中");
            }else if(order.getOrderStatus() ==1){
                order.setOrderNewStatus("进行中");
            }else {
                order.setOrderNewStatus("已结束");
            }
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","ok");
        map.put("count",orders.size());
        map.put("data",orders);
        return map;
    }


  //获取我发布的所有订单
    @RequestMapping("getMyRecive")
    @ResponseBody
    public  Map<String, Object> getMyRecive(HttpServletRequest request)  {
        int id = (int)request.getSession().getAttribute("id");
        List<Order> orders = orderService.getMyRecived(id);
        for (Order order: orders) {
            if (order.getOrderStatus() == 0){
                order.setOrderNewStatus("等待中");
            }else if(order.getOrderStatus() ==1){
                order.setOrderNewStatus("进行中");
            }else {
                order.setOrderNewStatus("已结束");
            }
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","ok");
        map.put("count",orders.size());
        map.put("data",orders);
        return map;
    }



}
