package com.cg.go.exception;

//custom exception class
public class CartException extends Exception 
{
	//parameterized constructor
	public CartException(String message)
	{
		super(message);
	}
	
	//default constructor
	public CartException()
	{
		super();
	}
}
