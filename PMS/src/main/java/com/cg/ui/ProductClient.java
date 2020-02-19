package com.cg.ui;

import java.util.List;
import java.util.Scanner;

import com.cg.bean.Product;
import com.cg.exception.ProductException;
import com.cg.service.ProductService;
import com.cg.service.ProductServiceImpl;

public class ProductClient {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		ProductService productService = new ProductServiceImpl();
		
		int choice = 0;
		Product product = null;
		List<Product> list = null;
		while(true)
		{
			System.out.println("1.Add Product");
			System.out.println("2.Search Product");
			System.out.println("3.Delete Product");
			System.out.println("4.List all Products");
			System.out.println("5.exit");
			System.out.println("Enter your Choice : ");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter Product Name : ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter Product Price : ");
				double price = sc.nextDouble();
				product = new Product();
				product.setProductName(name);
				product.setProductPrice(price);
				try
				{
				int id = productService.addProduct(product);
				System.out.println("Product ID = "+id);
				}
				catch(ProductException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Enter Product ID : ");
				int id = sc.nextInt();
				try
				{
				product = productService.findProductById(id);
				System.out.println("Product Name : "+product.getProductName());
				System.out.println("Product Price : "+product.getProductPrice());
				}
				catch(ProductException e) 
				{
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				try
				{
					System.out.println("Enter Product Id : ");
					int id1 = sc.nextInt();
					product = productService.deleteProductById(id1);
					System.out.println("Deleted Product Name : "+product.getProductName());
					System.out.println("Deleted Product Price : "+product.getProductPrice());
				}
				catch(ProductException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			case 4:
				try
				{
					list=productService.findAllProducts();
					for(Product e : list)
					{
						System.out.println("Product ID : "+e.getProductId());
						System.out.println("Product Name : "+e.getProductName());
						System.out.println("Product Price : "+e.getProductPrice());
					}
				}
				catch(ProductException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println("THANK YOU");
				return;
			default :
				System.err.println("Incorrect Choice");
				System.out.println("Please Enter Correct Choice");
				break;
			}
		}
	}		
}


