/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.database.HibernateUtil;
import co.admis.model.ProductImage;
import org.hibernate.Session;

/**
 *
 * @author manyaagarwal
 */
public class ProductImageDaoImpl implements ProductImageDao {

    @Override
    public ProductImage addProductImage(ProductImage productImage) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
         session.beginTransaction();
        session.save(productImage);
        session.getTransaction().commit();
        session.close();
        return productImage;   
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }
    
    
}
