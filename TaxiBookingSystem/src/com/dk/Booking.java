package com.dk;

public class Booking {
    int bookingId, customerId, pickingTime, dropTime, amount;
    char from, to;

    public Booking(int bookingId, int customerId, int pickingTime, int dropTime, int amount, char from, char to) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.pickingTime = pickingTime;
        this.dropTime = dropTime;
        this.amount = amount;
        this.from = from;
        this.to = to;
    }
}
