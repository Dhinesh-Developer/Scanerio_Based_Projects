package com.dk;

import java.util.Scanner;

public class TicketBooking {

	public static void main(String[] args) {
		
		TicketSystem ticketSystem = new TicketSystem();
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.println("\nRailway Booking System:");
			System.out.println("1. Book Ticket");
			System.out.println("2. Cancel Ticket");
			System.out.println("3. View Confirmed Tickets");
			System.out.println("4. View Available Tickets");
			System.out.println("5. View RAC Tickets");
			System.out.println("6. View Waiting List Tickets");
			System.out.println("7. EXit");
			
			System.out.println("Enter your choice:");
			int choice = in.nextInt();
			in.nextLine(); // Consume new Line.
			
			switch(choice) {
				case 1:
					System.out.println("Enter Name: ");
					String name = in.nextLine();
					System.out.println("Enter Age: ");
					int age = in.nextInt();
					in.nextLine(); // Consume new line.
					System.out.println("Enter Gender (Male/Female): ");
					String gender = in.nextLine();
					System.out.println("Enter Berth Preference (L/U/M)");
					String berthPerference = in.nextLine();
					ticketSystem.bookTicket(name, age, gender, berthPerference);
					break;
					
				case 2:
					System.out.println("Enter Ticket ID to Cancel: ");
					String ticketId = in.nextLine();
					ticketSystem.cancelTicket(ticketId);
					break;
					
				case 3:
					ticketSystem.printBookedTicket();
					break;
					
				case 4:
					ticketSystem.printAvailableTickets();
					break;
					
				case 5:
					ticketSystem.viewRacTickets();
					break;
					
				case 6: 
					ticketSystem.viewWaitingListTickets();
					break;
					
				case 7:
					System.out.println("Existing...");
					System.exit(0);
					
				default:
					System.out.println("Invalid choice. Try again.");
			}
		}
	}
	
}
