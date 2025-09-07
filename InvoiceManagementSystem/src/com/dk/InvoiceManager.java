package com.dk;

import java.util.HashMap;
import java.util.Map;

public class InvoiceManager {

	Map<Integer, Customer> customer = new HashMap<>();
	Map<Integer, Product> product = new HashMap<>();
	Map<Integer, Invoice> invoices = new HashMap<>();
	
	
	public void addCustomer(String name,String phone) {
		Customer c = new Customer(name,phone);
		customer.put(c.getCustomerId(), c);
		System.out.println("Customer added successfully! Customer ID : "+c.getCustomerId());
		
	}
	
	public void addProduct(String productName,double price,int stocks) {
		Product p = new Product(productName,price,stocks);
		product.put(p.getProductId(), p);
		System.out.println("Product Added Successfully! Product ID: "+p.getProductId());
	}
	
	
	public void viewCustomers() {
		if(customer.isEmpty()) {
			System.out.println("No Customer Found.");
			return;
		}
		
		for(Customer x : customer.values()) {
			System.out.println(x);
		}
	}
	
	public void viewProduct() {
		if(product.isEmpty()) {
			System.out.println("No Product Found.");
			return;
		}
		
		for(Product x : product.values()) {
			System.out.println(x);
		}
	}
	
	public void viewInvoice() {
		if(invoices.isEmpty()) {
			System.out.println("No Invoice Found.");
			return;
		}
		
		for(Invoice x : invoices.values()) {
			System.out.println(x);
		}
	}
	
	
	public void createInvoice(int customerId,Map<Integer,Integer> order) {
		Customer c = customer.get(customerId);
		if(c == null) {
			System.out.println("Customer Not Found");
			return;
		}
		
		Invoice invoice = new Invoice(c);
		for(Map.Entry<Integer, Integer> x :order.entrySet()) {
			Product p = product.get(x.getKey());
			int qty = x.getValue();
			if(p == null) {
				System.out.println("Product ID: "+x.getKey()+" not found.");
				continue;
			}
			if(qty > p.getStocks()) {
				System.out.println("Not Enough stock for : "+p.getName());
				continue;
			}
			invoice.addItem(p, qty);
			invoice.generateBill();
			invoices.put(invoice.getInvoiceId(),invoice);
			System.out.println(invoice);
			
		}
	}
	
	
}
