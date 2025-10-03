package com.arise.dk;

import java.util.Scanner;

public class LibraryMangementSystem {
    public static void main(String[] args) {
        LibraryManager lb = new LibraryManager();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Create Book");
            System.out.println("2. Show List of Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. View Borrowed Books");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            in.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the book name: ");
                    String name = in.nextLine();
                    System.out.print("Enter the book author: ");
                    String author = in.nextLine();
                    System.out.print("Enter the number of copies: ");
                    int copies = in.nextInt();
                    System.out.print("Enter the book Id: ");
                    int id = in.nextInt();
                    lb.createBooks(id, name, author, copies);
                    break;

                case 2:
                    lb.showListOfBooks();
                    break;

                case 3:
                    System.out.print("Enter the userName: ");
                    String uname = in.nextLine();
                    System.out.print("Enter the userId: ");
                    int uid = in.nextInt();
                    System.out.print("Enter the bookId to borrow: ");
                    int bid = in.nextInt();
                    System.out.print("Enter number of copies: ");
                    int c = in.nextInt();
                    lb.borrowBook(uname, uid, bid, c);
                    break;

                case 4:
                    lb.viewBorrowedBooksByUser();
                    break;

                case 5:
                    System.out.print("Enter the Book ID to return: ");
                    int rBid = in.nextInt();
                    System.out.print("Enter your User ID: ");
                    int rUid = in.nextInt();
                    lb.returnBooks(rBid, rUid);
                    break;

                case 6:
                    System.out.println("👋 Exiting... Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("⚠ Invalid choice!");
            }
        }
    }
}
