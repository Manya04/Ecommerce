/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.model.OrderAddress;

/**
 *
 * @author manyaagarwal
 */
public interface OrderAddressService {
    public OrderAddress addOrderAddress(OrderAddress orderAddress);
    public boolean removeOrderAddress(OrderAddress orderAddress);
    public OrderAddress updateOrderAddress(OrderAddress orderAddress);
    public OrderAddress getOrderAddressById(int idorderAddress);
}
