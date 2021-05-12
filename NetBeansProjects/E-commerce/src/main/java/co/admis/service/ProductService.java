/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.model.Product;
import com.amazonaws.services.s3.AmazonS3;
import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author manyaagarwal
 */
public interface ProductService {
    public Product addProduct(Product product);
    public boolean deleteProduct(Product product);
    public Product updateProduct(Product product);
    public List<Product> getProductByName(String name);
    public Product getProductById(int id);
    public List<Product> getProductByBrand(String brand);
    public AmazonS3 getAmazonS3Client();
    public boolean uploadS3Object(String bucketName, String key, String data, String  fileName, String format);
    public boolean uploadS3Object(String bucketName, String key, File file);
    public boolean uploadS3Object(String bucketName, String key, InputStream is);
public List<Product> getProducts();
public int getTotalProducts();
}
