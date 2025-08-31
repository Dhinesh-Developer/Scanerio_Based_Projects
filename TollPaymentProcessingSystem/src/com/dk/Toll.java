package com.dk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Toll {
	
	int tollId;
	Map<String, Integer> chargesPerVehicleType; // chargesPerVehicleType("car", 50);
	List<VehiclePayment> vehiclesPassed;
	int totalRevenue;
	
	
	public Toll(int tollId, Map<String, Integer> chargesPerVehicleType) {
		this.tollId = tollId;
		this.chargesPerVehicleType = chargesPerVehicleType;
		this.vehiclesPassed = new ArrayList<>();
		this.totalRevenue = 0;
	}
	
	
	public int calculateToll(String vehicleType, boolean isVIP) {
		// This means the default value is 0, if no value is present
		int charge = chargesPerVehicleType.getOrDefault(vehicleType, 0);
		if(isVIP) {
			charge = charge - (charge / 5); // 20% discount
		}
		return charge;
	}
	
	
	public void recordVehicle(Vehicle vehicle, int charge) {
		vehiclesPassed.add(new VehiclePayment(vehicle.vehicleNumber, charge));
		totalRevenue += charge;
	}
	
	public void displayDetails() {
		System.out.println("Toll ID: "+tollId);
		System.out.println("Vehicles Passed:");
		for(VehiclePayment vp : vehiclesPassed) {
			System.out.println("Vehicle: "+vp.vehicleNumber + ", Paid: "+vp.amountPaid);
		}
		System.out.println("Total Revenue: "+totalRevenue);
	}
	
	
	
	
}
