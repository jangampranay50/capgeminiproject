package com.cg.go.dao;

import java.util.List;

import com.cg.go.bean.Cart;
import com.cg.go.exception.CartException;

public interface CartDao 
{
	public int addProductToCart(Cart cart) throws CartException;
	public Cart deleteProductByIdInCart(int productId) throws CartException;
	public List<Cart> findAllProductsInCart() throws CartException;
}
