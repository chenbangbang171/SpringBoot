package com.czj.service;

import com.czj.pojo.Order;

import java.util.List;

public interface OrderService {

    List<Order> queryAllOrders();

    List<Order> queryPackages();

    List<Order> queryMealOrders();//查询所有送餐类订单

    List<Order> queryDidiOrders();//查询所有校园滴滴类订单

    List<Order> queryFileOrders();//查询所有送文件类订单

    List<Order> queryBuyOrders();//查询所有代购类订单

    List<Order> queryLostOrders();//查询所有代购类订单

    int makeNewOrder(Order order);//创建一个新订单



}
