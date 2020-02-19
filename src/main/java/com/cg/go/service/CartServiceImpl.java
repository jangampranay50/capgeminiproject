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

	@Override
	public int addProductToCart(Cart cart) throws CartException {
		/*Random random = new Random();
		int id = random.nextInt(100)+1000;	 
		cart.setProductId(id);
		id=cartDao.addProductToCart(cart);*/
		int id = cart.getProductId();
		//cart.setProductId(id);
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
