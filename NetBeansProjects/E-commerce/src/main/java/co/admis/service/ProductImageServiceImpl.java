/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;


import co.admis.dao.ProductImageDao;
import co.admis.model.ProductImage;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author manyaagarwal
 */
public class ProductImageServiceImpl implements ProductImageService {
   
    @Autowired 
    ProductImageDao productImageDao;

    @Override
    public ProductImage addProductImage(ProductImage productImage) {
        return productImageDao.addProductImage(productImage);
    }
}
