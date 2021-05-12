/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
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
@Table(name = "\"orderStatus\"")
public class OrderStatus implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorderStatus", nullable = false, updatable = false, unique = true)
    private int idorderStatus;
    
    @Column(name = "status", nullable = false)
    private String status;
    
    @Column(name = "time")
    private Time time;
    
    @Column(name = "date")
    private Date date;
    
    @ManyToOne 
    @JoinColumn(name="order_orderid", nullable=false, updatable = false)
    @JsonBackReference
    private Order order;
    
    @Column(name = "order_customer_idcustomer", nullable = false)
    private int orderCustomerIdCustomer;

    public OrderStatus() {
    }

    public OrderStatus(int idorderStatus, String status, Order order, int orderCustomerIdCustomer) {
        this.idorderStatus = idorderStatus;
        this.status = status;
        this.order = order;
        this.orderCustomerIdCustomer = orderCustomerIdCustomer;
    }

    public int getIdorderStatus() {
        return idorderStatus;
    }

    public void setIdorderStatus(int idorderStatus) {
        this.idorderStatus = idorderStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        return "OrderStatus{" + "idorderStatus=" + idorderStatus + ", status=" + status + ", time=" + time + ", date=" + date + ", order=" + order.getOrderid() + ", orderCustomerIdCustomer=" + orderCustomerIdCustomer + '}';
    }
    
}
