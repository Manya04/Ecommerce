/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.model.Customer;

/**
 *
 * @author manyaagarwal
 */
public interface CustomerDao  {
    public Customer addCustomer(Customer customer);
    public Customer getCustomerByUsername(String username);
    public Customer getCustomerByEmail(String email);
    public Customer getCustomerByEmailAndPassword( String email, String pswrd);
    public Customer updateCustomer(Customer customer);
    public boolean deleteCustomer(Customer customer);
    public Customer authenticateCustomer(Customer customer);
}
