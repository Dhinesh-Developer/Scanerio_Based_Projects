package com.dk;

public class Customer {
	
	private int counter = 1000;
	private int customerId;
	private String name;
	private String phoneNumber;
	
	public Customer(String name, String phoneNumber) {
		this.customerId = counter++;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [counter=" + counter + ", customerId=" + customerId + ", name=" + name + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	
	
}
