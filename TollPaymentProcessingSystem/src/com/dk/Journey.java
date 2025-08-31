package com.dk;

import java.util.List;

public class Journey {
	
	
	String startPoint;
	String endPoint;
	
	// it will store the tolls list, tollsPassed = List.of(0, 1, 2);
	List<Integer> tollsPassed;
	int amountPaid;
	
	
	public Journey(String startPoint, String endPoint, List<Integer> tollsPassed, int amountPaid) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.tollsPassed = tollsPassed;
		this.amountPaid = amountPaid;
	}
	
	
}
