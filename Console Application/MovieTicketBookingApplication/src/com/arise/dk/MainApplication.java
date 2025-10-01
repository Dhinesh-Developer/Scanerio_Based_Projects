package com.arise.dk;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {

        Movie movie = new Movie();
        Booking booking = new Booking();
        Transactions transactions = new Transactions();
        Scanner in = new Scanner(System.in);

        while(true){
            System.out.println("---Movie Ticket Booking Application---");
            System.out.println("1.Create Movie");
            System.out.println("2.view List of Movies");
            System.out.println("3.Book movie tickets");
            System.out.println("4.Transactions History");
            System.out.println("5.cancel Tickets");
            System.out.println("6.Exit");

            System.out.println("Enter your choice: ");
            int choice = in.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the Movie Id:");
                    int id = in.nextInt();
                    in.nextLine();
                    System.out.println("Enter the Movie Name: ");
                    String name = in.nextLine();
                    System.out.println("Enter the showTime: ");
                    String showTime = in.nextLine();
                    System.out.println("Enter the Ticket Price: ");
                    double ticketPrice = in.nextDouble();
                    System.out.println("Enter the Total Seats: ");
                    int totalSeats = in.nextInt();
                    booking.createMovie(id,name,showTime,ticketPrice,totalSeats);
                    break;
                case 2:
                    booking.viewListOfMovies();
                    break;
                case 3:
                    System.out.println("Enter the MovieId: ");
                    int movieId = in.nextInt();
                    System.out.println("Enter the Number of seats: ");
                    int bookingSeats = in.nextInt();
                    booking.bookTickets(movieId,bookingSeats);
                    break;
                case 4:
                    booking.viewTransactionsHistory();
                    break;
                case 5:
                    System.out.println("Enter the MovieId: ");
                    int cancelMovieId = in.nextInt();
                    System.out.println("Enter the Transactions Id: ");
                    int Transactions = in.nextInt();
                    booking.cancelBookingSeats(cancelMovieId,Transactions);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("---Invalid Choice ----");
                    return;
            }

        }
    }
}
