/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author manyaagarwal
 */
@Entity
@Table(name = "\"wishlist\"")
public class Wishlist implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idwishlist", nullable = false, updatable = false, unique = true)
    private int idwishlist;
    
    @Column(name = "product_name", nullable = false)
    private String product_name;
    
    @Column(name = "insertDate")
    private Date insertDate;
    
    @Column(name = "price", nullable = false)
    private double price;
    
    @Column(name = "image", nullable = false)
    private String image;
    
    @Column(name = "quantity", nullable = false)
    private int quantity;
    
    @OneToOne
    @JoinColumn(name="customer_idcustomer", nullable=false, updatable = false)
    @JsonBackReference
    private Customer customer;

    public Wishlist() {
    }

    public Wishlist(int idwishlist, String product_name, double price, String image, int quantity, Customer customer) {
        this.idwishlist = idwishlist;
        this.product_name = product_name;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.customer = customer;
    }

    public int getIdwishlist() {
        return idwishlist;
    }

    public void setIdwishlist(int idwishlist) {
        this.idwishlist = idwishlist;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Wishlist{" + "idwishlist=" + idwishlist + ", product_name=" + product_name + ", insertDate=" + insertDate + ", price=" + price + ", image=" + image + ", quantity=" + quantity + ", customer=" + customer.getName() + '}';
    }
   
}
