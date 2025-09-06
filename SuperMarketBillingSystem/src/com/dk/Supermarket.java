package com.dk;

import java.util.HashMap;
import java.util.Map;

public class Supermarket {
	
	private Map<Integer, Product> products = new HashMap<>();
	private Map<Integer, cartItem> cart = new HashMap<>();
	
	// admin can only add product
	public void addProducts(String name,double price,int stocks) {
		Product p = new Product(name,price,stocks);
		products.put(p.getProductId(), p);
		System.out.println("Products added successfully product ID: "+p.getProductId());
	}
	
	public void viewProducts() {
		if(products.isEmpty()) {
			System.out.println("No products available!");
			return;
		}
		for(Product x : products.values()) {
			System.out.println(x);
		}
	}
	
	public void viewCart() {
		if(cart.isEmpty()) {
			System.out.println("Cart is Empty!");
			return;
		}
		
		double total = 0;
		System.out.println("🛒 Cart Items:");
		for(cartItem x : cart.values()) {
			System.out.println(x);
			total += x.getTotalPrice();
		}
		System.out.println("Total price : "+total);
	}
	
	public void addToCart(int productId,int qty) {
		Product p = products.get(productId);
		if(p == null) {
			System.out.println("Product not found");
			return;
		}
		if(qty > p.getStock()) {
			System.out.println("Not Enough stock available");
			return;
		}
		
		p.reduceStock(qty);
		if(cart.containsKey(productId)) {
			cartItem existing = cart.get(productId);
			cart.put(productId, new cartItem(p,existing.getQuantity()+qty));
		}else {
			cart.put(productId, new cartItem(p,qty));
		}
		System.out.println("Added to cart : "+p.getName()+" x "+qty);
	}
	
	
	public void removeToCart(int productId,int qty) {
		cartItem item = cart.get(productId);
		if(item == null) {
			System.out.println("Item not in cart");
			return;
		}
		
		if(qty > item.getQuantity()) {
			cart.remove(productId);
			item.getProduct().increaseStock(qty);
			System.out.println("Removed item from the cart");
		}else {
			cart.put(productId, new cartItem(item.getProduct(),item.getQuantity()-qty));
			item.getProduct().increaseStock(qty);
			System.out.println("Removed "+qty+" units from the cart");
		}
		
	}
	
	
	public void checkOut() {
		if(cart.isEmpty()) {
			System.out.println("Cart is empty! Add items before Checkout.");
			return;
		}
		
		double total = 0;
		for(cartItem x : cart.values()) {
			System.out.println(x);
			total += x.getTotalPrice();
		}
		
		double discount = 0;
		if(total > 2000) discount = 0.20;
		else if(total > 1000) discount = 0.10;
		else if(total >500) discount = 0.05;
		
		double finalAmount = total - discount;
		
		System.out.println("Total: " + total);
        System.out.println("Discount: " + discount);
        System.out.println("Final Payable: " + finalAmount);
        System.out.println("--- Thank you! Visit again ---\n");
	}
	
}
