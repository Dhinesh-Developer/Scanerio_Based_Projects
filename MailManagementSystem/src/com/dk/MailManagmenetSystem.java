package com.dk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class MailManagmenetSystem {
	
	private List<Mail> mails;
	
	private Set<String> spamWords;
	
	private Scanner in;
	
	public MailManagmenetSystem() {
		mails = new ArrayList<>();
		spamWords = new HashSet<>(Arrays.asList("lottery","winnner","prize","free","urgent","congragulations"));
		in = new Scanner(System.in);
	}
	
	
	public void storeMail() {
		System.out.println("Enter sender email: ");
		String sender = in.nextLine();
		System.out.println("Enter receiver email: ");
		String receiver = in.nextLine();
		System.out.println("Enter subject: ");
		String subject = in.nextLine();
		System.out.println("Enter content: ");
		String content = in.nextLine();
		
		Mail mail = new Mail(sender,receiver,subject,content);
		checkSpam(mail);
		mails.add(mail);
		System.out.println("Mail stored successfully!");
		
	}
	
	
	public void deleteMail() {
		System.out.println("Enter mail index to delete:");
		int index = in.nextInt();
		in.nextLine();
		if(index >=0 && index < mails.size()) {
			mails.remove(index);
			System.out.println("Mail deleted successfully!");
		}else {
			System.out.println("Invalid mail index!");
		}
	}
	
	
	public void addTag() {
		System.out.println("Enter mail index: ");
		int index = in.nextInt();
		in.nextLine();
		if(index>=0 && index <mails.size()) {
			System.out.println("Enter tag: ");
			String tag = in.nextLine();
			mails.get(index).addTag(tag);
			System.out.println("Tag added sucessfully!");
		}else {
			System.out.println("Invalid mail index!");
		}
	}
	
	
	public void showStats() {
		System.out.println("\nMail Statistics:");
		System.out.println("Total Mails: "+mails.size());
		System.out.println("\nEnter number of recent mails to display: ");
		int n = in.nextInt();
		in.nextLine();
		
		System.out.println("\nRecent "+n+" mails:");
		mails.stream()
			.skip(Math.max(0, mails.size()-n))
			.forEach(System.out::println);
	}
	
	private void checkSpam(Mail mail) {
		String content = mail.getContent().toLowerCase();
		for(String word : spamWords) {
			if(content.contains(word)) {
				mail.setSpam(true);
				break;
			}
		}
	}
	
	
	public void search() {
		System.out.println("Enter search query: ");
		String query = in.nextLine().toLowerCase();
		
		List<Mail> res = mails.stream()
				.filter(mail ->
				mail.getSender().toLowerCase().contains(query)||
				mail.getReceiver().toLowerCase().contains(query)||
				mail.getSubject().toLowerCase().contains(query) ||
				mail.getContent().toLowerCase().contains(query) ||
				mail.getTags().stream().anyMatch(tag -> tag.toLowerCase().contains(query)))
				.collect(Collectors.toList());
		
		if(res.isEmpty()) {
			System.out.println("No mails found matching the query.");
		}else {
			System.out.println("\n Search Results:");
			res.forEach(System.out::println);
		}
	}
	
	public void wildSearch() {
		System.out.println("Enter wildcard pattern (use * for any characters): ");
		String pattern = in.nextLine().toLowerCase().replace("*",".*");
		
		
		List<Mail> res = mails.stream()
				.filter(mail ->
				mail.getSender().toLowerCase().contains(pattern)||
				mail.getReceiver().toLowerCase().contains(pattern)||
				mail.getSubject().toLowerCase().contains(pattern) ||
				mail.getContent().toLowerCase().contains(pattern) ||
				mail.getTags().stream().anyMatch(tag -> tag.toLowerCase().contains(pattern)))
				.collect(Collectors.toList());
		
		if(res.isEmpty()) {
			System.out.println("No mails found matching the pattern.");
		}else {
			System.out.println("\n Wild Search Results:");
			res.forEach(System.out::println);
		}
	}
	
	
	public void displayMenu() {
		System.out.println("\n MAil Management System:");
		System.out.println("1. Store Mail");
		System.out.println("2. Delete Mail");
		System.out.println("3. Add tag");
		System.out.println("4. Show Statistics");
		System.out.println("5. Search");
		System.out.println("6. WildCard Search");
		System.out.println("7. Exit");
		System.out.println("Enter your choice: ");
		
	}
	
	public static void main(String[] args) {
		
		MailManagmenetSystem system = new MailManagmenetSystem();
		int choice;
		
		do {
			system.displayMenu();
			choice = system.in.nextInt();
			system.in.nextLine();
			
			switch(choice) {
			case 1:
				system.storeMail();
				break;
			case 2:
				system.deleteMail();
				break;
			case 3:
				system.addTag();
				break;
			case 4:
				system.showStats();
				break;
			case 5:
				system.search();
				break;
			case 6:
				system.wildSearch();
				break;
			case 7:
				System.out.println("Existing...");
				break;
				default:
					System.out.println("Invalid Choice!");
			}
			
		}while(choice != 7);
		
		system.in.close();
		
		
	}
	
}
