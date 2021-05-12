/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.database.HibernateUtil;
import co.admis.model.Admin;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author manyaagarwal
 */
public class AdminDaoImpl implements AdminDao {

    @Override
    public Admin addAdmin(Admin admin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
         session.beginTransaction();
        session.save(admin);
        session.getTransaction().commit();
        session.close();
        return admin;   
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
        
    }

    @Override
    public Admin getAdminByUsername(String username) {
     Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Admin> criteria =  builder.createQuery(Admin.class);
            Root<Admin> root = criteria.from(Admin.class);
            criteria.where(builder.equal(root.get("username"), username));
            TypedQuery<Admin> typed = session.createQuery(criteria);
            Admin result = typed.getSingleResult();
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
    public Admin updateAdmin(Admin admin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(admin);
            session.getTransaction().commit();
            session.close();
            return admin;
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
        
    }

    @Override
    public boolean deleteAdmin(Admin admin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
        session.beginTransaction();
        session.delete(admin);
        session.getTransaction().commit();
        session.close();
        return true;
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public Admin authenticateAdmin(Admin admin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Admin> criteria =  builder.createQuery(Admin.class);
            Root<Admin> root = criteria.from(Admin.class);
            criteria.where(builder.and(builder.equal(root.get("username"), admin.getUsername() ),builder.equal(root.get("password"), admin.getPassword())));
            TypedQuery<Admin> typed = session.createQuery(criteria);
            Admin result = typed.getSingleResult();
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
