package com.dk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Highway {
	
	List<Toll> tollPoints; // 0: Toll A- Fee: 25
	
	// vehicleRecords.put("TN02CD5678", bike);
	Map<String, Vehicle> vehicleRecord;
	
	public Highway(List<Toll> tollPoints) {
		this.tollPoints = tollPoints;
		this.vehicleRecord = new HashMap<>();
	}
	
	public void processJourney(String vehicleNumber, String vehicleType, boolean isVIP, String start, String end, List<Integer> tollRoute) {
		Vehicle vehicle = vehicleRecord.computeIfAbsent(vehicleNumber, vn -> new Vehicle(vn, vehicleType, isVIP));
		int totalAmount = 0;
		for(int tollId : tollRoute) { // 0,1,2
			Toll toll = tollPoints.get(tollId);
			
			int charge = toll.calculateToll(vehicleType, isVIP);
			// recordVehicle is present in Toll.java class
			toll.recordVehicle(vehicle, charge);
			totalAmount += charge;
		}
		Journey journey = new Journey(start, end, tollRoute, totalAmount);
		vehicle.addJourney(journey);
		
		System.out.println("Journey completed! Total Toll paid: "+totalAmount);
	}
	
	
	public void displayTollDetails() {
		for(Toll x : tollPoints) {
			x.displayDetails();
		}
	}
	
	public void displayVehicleDetails() {
		for(Vehicle x : vehicleRecord.values()) {
			x.displayDetails();
		}
	}
	
	
	
	public List<Integer> findCircularRoute(int start,int end){
		List<Integer> forwardRoute = new ArrayList<>();
		List<Integer> backwardRoute = new ArrayList<>();
		int totalTolls = tollPoints.size();
		
		// Forward route
		for(int i=start;i!=end;i=(i+1)%totalTolls) {
			forwardRoute.add(i); // [0, 1, 2]
		}
		forwardRoute.add(end);
		
		// Backward route
		for(int i=start; i!=end; i =(i-1+totalTolls) % totalTolls) {
			backwardRoute.add(i);
		}
		backwardRoute.add(end);
		
		return forwardRoute.size() <= backwardRoute.size() ? forwardRoute : backwardRoute;
 	}
	
	
	public int calculateRegularTollForRoute(int start,int end, String vehicleType, boolean isVIP) {
		int totalCost = 0;
		if(start <= end) {
			for(int i=start;i<=end;i++) {
				Toll toll = tollPoints.get(i);
				totalCost += toll.calculateToll(vehicleType, isVIP);
			}
		}else {
			
			// [0, 1, 2]
			for(int i=start;i<tollPoints.size();i++) {
				Toll toll = tollPoints.get(i);
				totalCost += toll.calculateToll(vehicleType, isVIP);
			}
			
			for(int i=0;i<=end;i++) {
				Toll toll = tollPoints.get(i);
				totalCost += toll.calculateToll(vehicleType, isVIP);
			}
		}
		return totalCost;
	}
	
	// Calculate toll for a Specfic Route.
	public int calculateTollForRoute(List<Integer> tollRoute, String vehicleType, boolean isVIP) {
		int totalCost = 0;
		for(int tollId : tollRoute) {
			Toll toll = tollPoints.get(tollId);
			totalCost += toll.calculateToll(vehicleType, isVIP);
		}
		return totalCost;
	}
	
	
	
}
