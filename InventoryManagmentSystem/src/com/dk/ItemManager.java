package com.dk;

import java.util.*;

public class ItemManager {

    Map<Integer, Item> map = new HashMap<>();
    Scanner in = new Scanner(System.in);
    Item item = new Item();

    public void addItem(int id,String name,int quantity,double price){
        if(map.containsKey(id)){
            System.out.println("Item with ID already present! ");
            return;
        }else{
            Item item = new Item(id,name,quantity,price);
            map.put(id,item);
            System.out.println("Item added successfully!");
        }
    }

    public void viewItems(){
        if(map.isEmpty()){
            System.out.println("No items present!");
            return;
        }
        System.out.println("List of items: ");
        for(Item x : map.values()){
            System.out.println(x);
        }
    }

    public void searchItem(int id){
        Item i = map.get(id);
        if(i == null) {
            System.out.println("No Item match with the ID: " + id);
            return;
        }

        System.out.println(i);
    }

    public void updateItem(int id,String name,int quantity,double price){
        Item i = map.get(id);
        if(i == null){
            System.out.println("Item is not present with the ID: "+id);
        }else{
            Item updatedItem = new Item(id,name,quantity,price);
            map.put(id,updatedItem);
            System.out.println("Item updated successfully!");
        }
    }

    public void deleteItem(int id){
        Item i = map.get(id);
        if(i == null){
            System.out.println("No Item match with the ID: "+id);
        }else{
            map.remove(id);
            System.out.println("Item deleted Successfully!");
        }
    }

    public void transactions(int id) {
        Item i = map.get(id);

        if (i == null) {
            System.out.println("No Item match with the ID: " + id);
            return;
        }

        System.out.println("1. Purchase (Add stock)");
        System.out.println("2. Sell (Reduce stock)");
        System.out.print("Choose your transaction: ");
        int choice = in.nextInt();

        System.out.print("Enter Quantity: ");
        int qty = in.nextInt();

        if (choice == 1) {
            // Purchase → increase stock
            i.setQuantity(i.getQuantity() + qty);
            System.out.println("Purchase successful! New stock: " + i.getQuantity());
        } else if (choice == 2) {
            // Sell → reduce stock (check if enough stock is available)
            if (qty > i.getQuantity()) {
                System.out.println("Not enough stock available! Current stock: " + i.getQuantity());
            } else {
                i.setQuantity(i.getQuantity() - qty);
                System.out.println("Sale successful! Remaining stock: " + i.getQuantity());
            }
        } else {
            System.out.println("Invalid transaction choice!");
        }
    }




}
