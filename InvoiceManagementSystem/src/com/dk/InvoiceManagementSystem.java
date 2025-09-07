package com.dk;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InvoiceManagementSystem {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		InvoiceManager manager = new InvoiceManager();

		while(true) {
			System.out.println("\n--- Invoice Management System ---");
			System.out.println("1. Add Customer");
			System.out.println("2. Add Product");
			System.out.println("3. View Customers");
			System.out.println("4. View Products");
			System.out.println("5. Create Invoice");
			System.out.println("6. View All Invoices");
			System.out.println("7. Exit");


			System.out.print("Enter choice: ");
			int choice = in.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Enter Customer Name: ");
				String name = in.nextLine();
				in.nextLine();
				System.out.println("Enter Phone Number: ");
				String phone = in.nextLine();

				manager.addCustomer(name, phone);
				break;

			case 2:
				System.out.println("Enter product Name : ");
				String productName = in.nextLine();
				in.nextLine();
				System.out.println("Enter the price: ");
				double price = in.nextDouble();
				System.out.println("Enter stock Quantity: ");

				int quantity = in.nextInt();
				manager.addProduct(productName,price,quantity);
				break;

			case 3:
				manager.viewCustomers();
				break;

			case 4:
				manager.viewProduct();
				break;

			case 5:
				System.out.println("Enter the customer ID: ");
				int customerId = in.nextInt();
				Map<Integer,Integer> order = new HashMap<>();
				while(true) {
					System.out.println("Enter product Id (0 to stop): ");
					int pId = in.nextInt();
					if(pId == 0) break;
					System.out.println("Enter Quantity: ");
					int qty = in.nextInt();
					order.put(pId, qty);

				}
				manager.createInvoice(customerId, order);
				break;

			case 6:
				manager.viewInvoice();
				break;

			case 7:
				System.out.println("System Existing....");
				in.close();
				return;

			default:
				System.out.println("Invalid choice.. Please Try again..");
			}




		}

	}
}
