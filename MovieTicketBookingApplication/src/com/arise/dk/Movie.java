package com.arise.dk;

import java.time.LocalDateTime;

public class Movie {

    private int movieId;
    private String movieName;
    private String showTime;
    private double ticketPrice;
    private int totalSeats;
    private int availableSeats;

    public Movie() {
    }

    public Movie(int movieId, String movieName, String showTime, double ticketPrice, int totalSeats, int availableSeats) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    public Movie(int movieId, String movieName, String showTime, double ticketPrice, int totalSeats) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", showTime=" + showTime +
                ", ticketPrice=" + ticketPrice +
                ", totalSeats=" + totalSeats +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
