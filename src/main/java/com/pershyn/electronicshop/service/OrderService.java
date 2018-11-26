package com.pershyn.electronicshop.service;


import com.pershyn.electronicshop.model.Order;

import java.util.Set;

public interface OrderService {

    public void addOrder(Order order);

    public void updateOrder(Order order);

    public Order getOrderById(Integer id);

    public Set<Order> getAllOrders();
}
