/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.model.Customer;

/**
 *
 * public Admin addAdmin(Admin admin);
    public Admin getAdminByUsername( String username);
    public Admin updateAdmin(Admin admin);
    public boolean deleteAdmin(Admin admin);
    public Admin authenticateAdmin(Admin admin);
 * @author manyaagarwal
 */
public interface CustomerService  {
    public Customer addCustomer(Customer customer);
    public Customer getCustomerByUsername(String username);
    public Customer getCustomerByEmail(String email);
    public Customer getCustomerByEmailAndPassword( String email, String pswrd);
    public Customer updateCustomer(Customer customer);
    public boolean deleteCustomer(Customer customer);
    public Customer authenticateCustomer(Customer customer);
}
