package com.dk;

public class Event {
	
	private static int counter = 1000;
	private int eventId;
	private String name;
	private String organizer;
	private String date;
	private String venue;
	private int totalSeats;
	private int bookedSeats;
	
	public Event(String name, String organizer, String date, String venue, int totalSeats) {
		super();
		this.eventId = counter++;
		this.name = name;
		this.organizer = organizer;
		this.date = date;
		this.venue = venue;
		this.totalSeats = totalSeats;
		this.bookedSeats = 0;
	}
	
	public boolean bookTickets(int cnt) {
		if(bookedSeats+cnt < totalSeats) {
			bookedSeats += cnt;
			return true;
		}
		return false;
	}
	
	public boolean cancelTickets(int cnt) {
		if(bookedSeats-cnt >= 0) {
			bookedSeats -=cnt;
			return true;
		}
		return false;
	}

	public boolean hasBookings() {
		return bookedSeats > 0;
	}
	
	
	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Event.counter = counter;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", name=" + name + ", organizer=" + organizer + ", date=" + date
				+ ", venue=" + venue + ", totalSeats=" + totalSeats + ", bookedSeats=" + bookedSeats + "]";
	}
	
	
	
	
}
