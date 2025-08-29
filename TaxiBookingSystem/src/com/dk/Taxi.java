package com.dk;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
    int id;
    char currentPoint = 'A';
    int totalEarnings = 0;
    List<Booking> bookings = new ArrayList<>();

    public Taxi(int id) {
        this.id = id;
    }

    // Check if taxi is free at requested time
    public boolean isAvailable(int requestTime) {
        if (bookings.isEmpty()) return true;
        Booking lastBooking = bookings.get(bookings.size() - 1);
        return lastBooking.dropTime <= requestTime;
    }

    // Calculate fare: base 100 + 10/km after 5 km
    public int calculateEarnings(char from, char to) {
        int distance = Math.abs(to - from) * 15; // each point gap = 15 km
        return 100 + Math.max(0, (distance - 5) * 10);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
        totalEarnings += booking.amount;
        currentPoint = booking.to;
    }
}
