package com.dk;

import java.util.*;

public class EventManagementSystem {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     EventManager manager = new EventManager();

     while (true) {
         System.out.println("\n--- Event Management System ---");
         System.out.println("1. Create Event");
         System.out.println("2. View Events");
         System.out.println("3. Book Ticket");
         System.out.println("4. Cancel Ticket");
         System.out.println("5. Search Event");
         System.out.println("6. Delete Event");
         System.out.println("7. View Bookings");
         System.out.println("8. Exit");
         System.out.print("Enter choice: ");

         int choice = sc.nextInt();
         sc.nextLine(); 

         switch (choice) {
             case 1:
                 System.out.print("Enter Event Name: ");
                 String name = sc.nextLine();
                 System.out.print("Enter Organizer: ");
                 String organizer = sc.nextLine();
                 System.out.print("Enter Date: ");
                 String date = sc.nextLine();
                 System.out.print("Enter Venue: ");
                 String venue = sc.nextLine();
                 System.out.print("Enter Total Seats: ");
                 int seats = sc.nextInt();
                 manager.createEvent(name, organizer, date, venue, seats);
                 break;

             case 2:
                 manager.viewEvents();
                 break;

             case 3:
                 System.out.print("Enter Event ID: ");
                 int eventId = sc.nextInt();
                 sc.nextLine();
                 System.out.print("Enter Customer Name: ");
                 String customer = sc.nextLine();
                 System.out.print("Enter No. of Seats: ");
                 int seatCount = sc.nextInt();
                 manager.bookTickets(eventId, customer, seatCount);
                 break;

             case 4:
                 System.out.print("Enter Booking ID: ");
                 int bookingId = sc.nextInt();
                 manager.cancelTicket(bookingId);
                 break;

             case 5:
                 System.out.print("Enter Event Name or Event ID: ");
                 String keyword = sc.nextLine();
                 manager.search(keyword);
                 break;

             case 6:
                 System.out.print("Enter Event ID to delete: ");
                 int delId = sc.nextInt();
                 manager.deleteEvents(delId);
                 break;

             case 7:
                 manager.viewBookings();
                 break;

             case 8:
                 System.out.println("Thank you for using Event Management System!");
                 sc.close();
                 return;

             default:
                 System.out.println("Invalid choice. Try again.");
         }
     }
 }
}
