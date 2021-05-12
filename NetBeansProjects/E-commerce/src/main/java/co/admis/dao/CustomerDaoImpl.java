/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.database.HibernateUtil;
import co.admis.model.Admin;
import co.admis.model.Customer;
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
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public Customer addCustomer(Customer customer) {
        System.out.println("Test Start");
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
        return customer;   
        }catch(Exception e){
            System.out.println(e);
            System.out.println("tree");
            System.out.println(e.fillInStackTrace());
            session.close();
            throw new UnsupportedOperationException("Email already reg.");
            
//            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
//            return null;
        }
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Customer> criteria =  builder.createQuery(Customer.class);
            Root<Customer> root = criteria.from(Customer.class);
            criteria.where(builder.equal(root.get("username"), username));
            TypedQuery<Customer> typed = session.createQuery(criteria);
            Customer result = typed.getSingleResult();
            Hibernate.initialize(result);
            transaction.commit();
            session.close();
            return result;
        }catch(Exception e){
            session.close();
            return null;
        }   
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Customer> criteria =  builder.createQuery(Customer.class);
            Root<Customer> root = criteria.from(Customer.class);
            criteria.where(builder.equal(root.get("email"), email));
            TypedQuery<Customer> typed = session.createQuery(criteria);
            Customer result = typed.getSingleResult();
            Hibernate.initialize(result);
            transaction.commit();
            session.close();
            return result;
        }catch(Exception e){
            session.close();
            return null;
        }   
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(customer);
            session.getTransaction().commit();
            session.close();
            return customer;
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
        return true;
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public Customer authenticateCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Customer> criteria =  builder.createQuery(Customer.class);
            Root<Customer> root = criteria.from(Customer.class);
            criteria.where(builder.and(builder.equal(root.get("username"), customer.getUsername() ),builder.equal(root.get("password"), customer.getPassword())));
            TypedQuery<Customer> typed = session.createQuery(criteria);
            Customer result = typed.getSingleResult();
            Hibernate.initialize(result);
            transaction.commit();
            session.close();
            System.out.println("result: "+result);
            return result;
        }catch(Exception e){
            System.out.println(e);
            session.close();
            return null;
        } 
    }

    @Override
    public Customer getCustomerByEmailAndPassword(String email, String pswrd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Customer> criteria =  builder.createQuery(Customer.class);
            Root<Customer> root = criteria.from(Customer.class);
            criteria.where(builder.and(builder.equal(root.get("email"), email ),builder.equal(root.get("password"), pswrd)));
            TypedQuery<Customer> typed = session.createQuery(criteria);
            Customer result = typed.getSingleResult();
            Hibernate.initialize(result);
            transaction.commit();
            session.close();
            System.out.println("result: "+result);
            return result;
        }catch(Exception e){
            System.out.println(e);
            session.close();
            return null;
        } 
    }
}
