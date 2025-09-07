package com.dk;

import java.util.ArrayList;
import java.util.List;

public class Invoice {

	private int counter = 3000;
	private int invoiceId;
	private Customer customer;
	private List<InvoiceItem> items;
	private double total;
	private double discount;
	private double tax;
	private double finalAmount;
	
	public Invoice(Customer customer) {
		this.invoiceId = counter++;
		this.customer = customer;
		this.items = new ArrayList<>();
	}
	
	public void addItem(Product product,int qty) {
		items.add(new InvoiceItem(product,qty));
		product.reduceStock(qty);
	}
	
	public void generateBill() {
		total = 0;
		
		for(InvoiceItem x : items) {
			total += x.getTotalPrice();
		}
		
		discount = 0;
		if(total > 2000) discount = 0.20;
		else if(total > 1000) discount = 0.10;
		else if(total > 500) discount = 0.05;
		else discount = 0;
		
		double afterDiscount = total - discount;
		tax = afterDiscount * 0.18;
		finalAmount = afterDiscount + tax;
	}
	
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n--- Invoice ---\n");
        sb.append("Invoice ID: ").append(invoiceId).append("\n");
        sb.append("Customer: ").append(customer.getName()).append("\n");
        sb.append("Items:\n");
        for (InvoiceItem item : items) {
            sb.append("  ").append(item).append("\n");
        }
        sb.append("Total: ").append(total).append("\n");
        sb.append("Discount: ").append(discount).append("\n");
        sb.append("Tax (18% GST): ").append(tax).append("\n");
        sb.append("Final Amount: ").append(finalAmount).append("\n");
        sb.append("--- Thank You ---\n");
        return sb.toString();
    }
	
	

	public int getCounter() {
		return counter;
	}
	
	

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<InvoiceItem> getItems() {
		return items;
	}

	public void setItems(List<InvoiceItem> items) {
		this.items = items;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}
	
	
	
	
}	
