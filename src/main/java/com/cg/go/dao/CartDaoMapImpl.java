package com.cg.go.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.go.bean.Cart;
import com.cg.go.exception.CartException;

public class CartDaoMapImpl implements CartDao
{
	private Map<Integer,Cart> map;
	
	public CartDaoMapImpl()
	{
		map=new HashMap<Integer,Cart>();
	}

	@Override
	public int addProductToCart(Cart cart) throws CartException {
		boolean flag = map.containsKey(cart.getProductId());
		if(flag)
		{
			throw new CartException("Product already Exist");
		}
		map.put(cart.getProductId(), cart);
		return cart.getProductId();
	}

	@Override
	public Cart deleteProductByIdInCart(int productId) throws CartException {
		Cart cart = null;
		if(map.containsKey(productId))
			cart = map.remove(productId);
		else
			throw new CartException(productId+" Id not found");
		return cart;
	}

	@Override
	public List<Cart> findAllProductsInCart() throws CartException {
		Collection<Cart> col = map.values();
		List<Cart> list = new ArrayList<>();
		
		for(Cart c : col)
		{
			list.add(c);
		}
		return list;
	}
	
}
