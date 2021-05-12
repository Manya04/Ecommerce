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
@Table(name = "\"product_FAQ\"")
public class ProductFAQ implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduct_FAQ", nullable = false, updatable = false, unique = true)
    private int idproduct_FAQ;
    
    @Column(name = "question", nullable = false)
    private String question;   
    
    @Column(name = "asnwwer", nullable = false)
    private String asnwwer;
    
    @ManyToOne 
    @JoinColumn(name="product_idproduct", nullable=false, updatable = false)
    @JsonBackReference
    private Product product;

    public ProductFAQ() {
    }

    public ProductFAQ(int idproduct_FAQ, String question, String asnwwer, Product product) {
        this.idproduct_FAQ = idproduct_FAQ;
        this.question = question;
        this.asnwwer = asnwwer;
        this.product = product;
    }

    public int getIdproduct_FAQ() {
        return idproduct_FAQ;
    }

    public void setIdproduct_FAQ(int idproduct_FAQ) {
        this.idproduct_FAQ = idproduct_FAQ;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAsnwwer() {
        return asnwwer;
    }

    public void setAsnwwer(String asnwwer) {
        this.asnwwer = asnwwer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductFAQ{" + "idproduct_FAQ=" + idproduct_FAQ + ", question=" + question + ", asnwwer=" + asnwwer + ", product=" + product.getName() + '}';
    }

  
   
}
