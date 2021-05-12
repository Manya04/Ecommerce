/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.database;

import co.admis.model.Address;
import co.admis.model.Admin;
import co.admis.model.Cart;
import co.admis.model.Customer;
import co.admis.model.Order;
import co.admis.model.OrderAddress;
import co.admis.model.OrderItem;
import co.admis.model.OrderStatus;

import co.admis.model.Product;
import co.admis.model.ProductFAQ;
import co.admis.model.ProductImage;
import co.admis.model.ProductRating;
import co.admis.model.Wishlist;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author manyaagarwal
 */
public class HibernateOrderRecord {


    public static void main(String[] args) {
       //addAdmin();
        //Customer c = addCustomer();
        //addCustomerAddress(c);
       //addAdmin();
        //addProduct(addAdmin());
//        getAdminId();
        //addProduct();
        //addCustomer();
        //getCustomer();
        //addWishlist(getCustomer(), getProduct());
        //addProductFAQ(getProduct());
        //addOrder(getCustomer());
        addOrderStatus(getOrder());
        //addOrder(getCustomer());
       
    }
    
    private static Admin addAdmin()
    {
     Session session = HibernateUtil.getSessionFactory().openSession();
        Admin admin = new Admin(0, "Manya", "manya@gmail.com", "7060083270", "Manyaa", "manyaa", "Kamla Nagar",0, "Active");
        session.beginTransaction();
        session.save(admin);
        session.getTransaction().commit();
        session.close();
        return admin;
    }
    
    private static Customer addCustomer()
    {
     Session session = HibernateUtil.getSessionFactory().openSession();
        Customer customer = new Customer( 0, "ram","ram@gmail.com", "8979237106", "male","ram","ram", 0, "active");
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
        return customer;   
    }
    
    private static Address addCustomerAddress(Customer customer)
    {
     Session session = HibernateUtil.getSessionFactory().openSession();
        Address address = new Address(0, "Balaji Nagar" , "Agra" , "Uttar Pradesh", "282005", "8979237106", "ram@gmail.com",customer );
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
        session.close();
        return address;   
    }
   
    private static Customer getCustomer()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Customer> criteria =  builder.createQuery(Customer.class);
            Root<Customer> root = criteria.from(Customer.class);
            System.out.println("customer");
            criteria.where(builder.equal(root.get("idcustomer"), "1"));
            TypedQuery<Customer> typed = session.createQuery(criteria);
            Customer result = typed.getSingleResult();
            Hibernate.initialize(result);
            transaction.commit();
            session.close();
            System.out.println(result);
            return result;
        }catch(Exception e){
            System.out.println(e);
            session.close();
            return null;
        } 
        
    }
    
//    private static Product getProduct()
//    {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try{
//            Transaction transaction;
//            transaction = session.beginTransaction();
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<Product> criteria =  builder.createQuery(Product.class);
//            Root<Product> root = criteria.from(Product.class);
//            criteria.where(builder.like(exprsn, exprsn1)
//            TypedQuery<Product> typed = session.createQuery(criteria);
//            Product result = typed.getSingleResult();
//            Hibernate.initialize(result);
//            transaction.commit();
//            session.close();
//            System.out.println(result);
//            return result;
//        }catch(Exception e){
//            session.close();
//            return null;
//        } 
//        
//    }
    
    private static int getAdminId()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Admin> criteria =  builder.createQuery(Admin.class);
            Root<Admin> root = criteria.from(Admin.class);
            criteria.where(builder.equal(root.get("username"), "Manyaa"));
            TypedQuery<Admin> typed = session.createQuery(criteria);
            List<Admin> result = typed.getResultList();
            Hibernate.initialize(result);
            transaction.commit();
            session.close();
            System.out.println(result.get(0));
            return 1;
//          return result.get();
        }catch(Exception e){
            session.close();
            return 0;
        } 
        
    }
    
//    private static Product addProduct()
//    {
//     Session session = HibernateUtil.getSessionFactory().openSession();
//     Product product = new Product(0, "Wall Hanging", 350.0 , "Metal Butterfly On Leaf", "Malik Designers", 35.0 , 315.0, "xyz", "abc", 10) ;  
//     session.beginTransaction();
//        session.save(product);
//        session.getTransaction().commit();
//        session.close();
//        return product;   
//    }
    
    private static Cart addCart(Customer customer, Product product)
    {
     int customerId = customer.getIdCustomer();
     int productId = product.getIdproduct();
     String image = product.getImage();
     double price = product.getPrice();
     Session session = HibernateUtil.getSessionFactory().openSession();
     Cart cart = new Cart(0, customerId, image, 1 , price, productId);
     session.beginTransaction();
        session.save(cart);
        session.getTransaction().commit();
        session.close();
        return cart;   
    }
    
    private static Wishlist addWishlist(Customer customer, Product product)
    {
        String product_name = product.getName();
     int productId = product.getIdproduct();
     String image = product.getImage();
     double price = product.getPrice();
     Session session = HibernateUtil.getSessionFactory().openSession();
     Wishlist wishlist = new Wishlist(0, product_name, price, image, 1 , customer);
     session.beginTransaction();
        session.save(wishlist);
        session.getTransaction().commit();
        session.close();
        return wishlist;   
    }
    
    private static ProductImage addProductImage( Product product)
    {
        String product_name = product.getName();
     String image_name = product.getImage();
     String image = product.getImage();
     double price = product.getPrice();
     Session session = HibernateUtil.getSessionFactory().openSession();
     ProductImage productImage = new ProductImage(0, image_name, image , "jpeg", product);
     session.beginTransaction();
        session.save(productImage);
        session.getTransaction().commit();
        session.close();
        return productImage;   
    }
    
    private static ProductRating addProductRating( Product product)
    {
     Session session = HibernateUtil.getSessionFactory().openSession();
     ProductRating productRating = new ProductRating(0, 5, "Amazing product" , product);
     session.beginTransaction();
        session.save(productRating);
        session.getTransaction().commit();
        session.close();
        return productRating;   
    }
    
    private static ProductFAQ addProductFAQ( Product product)
    {
     Session session = HibernateUtil.getSessionFactory().openSession();
     ProductFAQ productFAQ = new ProductFAQ(0, "Is it washable?", "No, it is not." , product);
     session.beginTransaction();
        session.save(productFAQ);
        session.getTransaction().commit();
        session.close();
        return productFAQ;   
    }
    
    private static Order addOrder(Customer customer )
    {
     Session session = HibernateUtil.getSessionFactory().openSession();
     Order order = new Order(0, 12345, 350.0, 35.0, 10.0, 325, "Kamla Nagar", "Kamla Nagar", customer);
     session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
        return order;   
    }  
    
    private static Order getOrder()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Order> criteria =  builder.createQuery(Order.class);
            Root<Order> root = criteria.from(Order.class);
            criteria.where(builder.equal(root.get("orderid"), "1"));
            TypedQuery<Order> typed = session.createQuery(criteria);
            Order result = typed.getSingleResult();
            Hibernate.initialize(result);
            transaction.commit();
            session.close();
            System.out.println(result);
            return result;
        }catch(Exception e){
            session.close();
            return null;
        } 
        
    }
    private static OrderAddress addOrderAddress(Order order )
    {
     Session session = HibernateUtil.getSessionFactory().openSession();
     OrderAddress orderAddress = new OrderAddress(1, "Kamla nagar", "Agra" , "UP" , "282005" , "7060083270" , "xyz@gmail.com" , order, order.getCustomer().getIdCustomer());
     session.beginTransaction();
        session.save(orderAddress);
        session.getTransaction().commit();
        session.close();
        return orderAddress;   
    }  
    
    private static OrderItem addOrderItem(Order order )
    {
     Session session = HibernateUtil.getSessionFactory().openSession();
     OrderItem orderItem = new OrderItem(1, 350, 1 , 25 , 325 , order, order.getCustomer().getIdCustomer());
     session.beginTransaction();
        session.save(orderItem);
        session.getTransaction().commit();
        session.close();
        return orderItem;   
    }   
    
    private static OrderStatus addOrderStatus(Order order)
    {
     Session session = HibernateUtil.getSessionFactory().openSession();
     OrderStatus orderStatus = new OrderStatus(1, "delivered",  order, order.getCustomer().getIdCustomer());
     session.beginTransaction();
        session.save(orderStatus);
        session.getTransaction().commit();
        session.close();
        return orderStatus;   
    }   
    
}
        
        
    
    /*
    private static List<Log> getLogList()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Log> list = session.createCriteria(Log.class).list();
        System.out.println(list);
        return list;
        //@SuppressWarnings("unchecked")
        
    }
*/
    
    


    

