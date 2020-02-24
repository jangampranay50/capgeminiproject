package com.cg.go.service;

import java.util.List;

import com.cg.go.bean.Cart;
import com.cg.go.exception.CartException;

public interface CartService 
{
	public boolean validateId(int productId);
	public boolean validateName(String productName);
	public boolean validatePrice(double price);
	public int addProductToCart(Cart cart) throws CartException;
	public Cart deleteProductByIdInCart(int productId) throws CartException;
	public List<Cart> findAllProductsInCart() throws CartException;
}
