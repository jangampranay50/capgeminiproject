package com.cg.go.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.go.bean.Cart;
import com.cg.go.exception.CartException;
import com.cg.go.service.CartService;
import com.cg.go.service.CartServiceImpl;

public class CartClient 
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
	    CartService cartService = new CartServiceImpl();
		
		int choice = 0;
		Cart cart = null;
		List<Cart> list = null;
		while(true)
		{
			System.out.println("1.Add Product to Cart");
			System.out.println("2.Delete Product from Cart");
			System.out.println("3.List all Products of Cart");
			System.out.println("4.exit");
			System.out.println("Enter your Choice : ");
			choice = sc.nextInt();

			switch(choice)
			{
			case 1:
				int pid = 0;
				try
				{
				System.out.println("Enter Product ID : ");
			    pid = sc.nextInt();
			    boolean  flag = cartService.validateId(pid);
				if(flag==false) {
					throw new CartException("Product Id should be 4 digits");
				}
				}
			    catch(InputMismatchException e)
				{
			    	throw new InputMismatchException("Id should be Integer");
				}
			    sc.nextLine();
			    String name = null;
			    try
			    {
			    System.out.println("Enter Product Name : ");
			    name = sc.nextLine();
			    }
			    catch(InputMismatchException e)
			    {
			    	throw new InputMismatchException("Name should be in Alphabets");
			    }
			    double price = 0;
			    try
			    {
			    System.out.println("Enter Product Price : ");
			    price = sc.nextDouble();
			    }
			    catch(InputMismatchException e)
			    {
			    	throw new InputMismatchException("Input should be numbers");
			    }
				cart = new Cart();
				cart.setProductId(pid);
				cart.setProductName(name);
				cart.setProductPrice(price);
				try {
				int id = cartService.addProductToCart(cart);
				System.out.println("Product Successfully Added to Cart (Product Id = "+id+")");
				}
				catch(CartException e)
				{
					throw new CartException(e.getMessage());
				}
				break;
			case 2:
				try
				{
					System.out.println("Enter Product Id : ");
					int id1 = sc.nextInt();
					cart = cartService.deleteProductByIdInCart(id1);
					System.out.println("Item Deleted From Cart");
				}
				catch(InputMismatchException e)
				{
					throw new InputMismatchException("Input should be integer");
				}
				catch(CartException e)
				{
					throw new CartException(e.getMessage());
				}
				break;
			case 3:
				try
				{
					list = cartService.findAllProductsInCart();
					for(Cart c1 : list)
						System.out.println("ProductId = "+c1.getProductId()+"\nProduct Name : "+c1.getProductName()+"\nProduct Price : "+c1.getProductPrice());
					if(list.isEmpty())
					{
						System.err.println("Cart is Empty");
					}
				}
				catch(InputMismatchException e)
				{
					throw new InputMismatchException("Input should be Number");
				}
				catch(CartException e)
				{
					throw new CartException(e.getMessage());
				}
				break;
			case 4:
				System.out.println("THANK YOU");
				return;
			default :
				System.err.println("Incorrect Choice");
				System.err.println("Please Enter Correct Choice");
				break;
			}
		}
	}		
}
