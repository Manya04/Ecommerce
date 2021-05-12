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
@Table(name = "\"order\"")
public class Order implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid", nullable = false, updatable = false, unique = true)
    private int orderid;
    
    @Column(name = "invoice_no", nullable = false)
    private int invoice_no;
    
    @Column(name = "orderDate")
    private Date orderDate;
    
    @Column(name = "amount", nullable = false)
    private double amount;
    
    @Column(name = "discount", nullable = false)
    private double discount;
    
    @Column(name = "tax", nullable = false)
    private double tax;
    
    @Column(name = "netAmount", nullable = false)
    private double netAmount;
    
    @Column(name = "shippingDate")
    private Date shippingDate;
    
    @Column(name = "shippingAddress", nullable = false)
    private String shippingAddress;
    
    @Column(name = "billingAddress", nullable = false)
    private String billingAddress;
    
    @ManyToOne 
    @JoinColumn(name="customer_idcustomer", nullable=false, updatable = false)
    @JsonBackReference
    private Customer customer;
    
    @JsonManagedReference
    @OneToOne(mappedBy="order", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private OrderAddress orderAddress;
    
    @JsonManagedReference
    @OneToOne(mappedBy="order", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private OrderItem orderItem;
    
    @JsonManagedReference
    @OneToOne(mappedBy="order", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private OrderStatus orderStatus;
    public Order() {
    }

    public Order(int orderid, int invoice_no, double amount, double discount, double tax, double netAmount, String shippingAddress, String billingAddress, Customer customer) {
        this.orderid = orderid;
        this.invoice_no = invoice_no;
        this.amount = amount;
        this.discount = discount;
        this.tax = tax;
        this.netAmount = netAmount;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.customer = customer;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }


    public int getInvoice_no() {
        return invoice_no;
    }

    public void setInvoice_no(int invoice_no) {
        this.invoice_no = invoice_no;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" + "orderid=" + orderid + ", invoice_no=" + invoice_no + ", orderDate=" + orderDate + ", amount=" + amount + ", discount=" + discount + ", tax=" + tax + ", netAmount=" + netAmount + ", shippingDate=" + shippingDate + ", shippingAddress=" + shippingAddress + ", billingAddress=" + billingAddress + ", customer=" + customer.getName() + ", orderAddress=" + orderAddress + ", orderItem=" + orderItem + ", orderStatus=" + orderStatus + '}';
    }


}
