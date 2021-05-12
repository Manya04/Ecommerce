/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author manyaagarwal
 */
@Entity
@Table(name = "\"customer\"")
public class Customer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcustomer", nullable = false, updatable = false, unique = true)
    private int idcustomer;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "number", unique = true)
    private String number;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "count")
    private int count;
    
    @Column(name = "status")
    private String status;
    
//    @Column(name = "admin_idadmin", nullable = false, updatable = false)
//    private int admin_idadmin;
    
    @JsonManagedReference 
    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Address> address;
    
    
    @JsonManagedReference
    @OneToOne(mappedBy="customer", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private Cart cart;
    
    @JsonManagedReference
    @OneToOne(mappedBy="customer", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private Wishlist wishlist;
    
    @JsonManagedReference 
    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Order> order;

    public Customer() {
    }

    public Customer(int idcustomer, String name, String email, String password) {
        this.idcustomer = idcustomer;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Customer(int idcustomer, String name, String email, String number, String gender, String password, String username, int count, String status)
    {
        this.name = name;
        this.email = email;
        this.number = number;
        this.gender = gender;
        this.password = password;
        this.username = username;
        this.count = count;
        this.status = status;
        
    }

    public Customer(int idcustomer, String name, String email, String number, String gender, String password, String username, int count, String status, Set<Address> address, Cart cart, Wishlist wishlist, Set<Order> order) {
        this.idcustomer = idcustomer;
        this.name = name;
        this.email = email;
        this.number = number;
        this.gender = gender;
        this.password = password;
        this.username = username;
        this.count = count;
        this.status = status;
        this.address = address;
        this.cart = cart;
        this.wishlist = wishlist;
        this.order = order;
    }
 /* public Customer(int idcustomer, String name, String email, String number, String gender, String password, String username, int count, String status, Admin admin) {
        
        this.idcustomer = idcustomer;
        this.name = name;
        this.email = email;
        this.number = number;
        this.gender = gender;
        this.password = password;
        this.username = username;
        this.count = count;
        this.status = status;
        this.admin = admin;
        
        this.address = address;
        this.billing = billing;
        this.cart = cart;
        this.wishlist = wishlist; 
    }
    */
    

    public int getIdCustomer() {
        return idcustomer;
    }

    public void setIdCustomer(int idcustomer) {
        this.idcustomer = idcustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public int getAdmin_idadmin() {
//        return admin_idadmin;
//    }
//
//    public void setAdmin_idadmin(int admin_idadmin) {
//        this.admin_idadmin = admin_idadmin;
//    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Customer{" + "idcustomer=" + idcustomer + ", name=" + name + ", email=" + email + ", number=" + number + ", gender=" + gender + ", password=" + password + ", username=" + username + ", count=" + count + ", status=" + status + ", address=" + address + ", cart=" + cart + ", wishlist=" + wishlist + ", order=" + order + '}';
    }

    
    
}
