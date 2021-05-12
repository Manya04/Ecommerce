/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.database.HibernateUtil;

import co.admis.model.OrderStatus;
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
public class OrderStatusDaoImpl implements OrderStatusDao{

    @Override
    public OrderStatus addOrderStatus(OrderStatus orderStatus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
         session.beginTransaction();
        session.save(orderStatus);
        session.getTransaction().commit();
        session.close();
        return orderStatus;   
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public boolean deleteOrderStatus(OrderStatus orderStatus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
         session.beginTransaction();
        session.delete(orderStatus);
        session.getTransaction().commit();
        session.close();
        return true;   
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public OrderStatus updateOrderStatus(OrderStatus orderStatus) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        try{
         session.beginTransaction();
        session.update(orderStatus);
        session.getTransaction().commit();
        session.close();
        return orderStatus;   
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public OrderStatus getOrderStatusById(int idorderStatus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<OrderStatus> criteria =  builder.createQuery(OrderStatus.class);
            Root<OrderStatus> root = criteria.from(OrderStatus.class);
            criteria.where(builder.equal(root.get("idorderStatus"), idorderStatus));
            TypedQuery<OrderStatus> typed = session.createQuery(criteria);
            OrderStatus result = typed.getSingleResult();
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
