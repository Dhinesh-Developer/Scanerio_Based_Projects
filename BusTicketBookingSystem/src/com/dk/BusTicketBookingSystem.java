package com.dk;

import java.util.Scanner;

public class BusTicketBookingSystem {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Bus bus = new Bus(10);  // initialize the seats. for real use change 40.

		while(true) {
			System.out.println("\n--- Bus Ticket Booking System ---");
			System.out.println("1. Book Ticket");
			System.out.println("2. Cancel Ticket");
			System.out.println("3. View Available Seats");
			System.out.println("4. View Booked Tickets");
			System.out.println("5. Exit");

			System.out.print("Enter your choice: ");
			int choice = in.nextInt();
			in.nextLine();

			switch(choice) {
			case 1:
				System.out.println("Enter Name: ");
				String name = in.nextLine();
				System.out.println("Enter Age: ");
				int age = in.nextInt();
				in.nextLine();
				System.out.println("Enter Gender (Male/Female): ");
				String gender = in.nextLine();

				bus.bookTicket(name, age, gender);
				break;

			case 2:
				System.out.println("Enter the Seat No to cancel: ");
				int seatNo = in.nextInt();
				bus.cancelTicket(seatNo);
				break;
			case 3:
				bus.viewAvailabeSeats();
				break;
			case 4:
				bus.viewBookedTickets();
				break;
			case 5:
				System.out.println("Existing....");
				break;
			default :
				System.out.println("Invalid choice..");
			}

		}

	}
}
