/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.database.HibernateUtil;
import co.admis.model.Address;
import org.hibernate.Session;

/**
 *
 * @author manyaagarwal
 */
public class AddressDaoImpl implements AddressDao {

    @Override
    public Address addAddress(Address address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
         session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
        session.close();
        return address;   
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public boolean deleteAddress(Address address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
        session.beginTransaction();
        session.delete(address);
        session.getTransaction().commit();
        session.close();
        return true;
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public Address updateAddress(Address address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(address);
            session.getTransaction().commit();
            session.close();
            return address;
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }
    
}
