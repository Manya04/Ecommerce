/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.dao.OrderItemDao;
import co.admis.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author manyaagarwal
 */
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    OrderItemDao orderItemDao;
    
    @Override
    public OrderItem addOrderItem(OrderItem orderItem) {
        return orderItemDao.addOrderItem(orderItem);
    }

    @Override
    public boolean deleteOrderItem(OrderItem orderItem) {
        return orderItemDao.deleteOrderItem(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        return orderItemDao.updateOrderItem(orderItem);
    }

    @Override
    public OrderItem getOrderItemById(int idorderItem) {
        return orderItemDao.getOrderItemById(idorderItem);
    }
    
}
