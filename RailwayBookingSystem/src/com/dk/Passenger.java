package com.dk;

public class Passenger {
	
	String name;
	int age;
	String gender;
	String berthPreference; // Lower, Upper or Middle
	String allottedBerth;
	String ticketId; // Important for canceling tickets.
	
	public Passenger(String name, int age, String gender, String berthPreference, String allottedBerth,
			String ticketId) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.berthPreference = berthPreference;
		this.allottedBerth = allottedBerth;
		this.ticketId = ticketId;
	}

	@Override
	public String toString() {
		return "Passenger [name=" + name + ", age=" + age + ", gender=" + gender + ", berthPreference="
				+ berthPreference + ", allottedBerth=" + allottedBerth + ", ticketId=" + ticketId + "]";
	}
	
}
