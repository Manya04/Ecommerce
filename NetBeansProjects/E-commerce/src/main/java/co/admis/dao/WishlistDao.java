/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.model.Wishlist;

/**
 *
 * @author manyaagarwal
 */
public interface WishlistDao {
    public Wishlist addProductToWishlist(Wishlist wishlist);
    public boolean deleteProductFromWishlist(Wishlist wishlist);
    public Wishlist updateWishlist(Wishlist wishlist);
    //public Wishlist getWishlist(Wishlist wishlist);   
}
