package com.dk;

public class Product {
	
	private int counter = 2000;
	private int productId;
	private String name;
	private double price;
	private int stocks;
	
	public Product(String name, double price, int stocks) {
		super();
		this.productId = counter++;
		this.name = name;
		this.price = price;
		this.stocks = stocks;
	}
	
	public void reduceStock(int qty) {
		stocks -= qty;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
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

	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	@Override
	public String toString() {
		return "Product [counter=" + counter + ", productId=" + productId + ", name=" + name + ", price=" + price
				+ ", stocks=" + stocks + "]";
	}
	
	
	
	
}
