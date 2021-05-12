/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.model;

/**
 *
 * @author manyaagarwal
 */
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "\"orderAddress\"")
public class OrderAddress implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorderAddress", nullable = false, updatable = false, unique = true)
    private int idorderAddress;
    
    @Column(name = "address", nullable = false)
    private String address;
    
    @Column(name = "city", nullable = false)
    private String city;
    
    @Column(name = "state", nullable = false)
    private String state;
    
    @Column(name = "postal_code", nullable = false)
    private String postal_code;
    
    @Column(name = "number", nullable = false)
    private String number;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    
    @ManyToOne 
    @JoinColumn(name="order_orderid", nullable=false, updatable = false)
    @JsonBackReference
    private Order order;
    
    @Column(name = "order_customer_idcustomer", nullable = false)
    private int orderCustomerIdCustomer;
    
    
//    @JsonManagedReference
//    @OneToOne(mappedBy="order", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
//    private OrderItem orderItem;
    
    public OrderAddress() {
    }

    public OrderAddress(int idorderAddress, String address, String city, String state, String postal_code, String number, String email, Order order, int orderCustomerIdCustomer) {
        this.idorderAddress = idorderAddress;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.number = number;
        this.email = email;
        this.order = order;
        this.orderCustomerIdCustomer = orderCustomerIdCustomer;
    }

    

    public int getIdorderAddress() {
        return idorderAddress;
    }

    public void setIdorderAddress(int idorderAddress) {
        this.idorderAddress = idorderAddress;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getOrderCustomerIdCustomer() {
        return orderCustomerIdCustomer;
    }

    public void setOrderCustomerIdCustomer(int orderCustomerIdCustomer) {
        this.orderCustomerIdCustomer = orderCustomerIdCustomer;
    }

    @Override
    public String toString() {
        return "OrderAddress{" + "idorderAddress=" + idorderAddress + ", address=" + address + ", city=" + city + ", state=" + state + ", postal_code=" + postal_code + ", number=" + number + ", email=" + email + ", order=" + order.getOrderid() + ", orderCustomerIdCustomer=" + orderCustomerIdCustomer + '}';
    }

    
}
