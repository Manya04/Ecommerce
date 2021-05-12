/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.database.HibernateUtil;
import co.admis.model.Customer;
import co.admis.model.OrderAddress;
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
public class OrderAddressDaoImpl implements OrderAddressDao {

    @Override
    public OrderAddress addOrderAddress(OrderAddress orderAddress) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
         session.beginTransaction();
        session.save(orderAddress);
        session.getTransaction().commit();
        session.close();
        return orderAddress;   
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public boolean removeOrderAddress(OrderAddress orderAddress) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
        session.beginTransaction();
        session.delete(orderAddress);
        session.getTransaction().commit();
        session.close();
        return true;
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public OrderAddress updateOrderAddress(OrderAddress orderAddress) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
         session.beginTransaction();
        session.update(orderAddress);
        session.getTransaction().commit();
        session.close();
        return orderAddress;   
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public OrderAddress getOrderAddressById(int idorderAddress) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<OrderAddress> criteria =  builder.createQuery(OrderAddress.class);
            Root<OrderAddress> root = criteria.from(OrderAddress.class);
            criteria.where(builder.equal(root.get("idorderAddress"), idorderAddress));
            TypedQuery<OrderAddress> typed = session.createQuery(criteria);
            OrderAddress result = typed.getSingleResult();
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
