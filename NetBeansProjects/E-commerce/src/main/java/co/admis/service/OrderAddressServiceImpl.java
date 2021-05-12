/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.dao.OrderAddressDao;
import co.admis.model.OrderAddress;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author manyaagarwal
 */
public class OrderAddressServiceImpl implements OrderAddressService {

    @Autowired
    OrderAddressDao orderAddressDao;
    
    @Override
    public OrderAddress addOrderAddress(OrderAddress orderAddress) {
        return orderAddressDao.addOrderAddress(orderAddress);
    }

    @Override
    public boolean removeOrderAddress(OrderAddress orderAddress) {
        return orderAddressDao.removeOrderAddress(orderAddress);
    }

    @Override
    public OrderAddress updateOrderAddress(OrderAddress orderAddress) {
        return orderAddressDao.updateOrderAddress(orderAddress);
    }

    @Override
    public OrderAddress getOrderAddressById(int idorderAddress) {
        return orderAddressDao.getOrderAddressById(idorderAddress);
    }
    
}
