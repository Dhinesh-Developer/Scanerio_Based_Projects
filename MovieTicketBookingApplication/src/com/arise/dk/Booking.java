    package com.arise.dk;
    import javax.xml.crypto.dsig.TransformService;
    import java.time.LocalDateTime;
    import java.util.*;
    public class Booking {

        Movie movies = new Movie();
        Transactions t = new Transactions();
        public static Map<Integer,Movie> movieDetails;
        private static List<Transactions> transactionsHistory;

        public Booking() {
            movieDetails = new HashMap<>();
            transactionsHistory = new ArrayList<>();
        }

        public void createMovie(int movieId, String movieName, String showTime, double ticketPrice, int totalSeats){
    //        Movie prevMovie = movieDetails.get(movieId);
    //        if(prevMovie.getMovieId() == movieId){
    //            System.out.println("Movie Id is already present!");
    //        }
            Movie newMovie = new Movie(movieId,movieName,showTime,ticketPrice,totalSeats);
            movieDetails.put(movieId,newMovie);
            System.out.println("Movie created successfully!");
        }

        public void viewListOfMovies(){
            if(movieDetails.isEmpty()){
                System.out.println("Movie List is Empty!");

            }else{
                for(Movie x : movieDetails.values()){
                    System.out.println(x);
                }
            }
        }

        public void bookTickets(int movieId,int seats){
            Movie movie = movieDetails.get(movieId);
            if(movie == null){
                System.out.println("Movie is not found");
                return;
            }
            if(movie.getAvailableSeats() <= seats){
                System.out.println("No available seats!");
                return;
            }

            int reamingSeats = movie.getAvailableSeats()-seats;
            movie.setAvailableSeats(reamingSeats);
            double price = seats * movie.getTicketPrice();

            Transactions t = new Transactions(movie.getMovieName(),seats,price,movieId);
            transactionsHistory.add(t);
            System.out.println("Booking confirmed! seats Booked: "+seats+" total price: "+price);
        }

        public void viewTransactionsHistory(){
            if(transactionsHistory.isEmpty()){
                System.out.println("Transactions History is Empty!");
                return;
            }
            for(Transactions x : transactionsHistory){
                System.out.println(x);
            }
        }

        public void cancelBookingSeats(int movieId, int transactionsId) {
            Movie movie = movieDetails.get(movieId);
            if (movie == null) {
                System.out.println("Movie is not found! Provide a valid movie ID!");
                return;
            }

            Transactions toCancel = null;
            for (Transactions t : transactionsHistory) {
                if (t.getTransactionsId() == transactionsId) {
                    toCancel = t;
                    break;
                }
            }

            if (toCancel == null) {
                System.out.println("Transaction ID is not valid - or - no such booking exists!");
                return;
            }


            int revertSeats = toCancel.getSeatsBooked();
            movie.setAvailableSeats(movie.getAvailableSeats() + revertSeats);

            double refund = toCancel.getPrice();

            transactionsHistory.remove(toCancel);

            System.out.println("Booking cancelled successfully!");
            System.out.println("Seats reverted: " + revertSeats + " | Refund amount: " + refund);
        }


    }
