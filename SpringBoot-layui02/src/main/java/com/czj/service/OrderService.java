package com.czj.service;

import com.czj.pojo.Order;

import java.util.List;

public interface OrderService {

    List<Order> queryAllOrders();

    List<Order> queryPublishedOrders();//查询所有订单

    int updateOrderStatus(int orderId);//更新订单状态，接收订单

    List<Order> queryPackages();

    List<Order> queryMealOrders();//查询所有送餐类订单

    int endOrder(int orderId);//结束订单

    List<Order> queryDidiOrders();//查询所有校园滴滴类订单

    List<Order> queryFileOrders();//查询所有送文件类订单

    List<Order> queryBuyOrders();//查询所有代购类订单

    List<Order> queryLostOrders();//查询所有代购类订单

    int makeNewOrder(Order order);//创建一个新订单

    int deleteOrderByOrderId(int id);//根据订单id删除订单

    int updateOrderByOrderId(Order order);//根据订单id修改订单

    List<Order> getMyPublishde(int id);//根据用户id查询该用户的发布的订单

    List<Order> getMyRecived(int id);//根据用户id查询该用户接收的订单

    int reciveOrder(int userId, int orderId);


}
