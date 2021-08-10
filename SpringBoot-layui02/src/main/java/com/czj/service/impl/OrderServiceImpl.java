package com.czj.service.impl;

import com.czj.mapper.OrderMapper;
import com.czj.pojo.Order;
import com.czj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> queryAllOrders() {
        return orderMapper.queryAllOrders();
    }

    @Override
    public List<Order> queryPublishedOrders() {
        return orderMapper.queryPublishedOrders();
    }

    @Override
    public int updateOrderStatus(int orderId) {
        return orderMapper.updateOrderStatus(orderId);
    }

    @Override
    public List<Order> queryPackages() {
        return orderMapper.queryPackagesOrders();
    }

    @Override
    public List<Order> queryMealOrders() {
        return orderMapper.queryMealOrders();
    }

    @Override
    public int endOrder(int orderId) {
        return orderMapper.endOrder(orderId);
    }

    @Override
    public List<Order> queryDidiOrders() {
        return orderMapper.queryDidiOrders();
    }

    @Override
    public List<Order> queryFileOrders() {
        return orderMapper.queryFileOrders();
    }

    @Override
    public List<Order> queryBuyOrders() {
        return orderMapper.queryBuyOrders();
    }

    @Override
    public List<Order> queryLostOrders() {
        return orderMapper.queryLostOrders();
    }

    @Override
    public int makeNewOrder(Order order) {
        return orderMapper.makeNewOrder(order);
    }

    @Override
    public int deleteOrderByOrderId(int id) {
        return orderMapper.deleteOrderByOrderId(id);
    }

    @Override
    public int updateOrderByOrderId(Order order) {
        return orderMapper.updateOrderByOrderId(order);
    }

    @Override
    public List<Order> getMyPublishde(int id) {
        return orderMapper.getMyPublishde(id);
    }

    @Override
    public List<Order> getMyRecived(int id) {
        return orderMapper.getMyRecived(id);
    }

    @Override
    public int reciveOrder(int userId, int orderId) {
        return orderMapper.reciveOrder(userId,orderId);
    }
}
