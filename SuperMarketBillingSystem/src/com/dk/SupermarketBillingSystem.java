package com.dk;

import java.util.*;

public class SupermarketBillingSystem {
	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		Supermarket market = new Supermarket();

		while (true) {
			System.out.println("\n--- Supermarket Billing System ---");
			System.out.println("1. Add Product (Admin)");
			System.out.println("2. View Products");
			System.out.println("3. Add to Cart");
			System.out.println("4. Remove from Cart");
			System.out.println("5. View Cart");
			System.out.println("6. Checkout");
			System.out.println("7. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter Product Name: ");
				String name = sc.nextLine();
				System.out.print("Enter Price: ");
				double price = sc.nextDouble();
				System.out.print("Enter Stock: ");
				int stock = sc.nextInt();
				market.addProducts(name, price, stock);
				break;

			case 2:
				market.viewProducts();
				break;

			case 3:
				System.out.print("Enter Product ID: ");
				int pid = sc.nextInt();
				System.out.print("Enter Quantity: ");
				int qty = sc.nextInt();
				market.addToCart(pid, qty);
				break;

			case 4:
				System.out.print("Enter Product ID: ");
				int removeId = sc.nextInt();
				System.out.print("Enter Quantity to Remove: ");
				int removeQty = sc.nextInt();
				market.removeToCart(removeId, removeQty);
				break;

			case 5:
				market.viewCart();
				break;

			case 6:
				market.checkOut();
				break;

			case 7:
				System.out.println("Exiting Supermarket Billing System. Bye!");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice.");
			}
		}
	}
}

