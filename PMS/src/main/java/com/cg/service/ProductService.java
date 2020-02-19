package com.cg.service;

import java.util.*;

import com.cg.bean.Product;
import com.cg.exception.ProductException;

public interface ProductService 
{
	public boolean validateName(String productName);
	public int addProduct(Product product) throws ProductException;
	public Product findProductById(int productId) throws ProductException;
	public Product deleteProductById(int ProductId) throws ProductException;
	public List<Product> findAllProducts() throws ProductException;
}
