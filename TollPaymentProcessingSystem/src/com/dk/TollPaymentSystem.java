package com.dk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class TollPaymentSystem {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		// Initialize tolls
		List<Toll> tollPoints = new ArrayList<>();
		tollPoints.add(new Toll(0,Map.of("Car",50,"Bike",20,"Truck",100)));
		tollPoints.add(new Toll(0,Map.of("Car",60,"Bike",25,"Truck",125)));
		tollPoints.add(new Toll(0,Map.of("Car",70,"Bike",30,"Truck",150)));
		
		Highway highway = new Highway(tollPoints);
		
		while(true) {
			System.out.println("1. Process Journey");
			System.out.println("2. Display Toll Details");
			System.out.println("3. Display Vehicle Details");
			System.out.println("4. Find Shortest Route and calculate Toll");
			System.out.println("5. Exit");
			
			System.out.println("Enter your choice: ");
			int choice = in.nextInt();
			
			switch(choice) {
				case 1:
					System.out.println("Enter Vehicle Number: ");
					String vehicleNumber = in.next();
					System.out.println("Enter Vehicle Type (e.g., Car, Bike, Truck): ");
					String vehicleType = in.next();
					System.out.println("Are you a VIP? (true/false): ");
					boolean isVIP = in.nextBoolean();
					System.out.println("Enter Start Point: ");
					int start = in.nextInt();
					System.out.println("Enter End Point: ");
					int end = in.nextInt();
					
					//Calculate toll for regular route between start end end
					int regularToll = highway.calculateRegularTollForRoute(start, end, vehicleType, isVIP);
					System.out.println("Total Toll Paid: "+regularToll);
					
					// Process the Journey
					List<Integer> tollRoute = new ArrayList<>();
					
					for(int i= start;i<=end;i++) {
						tollRoute.add(i); // [0,1,2]
					}
					
					highway.processJourney(vehicleNumber, vehicleType, isVIP, String.valueOf(start), String.valueOf(end), tollRoute);
					break;
					
				case 2:
					highway.displayTollDetails();
					break;
					
				case 3:
					highway.displayVehicleDetails();
					break;
				case 4:
					System.out.println("Enter Start and End Points: ");
					start = in.nextInt();
					end = in.nextInt();
					
					if(start > end) {
						int temp = start;
						start = end;
						end = temp;
					}
					
					List<Integer> tollRouteCircular = highway.findCircularRoute(start, end);
					System.out.println("Shortest Route Tolls: "+tollRouteCircular);
					
					// Calculate and print toll cost for the Shortest route.
					System.out.println("Enter Vehicle Type (e.g., Car, Bike, Truck): ");
					vehicleType = in.next();
					System.out.println("Are you a VIP? (true/false): ");
					isVIP = in.nextBoolean();
					
					int totalCostCircular = highway.calculateTollForRoute(tollRouteCircular, vehicleType, isVIP);
					System.out.println("Total Toll Cost for Circular Route: "+totalCostCircular);
					break;
					
				case 5:
					System.out.println("Existing....");
					in.close();
					break;
					
				default:
					System.out.println("Invalid Choice!");
						
			}
		}
		
		
	}
	
}
