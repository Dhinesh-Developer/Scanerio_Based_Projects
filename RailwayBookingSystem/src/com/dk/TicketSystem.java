package com.dk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class TicketSystem {
	
	private final List<String> availableBerths = new ArrayList<>(Arrays.asList("L","U","M")); // 3 berth
	private final Queue<Passenger> racQueue = new LinkedList<>();
	private final Queue<Passenger> waitingListQueue = new LinkedList<>();
	private final List<Passenger> confirmedPassengers = new ArrayList<>();
	
	private int ticketCounter = 1;
	
	public void bookTicket(String name,int age,String gender,String berthPreference) {
		String ticketId = "T" + ticketCounter++; //1
		Passenger passenger;
		
		if(!availableBerths.isEmpty()) {
			String allocatedBerth = allocateBerth(age,gender,berthPreference);
			passenger = new Passenger(name,age,gender,berthPreference,allocatedBerth,ticketId);
			confirmedPassengers.add(passenger);
			availableBerths.remove(allocatedBerth);
			System.out.println("Ticket confirmed: "+passenger);
		}else if(racQueue.size()< 1) {
			passenger = new Passenger(name, age, gender, berthPreference, "RAC", ticketId);
			racQueue.offer(passenger); // add to tail of queue
			System.out.println("Ticket in RAC: "+passenger);
		}else if(waitingListQueue.size()<1){
			passenger = new Passenger(name, age, gender, berthPreference, "Waiting List", ticketId);
			waitingListQueue.offer(passenger); // add to tail.
			System.out.println("Ticket in waiting List: "+passenger);
		}else {
			// if berth, RAC and waiting List are fill, then
			System.out.println("No tickets available");
		}
	}
	
	
	public String allocateBerth(int age,String gender,String preferences) {
		if(age > 60 || gender.equalsIgnoreCase("female") && availableBerths.contains("L")) {
			return "L";
		}
		if(availableBerths.contains(preferences)) {
			return preferences;
		}
		return availableBerths.get(0);
	}
	
	
	public void cancelTicket(String ticketId) {
		Optional<Passenger> passengerOpt = confirmedPassengers.stream()
		.filter(p -> p.ticketId.equals(ticketId))
		.findFirst();
		
		if(passengerOpt.isPresent()) {
			Passenger passenger = passengerOpt.get();
			confirmedPassengers.remove(passenger);
			availableBerths.add(passenger.allottedBerth);
			
			if(!racQueue.isEmpty()) {
				Passenger racPassenger = racQueue.poll();
				String allocatedBerth = allocateBerth(racPassenger.age,racPassenger.gender,racPassenger.berthPreference);
				racPassenger.allottedBerth = allocatedBerth;
				confirmedPassengers.add(racPassenger);
				availableBerths.remove(allocatedBerth);
				System.out.println("RAC ticket moved to confirmed: "+racPassenger);
			}
			
			if(!waitingListQueue.isEmpty()) {
				Passenger waitingPassenger = waitingListQueue.poll();
				racQueue.offer(waitingPassenger);
				waitingPassenger.allottedBerth = "RAC";
				System.out.println("waiting list ticket moved to RAC: "+waitingPassenger);
			}
			System.out.println("Ticket cancelled successfully for ID: "+ticketId);
		}else {
			System.out.println("No ticket found with ID: "+ticketId);
		}
		
	}
	
	
	public void printBookedTicket() {
		if(confirmedPassengers.isEmpty()) {
			System.out.println("No confirmed tickets.");
		}else {
			System.out.println("Confirmed Tickets:");
			
			// iterate through the confirmedPassengers and print each 
			for(Passenger x : confirmedPassengers) {
				System.out.println(x);
			}
		}
	}
	
	
	
	public void printAvailableTickets() {
		System.out.println("Available Berths: "+availableBerths.size());
		System.out.println("Available RAC Tickets: "+(1-racQueue.size()));
		System.out.println("Available Waiting List Tickets: "+(1-waitingListQueue.size()));
	}
	
	
	
	public void viewRacTickets() {
		if(racQueue.isEmpty()) {
			System.out.println("No RAC tickets.");
		}else {
			System.out.println("RAC Tickets:");
			for(Passenger x : racQueue) {
				System.out.println(x);
			}
		}
	}
	
	
	public void viewWaitingListTickets() {
		if(waitingListQueue.isEmpty()) {
			System.out.println("No Waiting List tickets.");
		}else {
			System.out.println("Waiting List Tickets:");
			for(Passenger x : waitingListQueue) {
				System.out.println(x);
			}
		}
	}
	
	
	
	
}
