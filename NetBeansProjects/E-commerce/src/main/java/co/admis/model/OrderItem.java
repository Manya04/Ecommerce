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
@Table(name = "\"orderItem\"")
public class OrderItem implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorderItem", nullable = false, updatable = false, unique = true)
    private int idorderItem;
    
    @Column(name = "price", nullable = false)
    private double price;
    
    @Column(name = "quantity", nullable = false)
    private int quantity;
    
    @Column(name = "discount", nullable = false)
    private double discount;
    
    @Column(name = "total", nullable = false)
    private double total;
    
    @ManyToOne 
    @JoinColumn(name="order_orderid", nullable=false, updatable = false)
    @JsonBackReference
    private Order order;
    
    @Column(name = "order_customer_idcustomer", nullable = false)
    private int orderCustomerIdCustomer;

    public OrderItem() {
    }

    public OrderItem(int idorderItem, double price, int quantity, double discount, double total, Order order, int orderCustomerIdCustomer) {
        this.idorderItem = idorderItem;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.total = total;
        this.order = order;
        this.orderCustomerIdCustomer = orderCustomerIdCustomer;
    }

    public int getIdorderItem() {
        return idorderItem;
    }

    public void setIdorderItem(int idorderItem) {
        this.idorderItem = idorderItem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        return "OrderItem{" + "idorderItem=" + idorderItem + ", price=" + price + ", quantity=" + quantity + ", discount=" + discount + ", total=" + total + ", order=" + order.getOrderid() + ", orderCustomerIdCustomer=" + orderCustomerIdCustomer + '}';
    }
    
}
