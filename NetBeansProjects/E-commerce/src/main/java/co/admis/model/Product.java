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
import javax.persistence.Table;

/**
 *
 * @author manyaagarwal
 */
@Entity
@Table(name = "\"product\"")
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduct", nullable = false, updatable = false, unique = true)
    private int idproduct;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "price", nullable = false)
    private double price;
    
    @Column(name = "description", nullable = false)
    private String description;
    
    @Column(name = "brand", nullable = false)
    private String brand;
    
    @Column(name = "discount", nullable = false)
    private double discount;
    
    @Column(name = "total")
    private double total;
    
    @Column(name = "image")
    private String image;
    
    @Column(name = "thumbnail")
    private String thumbnail;
    
    @Column(name = "quantity")
    private int quantity;
    
    @JsonManagedReference 
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<ProductImage> productImage;
    
    @JsonManagedReference 
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<ProductRating> productRating;
    
    @JsonManagedReference 
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<ProductFAQ> productFAQ;
   
//    @ManyToOne 
//    @JoinColumn(name="wishlist_customer_idcustomer", insertable=false, updatable = false)
//    @JsonBackReference
//    private Wishlist wishlist;
    /*
    @JsonManagedReference 
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Wishlist> wishlist;
    
    @JsonManagedReference 
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Cart> cart;
    
    
    
    @JsonManagedReference 
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<ProductRating> productRating;
    
    @JsonManagedReference 
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<ProductFAQ> productFAQ;
*/

    public Product() {
    }

    public Product(int idproduct, String name, double price, String description, String brand, double discount,  int quantity) {
        this.idproduct = idproduct;
        this.name = name;
        this.price = price;
        this.description = description;
        this.brand = brand;
        this.discount = discount;
        this.quantity = quantity;
        
    }

    public Product(int idproduct, String name, double price, String description, String brand, double discount, double total, String image, String thumbnail, int quantity, Set<ProductImage> productImage, Set<ProductRating> productRating, Set<ProductFAQ> productFAQ) {
        this.idproduct = idproduct;
        this.name = name;
        this.price = price;
        this.description = description;
        this.brand = brand;
        this.discount = discount;
        this.total = total;
        this.image = image;
        this.thumbnail = thumbnail;
        this.quantity = quantity;
        this.productImage = productImage;
        this.productRating = productRating;
        this.productFAQ = productFAQ;
    }

    
    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<ProductImage> getProduct_image() {
        return productImage;
    }

    public void setProduct_image(Set<ProductImage> productImage) {
        this.productImage = productImage;
    }

    public Set<ProductImage> getProductImage() {
        return productImage;
    }

    public void setProductImage(Set<ProductImage> productImage) {
        this.productImage = productImage;
    }

    public Set<ProductRating> getProductRating() {
        return productRating;
    }

    public void setProductRating(Set<ProductRating> productRating) {
        this.productRating = productRating;
    }

    public Set<ProductFAQ> getProductFAQ() {
        return productFAQ;
    }

    public void setProductFAQ(Set<ProductFAQ> productFAQ) {
        this.productFAQ = productFAQ;
    }
    @Override
    public String toString() {
        return "Product{" + "idproduct=" + idproduct + ", name=" + name + ", price=" + price + ", description=" + description + ", brand=" + brand + ", discount=" + discount + ", total=" + total + ", image=" + image + ", thumbnail=" + thumbnail + ", quantity=" + quantity + ", productImage=" + productImage + ", productRating=" + productRating + ", productFAQ=" + productFAQ + '}';
    }

    
}

