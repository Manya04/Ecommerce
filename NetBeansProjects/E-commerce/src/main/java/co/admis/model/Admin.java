/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author Adeep My IT Solution Private Limited
 */
@Entity
@Table(name = "\"admin\"")
public class Admin implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idadmin", nullable = false, updatable = false, unique = true)
    private int idadmin;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "number", nullable = false, unique = true)
    private String number;
    
    @Column(name = "username", nullable = false)
    private String username;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "address", nullable = false)
    private String address;
    
    @Column(name = "count")
    private int count;
    
    @Column(name = "status")
    private String status;
    
//    @JsonManagedReference 
//    @OneToMany(mappedBy="admin", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//    private Set<Product> product;
    
    public Admin() {
    }

    public Admin(int idadmin, String name, String email, String number, String username, String password, String address, int count, String status) {
        this.idadmin = idadmin;
        this.name = name;
        this.email = email;
        this.number = number;
        this.username = username;
        this.password = password;
        this.address = address;
        this.count = count;
        this.status = status;
    }
    

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Admin{" + "idadmin=" + idadmin + ", name=" + name + ", email=" + email + ", number=" + number + ", username=" + username + ", password=" + password + ", address=" + address + ", count=" + count + ", status=" + status + '}';
    }

    
    
}
