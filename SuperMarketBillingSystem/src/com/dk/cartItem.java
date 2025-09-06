package com.dk;

public class cartItem {
	
	private Product product;
	private int quantity;
	
	public cartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public double getTotalPrice() {
		return product.getPrice() * quantity;
	}
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

	@Override
	public String toString() {
		return "cartItem [product=" + product + ", quantity=" + quantity + "]";
	}
	
	
}
