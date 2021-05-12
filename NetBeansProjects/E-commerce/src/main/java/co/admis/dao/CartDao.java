/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.model.Cart;

/**
 *
 * @author manyaagarwal
 */
public interface CartDao {
    public Cart addProductInCart(Cart cart);
    public boolean deleteProductFromCart(Cart cart);
    public Cart updateCart(Cart cart);
    public Cart getCart(Cart cart);
}
