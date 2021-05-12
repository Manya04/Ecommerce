/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.dao.ProductDao;
import co.admis.model.Product;
import com.amazonaws.services.s3.AmazonS3;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author manyaagarwal
 */
public class ProductServiceImpl implements ProductService {

    @Autowired 
    ProductDao productDao;
    
    @Override
    public Product addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public boolean deleteProduct(Product product) {
        return productDao.deleteProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productDao.getProductByName(name);
    }

    @Override
    public List<Product> getProductByBrand(String brand) {
        return productDao.getProductByBrand(brand);
    }

    @Override
    public AmazonS3 getAmazonS3Client() {
        return productDao.getAmazonS3Client();
    }

    @Override
    public boolean uploadS3Object(String bucketName, String key, String data, String fileName, String format) {
        return productDao.uploadS3Object(bucketName, key, data, fileName, format);
    }

    @Override
    public boolean uploadS3Object(String bucketName, String key, File file) {
        return productDao.uploadS3Object(bucketName, key, file);
    }
    
    @Override
    public boolean uploadS3Object(String bucketName, String key, InputStream is) {
        return productDao.uploadS3Object(bucketName, key, is);
    }

    @Override
    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    public int getTotalProducts() {
        return productDao.getTotalProducts();
    }
}
