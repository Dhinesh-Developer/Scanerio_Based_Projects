package com.dk;

import java.util.ArrayList;
import java.util.List;

class Vehicle {
	
	
	String vehicleNumber;
	String vehicleType;
	boolean isVIP;
	List<Journey> journeys;
	
	
	
	public Vehicle(String vehicleNumber, String vehicleType, boolean isVIP) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.isVIP = isVIP;
		this.journeys = new ArrayList<>();
	}
	
	public void addJourney(Journey journey) {
		journeys.add(journey);
		
	}
	
	public void displayDetails() {
		System.out.println("Vehicle Number: "+vehicleNumber);
		System.out.println("Type: " + vehicleType +", VIP: "+ isVIP);
		
		for(Journey x : journeys) {
			System.out.println("Journey: "+x.startPoint +" -> "+x.endPoint);
			System.out.println("Tolls Passed: "+x.tollsPassed);
			System.out.println("Amount Paid: "+x.amountPaid);
		}
		
		int totalPaid = 0;
		
		for(Journey x : journeys) {
			totalPaid += x.amountPaid;
		}
		System.out.println("Total Amount Paid: "+totalPaid);
		
	}
	
	
	
}
