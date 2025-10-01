package com.arise.dk;

public class Transactions {
    private static int counter = 200;

    private int transactionsId;
    private String movieName;
    private int seatsBooked;
    private double price;
    private int bookingId;

    public Transactions() {
    }

    public Transactions(String movieName, int seatsBooked, double price, int bookingId) {
        this.transactionsId = counter++;
        this.movieName = movieName;
        this.seatsBooked = seatsBooked;
        this.price = price;
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transactionsId=" + transactionsId +
                ", movieName='" + movieName + '\'' +
                ", seatsBooked=" + seatsBooked +
                ", price=" + price +
                ", bookingId=" + bookingId +
                '}';
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Transactions.counter = counter;
    }

    public int getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(int transactionsId) {
        this.transactionsId = transactionsId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
