package com.dk;

public class Product {
	
	private static int counter = 100;
	private int productId;
	private String name;
	private double price;
	private int stock;
	
	public Product(String name,double price,int stock) {
		this.productId = counter++;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	public void reduceStock(int qty) {
		stock -= qty;
	}
	
	public void increaseStock(int qty) {
		stock += qty;
	}
	

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Product.counter = counter;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}
	
	
	
	
}
