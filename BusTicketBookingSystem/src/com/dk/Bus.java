package com.dk;

import java.util.HashMap;
import java.util.Map;

public class Bus {

	private int capacity;
	private boolean[] seats;
	private Map<Integer,Passenger> bookings;

	
	public Bus(int capacity) {
		this.capacity = capacity;
		this.seats = new boolean[capacity+1];
		this.bookings = new HashMap<>();
	}


	public boolean bookTicket(String name,int age,String gender) {
		for(int i=1;i<=capacity;i++) {
			if(!seats[i]) {
				Passenger p = new Passenger(name,age,gender,i);
				seats[i] = true;
				bookings.put(i, p);
				System.out.println("✅ Ticket booked succesfully! seats No: "+i);
				return true;
			}
		} 
		System.out.println("Sorry! No available seats");
		return false;
	}

	public boolean cancelTicket(int seatNo) {
        if (seatNo < 1 || seatNo > capacity || !seats[seatNo]) {
            System.out.println("❌ Invalid seat number or seat not booked.");
            return false;
        }
        seats[seatNo] = false;
        bookings.remove(seatNo);
        System.out.println("✅ Ticket cancelled for Seat No: " + seatNo);
        return true;
    }
	
	
	public void viewAvailabeSeats() {
		System.out.println("Available Seats: ");
		boolean isAnyAvailable = false;
		for(int i=1;i<=capacity;i++) {
			if(!seats[i]) {
				System.out.print(i+" ");
				isAnyAvailable = true;
			}
		}
		
		if(!isAnyAvailable) {
			System.out.println("None");
		}
		System.out.println();
	}
	
	public void viewBookedTickets() {
		if(bookings.isEmpty()) {
			System.out.println("❌ No ticket booked not yet!");
		}else {
			System.out.println("Booked Tickets: ");
			for(Passenger x : bookings.values()) {
				System.out.println(x);
			}
		}
	}

}
