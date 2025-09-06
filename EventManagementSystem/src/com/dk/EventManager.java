package com.dk;

import java.util.HashMap;
import java.util.Map;

public class EventManager {

	Map<Integer,Event> events = new HashMap<>();
	Map<Integer,Booking> bookings = new HashMap<>();
	

	public void createEvent(String name,String organizer,String date,String venue,int seats) {
		Event e = new Event(name,organizer,date,venue,seats);
		events.put(e.getEventId(),e);
		System.out.println("Event Booked successfully!..");
	}


	public void viewEvents() {
		if(events.isEmpty()) {
			System.out.println("No Event available!");
			return;
		}
		for(Event x : events.values()) {
			System.out.println(x);
		}
	}

	public void bookTickets(int eventId,String customerName,int seats) {
		Event e = events.get(eventId);
		if(e == null) {
			System.out.println("No Event Available.");
			return;
		}else if(e.bookTickets(seats)) {
			Booking b = new Booking(customerName,eventId,seats);
			bookings.put(b.getBookingId(), b);
			System.out.println("Booking Seats success ! Booking Id: "+b.getBookingId());
			return;
		}else {
			System.out.println("Not enough seats available!");
		}
	}

	public void cancelTicket(int bookingId) {
		Booking b = bookings.get(bookingId);
		if(b == null) {
			System.out.println("Bookings not avaialble");
			return;
		}

		Event e = events.get(b.getBookingId());
		if(e != null) {
			e.cancelTickets(b.getSeatsBooked());
		}
		bookings.remove(bookingId);
		System.out.println("Booking cancelled! Booking ID: "+b.getBookingId());
	}

	
	public void viewBookings() {
		if(bookings.isEmpty()) {
			System.out.println("No bookings available!");
			return;
		}
		
		for(Booking x : bookings.values()) {
			System.out.println(x);
		}
	}
	
	public void search(String keyword) {
		boolean isFound = false;
		for(Event e : events.values()) {
			if(e.getName().equalsIgnoreCase(keyword) ||
				String.valueOf(e.getEventId()).equals(keyword)) {
				System.out.println(e);
				isFound = true;
			}
		}
		if(!isFound) {
			System.out.println("No event found with keyword: "+keyword);
		}
	}
	
	public void deleteEvents(int eventId) {
		Event e = events.get(eventId);
		if(e == null) {
			System.out.println("No events available!");
		}
		if(e.hasBookings()) {
			System.out.println("Cannot delete event with activeID: "+eventId);
			return;
		}
		events.remove(eventId);
		System.out.println("Event deleted successfully! Event ID: "+eventId);
	}


}
