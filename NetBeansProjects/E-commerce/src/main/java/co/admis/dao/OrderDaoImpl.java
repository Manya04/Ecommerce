/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.database.HibernateUtil;
import co.admis.model.Order;
import co.admis.model.Product;
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
public class OrderDaoImpl implements OrderDao {

    @Override
    public Order addOrder(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
         session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
        return order;   
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public boolean removeOrder(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
         session.beginTransaction();
        session.delete(order);
        session.getTransaction().commit();
        session.close();
        return true;   
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public Order updateOrder(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(order);
            session.getTransaction().commit();
            session.close();
            return order;
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public Order getOrderById(int orderId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Order> criteria =  builder.createQuery(Order.class);
            Root<Order> root = criteria.from(Order.class);
            criteria.where(builder.equal(root.get("orderid"), orderId));
            TypedQuery<Order> typed = session.createQuery(criteria);
            Order result = typed.getSingleResult();
            Hibernate.initialize(result);
            transaction.commit();
            session.close();
            return result;
        }catch(Exception e){
            session.close();
            return null;
        }   
    }
    
}
