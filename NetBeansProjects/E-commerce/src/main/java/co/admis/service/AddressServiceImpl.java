/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.dao.AddressDao;
import co.admis.model.Address;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author manyaagarwal
 */
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDao addressDao;
    
    @Override
    public Address addAddress(Address address) {
        return addressDao.addAddress(address);
    }

    @Override
    public boolean deleteAddress(Address address) {
        return addressDao.deleteAddress(address);
    }

    @Override
    public Address updateAddress(Address address) {
        return addressDao.updateAddress(address);
    }
    
}
