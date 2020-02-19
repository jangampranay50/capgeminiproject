package com.cg.service;

import java.util.*;
import java.util.Random;

import com.cg.bean.Product;
import com.cg.dao.ProductDao;
import com.cg.dao.ProductDaoMapImpl;
import com.cg.exception.ProductException;

public class ProductServiceImpl implements ProductService
{
	private ProductDao productDao;
	
	public ProductServiceImpl()
	{
		productDao = new ProductDaoMapImpl();
	}
	
	@Override
	public boolean validateName(String productName) {
		boolean flag = false;
		flag=productName.matches("[a-zA-z]+");
		return flag;
	}

	@Override
	public int addProduct(Product product) throws ProductException {
		String name = product.getProductName();
		boolean flag = validateName(name);
		if(!flag)
		{
			throw new ProductException("Name should contain only alphabets");
		}
		Random random = new Random();
		int id = random.nextInt(100)+1000;
		product.setProductId(id);
		id=productDao.addProduct(product);
		return id;
	}

	@Override
	public Product findProductById(int productId) throws ProductException {
		String proid = String.valueOf(productId);
		boolean flag = proid.matches("[0-9]{4}");
		if(!flag)
		{
			throw new ProductException("ID should be 4 digit ");
		}
		return productDao.findProductById(productId);
	}

	@Override
	public Product deleteProductById(int productId) throws ProductException {
		
		return productDao.deleteProductById(productId);
	}

	@Override
	public List<Product> findAllProducts() throws ProductException {
		
		return productDao.findAllProducts();
	}
	
}
