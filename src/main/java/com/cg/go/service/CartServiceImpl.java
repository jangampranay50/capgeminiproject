package com.cg.go.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.cg.go.bean.Cart;
import com.cg.go.dao.CartDao;
import com.cg.go.dao.CartDaoMapImpl;
import com.cg.go.exception.CartException;

public class CartServiceImpl implements CartService
{
	private CartDao cartDao;
	
	public CartServiceImpl()
	{
		cartDao = new CartDaoMapImpl();
	}
	public boolean validateId(int productId)
	{
		boolean flag = false;
		String s = Integer.toString(productId);
		flag = s.matches("[0-9]{4}");
		return flag;
	}
	@Override
	public int addProductToCart(Cart cart) throws CartException {
		
		int id = cart.getProductId();
		boolean  flag = validateId(id);
		if(flag==false) {
			throw new CartException("Product Id should be 4 digits");
		}
		id=cartDao.addProductToCart(cart);
		return id;
	}

	@Override
	public Cart deleteProductByIdInCart(int productId) throws CartException {
		return cartDao.deleteProductByIdInCart(productId);
	}

	@Override
	public List<Cart> findAllProductsInCart() throws CartException {
		return cartDao.findAllProductsInCart();
	}

	
}
