package com.cg.dao;

import java.util.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.bean.Product;
import com.cg.exception.ProductException;



public class ProductDaoMapImpl implements ProductDao
{
private Map<Integer,Product> map;
	
	public ProductDaoMapImpl()
	{
		map=new HashMap<Integer,Product>();
	}
	
	@Override
	public int addProduct(Product product) throws ProductException {
		boolean flag = map.containsKey(product.getProductId());
		if(flag)
		{
			throw new ProductException("ID already Exist");
		}
		map.put(product.getProductId(), product);
		return product.getProductId();
	}

	@Override
	public Product findProductById(int productId) throws ProductException {
		boolean flag = map.containsKey(productId);
		Product product = null;
		if(flag)
		{
			product = map.get(productId);
		}
		else
		{
			throw new ProductException(productId+" Id Not Found");
		}
		return product;
	}

	@Override
	public Product deleteProductById(int productId) throws ProductException {
		Product product = null;
		if(map.containsKey(productId))
			product = map.remove(productId);
		else
			throw new ProductException(productId+" Id not found");
		return product;
	}

	@Override
	public List<Product> findAllProducts() throws ProductException {
		Collection<Product> col = map.values();
		List<Product> list = new ArrayList<>(col);
		
		return list;
	}
	
}
