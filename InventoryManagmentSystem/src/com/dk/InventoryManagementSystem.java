package com.dk;

import java.lang.foreign.SymbolLookup;
import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ItemManager sys = new ItemManager();
        Item item = new Item();

        while(true){
            System.out.println("-----Inventory Management System-------");
            System.out.println("1. Add Item");
            System.out.println("2. View Item");
            System.out.println("3. search Item");
            System.out.println("4. Update Item");
            System.out.println("5. Delete Item");
            System.out.println("6. Transactions");
            System.out.println("7. Exit");

            System.out.println("Enter Your choice: ");
            int choice = in.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the Item ID: ");
                    int id = in.nextInt();
                    System.out.println("Enter the Item Name: ");
                    String name = in.nextLine();
                    in.nextLine();
                    System.out.println("Enter the Item Quantity: ");
                    int qty = in.nextInt();
                    System.out.println("Enter the Item price: ");
                    double price = in.nextDouble();

                    sys.addItem(id,name,qty,price);
                    break;
                case 2:
                    sys.viewItems();;
                    break;
                case 3:
                    System.out.println("Enter the Item ID to search: ");
                    int search = in.nextInt();
                    sys.searchItem(search);
                    break;
                case 4:
                    System.out.println("Enter the ID to update the Item: ");
                    int uId = in.nextInt();
                    System.out.println("Enter the Item Name: ");
                    String uName = in.nextLine();
                    in.nextLine();
                    System.out.println("Enter the Item Quantity: ");
                    int uQty = in.nextInt();
                    System.out.println("Enter the Item price: ");
                    double uPrice = in.nextDouble();

                    sys.updateItem(uId,uName,uQty,uPrice);
                    break;

                case 5:
                    System.out.println("Enter the Item ID to delete the Item: ");
                    int dId = in.nextInt();
                    sys.deleteItem(dId);
                    break;

                case 6:
                    System.out.println("Enter the Item ID for transactions: ");
                    int tranactions = in.nextInt();
                    sys.transactions(tranactions);
                    break;

                case 7:
                    System.out.println("System Existing... ");
                    System.exit(0);
                    in.close();
                    break;
                default:
                    System.out.println("Invalid choice , Please Try again..");
                    break;
            }
        }

    }
}