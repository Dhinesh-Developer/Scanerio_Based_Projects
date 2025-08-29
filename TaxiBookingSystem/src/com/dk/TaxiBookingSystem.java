package com.dk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaxiBookingSystem {

    static List<Taxi> taxis = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    static int customerCounter = 1;

    public static void main(String[] args) {

        System.out.println("Enter number of taxis: ");
        int numTaxis = in.nextInt();

        initializeTaxis(numTaxis);

        while (true) {
            System.out.println("\n1. Book Taxi \n2. Display Taxi Details \n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    bookTaxi();
                    break;
                case 2:
                    displayTaxiDetails();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void initializeTaxis(int n) {
        for (int i = 1; i <= n; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public static void bookTaxi() {
        int customerId = customerCounter++;
        System.out.print("Enter Pickup point (A-F): ");
        char pickup = in.next().toUpperCase().charAt(0);
        System.out.print("Enter Drop point (A-F): ");
        char drop = in.next().toUpperCase().charAt(0);
        System.out.print("Enter Pickup Time (in hours): ");
        int pickUpTime = in.nextInt();

        Taxi selectedTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi taxi : taxis) {
            if (taxi.isAvailable(pickUpTime)) {
                int pickupPoint = pickup - 'A' + 1;
                int taxiPoint = taxi.currentPoint - 'A' + 1;
                int distance = Math.abs(taxiPoint - pickupPoint);

                if (selectedTaxi == null || distance < minDistance ||
                        (distance == minDistance && taxi.totalEarnings < selectedTaxi.totalEarnings)) {
                    selectedTaxi = taxi;
                    minDistance = distance;
                }
            }
        }

        if (selectedTaxi == null) {
            System.out.println("Booking rejected. No taxis available.");
            return;
        }

        int dropTime = pickUpTime + Math.abs(drop - pickup);
        int amount = selectedTaxi.calculateEarnings(pickup, drop);

        int bookingId = selectedTaxi.bookings.size() + 1;

        Booking booking = new Booking(bookingId, customerId, pickUpTime, dropTime, amount, pickup, drop);
        selectedTaxi.addBooking(booking);

        System.out.println("Taxi-" + selectedTaxi.id + " is allocated.");
    }

    public static void displayTaxiDetails() {
        for (Taxi taxi : taxis) {
            System.out.println("\nTaxi-" + taxi.id + " Total Earnings: Rs." + taxi.totalEarnings);
            System.out.printf("%-10s %-10s %-5s %-5s %-12s %-9s %-6s%n",
                    "BookingID", "CustomerID", "From", "To", "PickupTime", "DropTime", "Amount");

            for (Booking booking : taxi.bookings) {
                System.out.printf("%-10d %-10d %-5c %-5c %-12d %-9d %-6d%n",
                        booking.bookingId, booking.customerId, booking.from, booking.to,
                        booking.pickingTime, booking.dropTime, booking.amount);
            }
        }
    }
}
