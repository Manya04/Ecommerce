/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.dao.WishlistDao;
import co.admis.model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author manyaagarwal
 */
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    WishlistDao wishlistDao;
    
    @Override
    public Wishlist addProductToWishlist(Wishlist wishlist) {
        return wishlistDao.addProductToWishlist(wishlist);
    }

    @Override
    public boolean deleteProductFromWishlist(Wishlist wishlist) {
        return wishlistDao.deleteProductFromWishlist(wishlist);
    }

    @Override
    public Wishlist updateWishlist(Wishlist wishlist) {
        return wishlistDao.updateWishlist(wishlist);
    }

    
    
}
