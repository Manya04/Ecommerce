/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.dao.CartDao;
import co.admis.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author manyaagarwal
 */
public class CartServiceImpl implements CartService {

    @Autowired 
    CartDao cartDao;
    
    @Override
    public Cart addProductInCart(Cart cart) {
        return cartDao.addProductInCart(cart);
    }

    @Override
    public boolean deleteProductFromCart(Cart cart) {
        return cartDao.deleteProductFromCart(cart);
    }

    @Override
    public Cart updateCart(Cart cart) {
        return cartDao.updateCart(cart);
    }

    @Override
    public Cart getCart(Cart cart) {
        return cartDao.getCart(cart);
    }
    
}
