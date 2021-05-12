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
import java.sql.Time;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author manyaagarwal
 */
@Entity
@Table(name = "\"cart\"")
public class Cart implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcart", nullable = false, updatable = false, unique = true)
    private int idcart;
    
    @Column(name = "customer_idcustomer", nullable = false)
    private int customer_idcustomer;
    
    @Column(name = "image", nullable = false)
    private String image;
    
    @Column(name = "quantity", nullable = false)
    private int quantity;
    
    @Column(name = "price", nullable = false)
    private double price;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;
    
    
    @Column(name = "time")
    private Time time;
    
    @Column(name = "product_idproduct", nullable = false)
    private int product_idproduct;
    
    @OneToOne
    @JoinColumn(name="customer_idcustomer", insertable=false, updatable = false)
    @JsonBackReference
    private Customer customer;

    @ManyToOne 
    @JoinColumn(name="product_idproduct", insertable=false, updatable = false)
    @JsonBackReference
    private Product product;
    
    public Cart() {
    }

    public Cart(int idcart, String image, int quantity, double price, Date date, Time time) {
        this.idcart = idcart;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.time = time;
    }

//    public Cart(int idcart, String image, int quantity, double price, Date date, Time time) {
//        this.idcart = idcart;
//        this.image = image;
//        this.quantity = quantity;
//        this.price = price;
//        this.date = date;
//        this.time = time;
//        
//    }

    public Cart(int idcart, int customer_idcustomer, String image, int quantity, double price, Date date, Time time, int product_idproduct) {
        this.idcart = idcart;
        this.customer_idcustomer = customer_idcustomer;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.time = time;
        this.product_idproduct = product_idproduct;
        
    }

    public Cart(int idcart, int customer_idcustomer, String image, int quantity, double price, int product_idproduct) {
        this.idcart = idcart;
        this.customer_idcustomer = customer_idcustomer;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.product_idproduct = product_idproduct;
        
    }
    
    public int getIdcart() {
        return idcart;
    }

    public void setIdcart(int idcart) {
        this.idcart = idcart;
    }

    public int getCustomer_idcustomer() {
        return customer_idcustomer;
    }

    public void setCustomer_idcustomer(int customer_idcustomer) {
        this.customer_idcustomer = customer_idcustomer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Cart{" + "idcart=" + idcart + ", customer_idcustomer=" + customer_idcustomer + ", image=" + image + ", quantity=" + quantity + ", price=" + price + ", date=" + date + ", time=" + time + ", customer=" + customer.getName() + '}';
    }
    
}

