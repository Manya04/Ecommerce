/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.model.OrderStatus;

/**
 *
 * @author manyaagarwal
 */
public interface OrderStatusService {
 public OrderStatus addOrderStatus(OrderStatus orderStatus);
 public boolean deleteOrderStatus(OrderStatus orderStatus);
 public OrderStatus updateOrderStatus(OrderStatus orderStatus);
 public OrderStatus getOrderStatusById(int idorderStatus);
}
