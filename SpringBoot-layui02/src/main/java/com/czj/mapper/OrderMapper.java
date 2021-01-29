package com.czj.mapper;

import com.czj.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    List<Order> queryAllOrders();//查询所有订单

    List<Order> queryPackagesOrders();//查询所有快递类订单1

    List<Order> queryMealOrders();//查询所有送餐类订单2

    List<Order> queryDidiOrders();//查询所有校园滴滴类订单3

    List<Order> queryFileOrders();//查询所有送文件类订单4

    List<Order> queryBuyOrders();//查询所有代购类订单5

    List<Order> queryLostOrders();//查询所有少丢丢类订单6

    int makeNewOrder(Order order);//创建一个新订单
}
