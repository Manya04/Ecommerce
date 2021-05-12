/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.dao.CustomerDao;
import co.admis.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author manyaagarwal
 */
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerDao customerDao;
    
    @Override
    public Customer addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerDao.getCustomerByUsername(username);
        }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerDao.getCustomerByEmail(email);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        return customerDao.deleteCustomer(customer);
    }

    @Override
    public Customer authenticateCustomer(Customer customer) {
        return customerDao.authenticateCustomer(customer);
    }

    @Override
    public Customer getCustomerByEmailAndPassword(String email, String pswrd) {
        return customerDao.getCustomerByEmailAndPassword(email, pswrd);
    }
}
