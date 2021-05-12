/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author manyaagarwal
 */
@Entity
@Table(name = "\"address\"")
public class Address implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idaddress", nullable = false, updatable = false, unique = true)
    private int idaddress;
    
    @Column(name = "address", nullable = false)
    private String address;
    
    @Column(name = "city", nullable = false)
    private String city;
    
    @Column(name = "state", nullable = false, unique = true)
    private String state;
    
    @Column(name = "postal_code", nullable = false, unique = true)
    private String postal_code;
    
    @Column(name = "number", nullable = false)
    private String number;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @ManyToOne 
    @JoinColumn(name="customer_idcustomer", nullable=false, updatable = false)
    @JsonBackReference
    private Customer customer;
    
//    @ManyToOne 
//    @JoinColumn(name="order_OrderId", nullable=false, updatable = false)
//    @JsonBackReference
//    private Order orders

    public Address() {
    }

    public Address(int idaddress, String address, String city, String state, String postal_code, String number, String email, Customer customer) {
        this.idaddress = idaddress;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.number = number;
        this.email = email;
        this.customer = customer;
        
    }

    public int getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(int idaddress) {
        this.idaddress = idaddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
    @Override
    public String toString() {
        return "Address{" + "idaddress=" + idaddress + ", address=" + address + ", city=" + city + ", state=" + state + ", postal_code=" + postal_code + ", number=" + number + ", email=" + email + ", customer=" + customer.getIdCustomer() + '}';
    }
//
//   
//    
//    
}
