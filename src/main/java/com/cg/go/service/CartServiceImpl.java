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
	
	//validating product id
	@Override
	public boolean validateId(int productId)
	{
		boolean flag = false;
		String id = Integer.toString(productId);
		flag = id.matches("[0-9]{4}");
		return flag;
	}
	
	//validating product name
	@Override
	public boolean validateName(String productName)
	{
		boolean flag=false;
		flag=productName.matches("[a-bA-B]+");
		return flag;
	}
	
	//validating product price
	@Override
	public boolean validatePrice(double price)
	{
		boolean flag = false;
		String p = Double.toString(price);
		flag = p.matches("[0-9]+");
		return flag;
	}
	
	//adding product to the cart
	@Override
	public int addProductToCart(Cart cart) throws CartException {
		
		int id = cart.getProductId();
		boolean  flag = validateId(id);
		if(flag==false) {
			throw new CartException("Product Id should be 4 digits");
		}
		id=cartDao.addProductToCart(cart);
		String name = cart.getProductName();
		boolean flag2 = validateName(name);
		if(!flag)
		{
			throw new CartException("Name should be Alphabet");
		}
		double price = cart.getProductPrice();
		boolean flag3 = validatePrice(price);
		if(!flag)
		{
			throw new CartException("Input should be Numbers");
		}

		return id;
	}

	//deleting product from the cart
	@Override
	public Cart deleteProductByIdInCart(int productId) throws CartException {
		return cartDao.deleteProductByIdInCart(productId);
	}
	
	//viewing all products in cart
	@Override
	public List<Cart> findAllProductsInCart() throws CartException {
		return cartDao.findAllProductsInCart();
	}

	
}
