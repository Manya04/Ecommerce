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
@Table(name = "\"product_rating\"")
public class ProductRating implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduct_rating", nullable = false, updatable = false, unique = true)
    private int idproduct_rating;
    
    @Column(name = "star_rating", nullable = false)
    private int star_rating;   
    
    @Column(name = "review", nullable = false)
    private String review;
    
    @ManyToOne 
    @JoinColumn(name="product_idproduct", nullable=false, updatable = false)
    @JsonBackReference
    private Product product;

    public ProductRating() {
    }

    public ProductRating(int idproduct_rating, int star_rating, String review, Product product) {
        this.idproduct_rating = idproduct_rating;
        this.star_rating = star_rating;
        this.review = review;
        this.product = product;
    }

    public int getIdproduct_rating() {
        return idproduct_rating;
    }

    public void setIdproduct_rating(int idproduct_rating) {
        this.idproduct_rating = idproduct_rating;
    }

    public int getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(int star_rating) {
        this.star_rating = star_rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductRating{" + "idproduct_rating=" + idproduct_rating + ", star_rating=" + star_rating + ", review=" + review + ", product=" + product.getName() + '}';
    }
    
}
