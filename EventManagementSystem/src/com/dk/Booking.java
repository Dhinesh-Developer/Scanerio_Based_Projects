package com.dk;

public class Booking {
	
	private static int counter = 5000;
	private int bookingId;
	private String CustomerName;
	private int eventId;
	private int seatsBooked;
	
	public Booking(String customerName, int eventId, int seatsBooked) {
		super();
		this.bookingId = counter++;
		CustomerName = customerName;
		this.eventId = eventId;
		this.seatsBooked = seatsBooked;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Booking.counter = counter;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", CustomerName=" + CustomerName + ", eventId=" + eventId
				+ ", seatsBooked=" + seatsBooked + "]";
	}
	
	
	
	
}
