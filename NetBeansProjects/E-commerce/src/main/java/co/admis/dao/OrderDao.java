/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.model.Order;

/**
 *
 * @author manyaagarwal
 */
public interface OrderDao {
    public Order addOrder(Order order);
    public boolean removeOrder(Order order);
    public Order updateOrder(Order order);
    public Order getOrderById(int orderId);
}
