package com.dk;

import java.util.Scanner;

public class FlightController {
	
	public static void main(String[] args) {
		
		FlightReservationSystem system = new FlightReservationSystem();
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n--- Flight Reservation System ---");
			System.out.println("1. Book Ticket");
			System.out.println("2. Cancel Ticket");
			System.out.println("3. Print Flight Details");
			System.out.println("4. Exit");
			
			System.out.print("Enter your choice: ");
			int choice = in.nextInt();
			in.nextLine(); // Consume new Line.
			
			switch(choice) {
				case 1: // Book Flight
					System.out.println("Enter flight name (Indigo/SpiceJet): ");
					String flightName = in.nextLine();
					
					if(system.flights.containsKey(flightName)) {
						system.displayFlightDetails(flightName);
						System.out.println("Enter passenger name: ");
						String passengerName = in.nextLine();
						System.out.println("Enter passenger age: ");
						int age = in.nextInt();
						System.out.println("Enter number of seats to book: ");
						int seats = in.nextInt();
						
						// The below function returns the bookingId. show the return of Id
						String bookingId = system.bookTicket(flightName, passengerName, age, seats);
						if(bookingId != null) {
							System.out.println("Booking successful! Your booking ID is: "+bookingId);
						}
					}else {
						System.out.println("Invalid flight name, Please try again.");
					}
					break;
					
				case 2: // Cancel Ticket
					System.out.println("Enter flight name (Indigo/SpiceJet): ");
					flightName = in.nextLine();
					System.out.println("Enter booking ID: ");
					String bookingId = in.nextLine();
					
					system.cancelTicket(flightName, bookingId);
					break;
					
				case 3: // Print the Flight Details
					System.out.println("Enter flight name (Indigo/SpiceJet): ");
					flightName = in.nextLine();
					system.printFlightDetails(flightName);
					break;
					
				case 4:
					System.out.println("Existing system. Thank You!");
					in.close();
					return;
					
				default:
					System.out.println("Invalid choice. Please try again.");
						
			}
		
			
			
		}
		
	}
}
