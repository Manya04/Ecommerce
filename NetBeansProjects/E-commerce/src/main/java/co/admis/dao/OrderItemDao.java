/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.model.OrderItem;

/**
 *
 * @author manyaagarwal
 */
public interface OrderItemDao {
    public OrderItem addOrderItem(OrderItem orderItem);
    public boolean deleteOrderItem(OrderItem orderItem);
    public OrderItem updateOrderItem(OrderItem orderItem);
    public OrderItem getOrderItemById(int idorderItem);
}
