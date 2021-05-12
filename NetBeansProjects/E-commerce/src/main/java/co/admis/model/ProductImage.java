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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author manyaagarwal
 */
@Entity
@Table(name = "\"product_image\"")
public class ProductImage implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduct_image", nullable = false, updatable = false, unique = true)
    private int idproduct_image;
    
    @Column(name = "image_name", nullable = false)
    private String image_name;   
    
    @Column(name = "image_url", nullable = false)
    private String image_url;
    
    @Column(name = "image_type", nullable = false)
    private String image_type;
    
    @ManyToOne 
    @JoinColumn(name="product_idproduct", nullable=false, updatable = false)
    @JsonBackReference
    private Product product;

    public ProductImage() {
    }

    public ProductImage(int idproduct_image, String image_name, String image_url, String image_type, Product product) {
        this.idproduct_image = idproduct_image;
        this.image_name = image_name;
        this.image_url = image_url;
        this.image_type = image_type;
        this.product = product;
    }


    public int getIdproduct_image() {
        return idproduct_image;
    }

    public void setIdproduct_image(int idproduct_image) {
        this.idproduct_image = idproduct_image;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getImage_type() {
        return image_type;
    }

    public void setImage_type(String image_type) {
        this.image_type = image_type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductImage{" + "idproduct_image=" + idproduct_image + ", image_name=" + image_name + ", image_url=" + image_url + ", image_type=" + image_type + ", product=" + product.getName() + '}';
    }
    
    
    
}
