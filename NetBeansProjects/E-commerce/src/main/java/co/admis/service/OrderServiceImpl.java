/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.dao.OrderDao;
import co.admis.model.Order;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author manyaagarwal
 */
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;
    
    @Override
    public Order addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public boolean removeOrder(Order order) {
        return orderDao.removeOrder(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public Order getOrderById(int orderId) {
        return orderDao.getOrderById(orderId);
    }
}
