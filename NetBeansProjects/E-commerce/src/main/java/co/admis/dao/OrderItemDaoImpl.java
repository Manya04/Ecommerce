/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.database.HibernateUtil;
import co.admis.model.OrderAddress;
import co.admis.model.OrderItem;
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
public class OrderItemDaoImpl implements OrderItemDao {

    @Override
    public OrderItem addOrderItem(OrderItem orderItem) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
         session.beginTransaction();
        session.save(orderItem);
        session.getTransaction().commit();
        session.close();
        return orderItem;   
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public boolean deleteOrderItem(OrderItem orderItem) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
        session.beginTransaction();
        session.delete(orderItem);
        session.getTransaction().commit();
        session.close();
        return true;
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
         session.beginTransaction();
        session.update(orderItem);
        session.getTransaction().commit();
        session.close();
        return orderItem;   
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public OrderItem getOrderItemById(int idorderItem) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<OrderItem> criteria =  builder.createQuery(OrderItem.class);
            Root<OrderItem> root = criteria.from(OrderItem.class);
            criteria.where(builder.equal(root.get("idorderItem"), idorderItem));
            TypedQuery<OrderItem> typed = session.createQuery(criteria);
            OrderItem result = typed.getSingleResult();
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
