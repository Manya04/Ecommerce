/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.model.Address;

/**
 *
 * @author manyaagarwal
 */
public interface AddressService {
    public Address addAddress(Address address);
    public boolean deleteAddress(Address address);
    public Address updateAddress(Address address);
    //public Address getAddress();
}
