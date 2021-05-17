/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.database.HibernateUtil;
import co.admis.model.Customer;
import co.admis.model.Product;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;
import java.io.InputStream;
import java.util.List;
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
public class ProductDaoImpl implements ProductDao{

    @Override
    public Product addProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
         session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
        return product;   
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public boolean deleteProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
        session.close();
        return true;
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }

    @Override
    public Product updateProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
            session.close();
            return product;
        }catch(Exception e){
            session.close();
            throw new UnsupportedOperationException("Update failed due to : "+e.getMessage());
        }
    }
    
    @Override
    public List<Product> getProductByName(String name) {
        System.out.println("Product");
        System.out.println(name);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteria =  builder.createQuery(Product.class);
            Root<Product> root = criteria.from(Product.class);
            criteria.where(builder.equal(root.get("name"), name));
            TypedQuery<Product> typed = session.createQuery(criteria);
            List<Product> result = typed.getResultList();
            Hibernate.initialize(result);
            transaction.commit();
            session.close();
            System.out.println(result + "Result");
            return result;
        }catch(Exception e){
            System.out.println(e + "exception");
            session.close();
            return null;
        }   
    }

    @Override
    public List<Product> getProductByBrand(String brand) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteria =  builder.createQuery(Product.class);
            Root<Product> root = criteria.from(Product.class);
            criteria.where(builder.equal(root.get("brand"), brand));
            TypedQuery<Product> typed = session.createQuery(criteria);
            List<Product> result = typed.getResultList();
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
    public List<Product> getProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteria =  builder.createQuery(Product.class);
            Root<Product> root = criteria.from(Product.class);
            TypedQuery<Product> typed = session.createQuery(criteria);
            List<Product> result = typed.getResultList();
            int numberOfProducts = result.size();
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
    public int getTotalProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteria =  builder.createQuery(Product.class);
            Root<Product> root = criteria.from(Product.class);
            TypedQuery<Product> typed = session.createQuery(criteria);
            List<Product> result = typed.getResultList();
            int numberOfProducts = result.size();
            Hibernate.initialize(result);
            transaction.commit();
            session.close();
            return numberOfProducts;
        }catch(Exception e){
            session.close();
            return 0;
        }   
    }
    
    @Override
    public AmazonS3 getAmazonS3Client() {
        AmazonS3 s3 = new AmazonS3Client(new BasicAWSCredentials("" , ""));
        return s3;
    }
    
    @Override
    public boolean uploadS3Object(String bucketName, String key, String data, String  fileName, String format){
        AmazonS3 s3 = getAmazonS3Client();
        File file = null;  
        
        s3.putObject(new PutObjectRequest(bucketName, key, file));
        return true;
    }
    
    @Override
    public boolean uploadS3Object(String bucketName, String key, File file){
        AmazonS3 s3 = getAmazonS3Client();
        s3.putObject(new PutObjectRequest(bucketName, key, file));
        return true;
    }
    
    @Override
    public boolean uploadS3Object(String bucketName, String key, InputStream is){
        try{
        AmazonS3 s3 = getAmazonS3Client();
        s3.putObject(new PutObjectRequest(bucketName, key, is,null));
        return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Product getProductById(int id) {
        System.out.println("Product");
        System.out.println(id);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> criteria =  builder.createQuery(Product.class);
            Root<Product> root = criteria.from(Product.class);
            criteria.where(builder.equal(root.get("idproduct"), id));
            TypedQuery<Product> typed = session.createQuery(criteria);
            Product result = typed.getSingleResult();
            Hibernate.initialize(result);
            transaction.commit();
            session.close();
            System.out.println(result + "Result");
            return result;
        }catch(Exception e){
            System.out.println(e + "exception");
            session.close();
            return null;
        }   
    }
}
