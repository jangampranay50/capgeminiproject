package com.cg.go.bean;

public class Cart extends Product
{
	private int cartId;

	public Cart(int cartId) {
		super();
		this.cartId = cartId;
	}

	public Cart() {
		super();
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

}
