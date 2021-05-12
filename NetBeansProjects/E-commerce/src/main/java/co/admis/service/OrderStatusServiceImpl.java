/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.dao.OrderStatusDao;
import co.admis.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author manyaagarwal
 */
public class OrderStatusServiceImpl implements OrderStatusService {

    @Autowired
    OrderStatusDao orderStatusDao;
    
    @Override
    public OrderStatus addOrderStatus(OrderStatus orderStatus) {
        return orderStatusDao.addOrderStatus(orderStatus);
    }

    @Override
    public boolean deleteOrderStatus(OrderStatus orderStatus) {
        return orderStatusDao.deleteOrderStatus(orderStatus);
    }

    @Override
    public OrderStatus updateOrderStatus(OrderStatus orderStatus) {
        return orderStatusDao.updateOrderStatus(orderStatus);
    }

    @Override
    public OrderStatus getOrderStatusById(int idorderStatus) {
        return orderStatusDao.getOrderStatusById(idorderStatus);
    }
    
}
