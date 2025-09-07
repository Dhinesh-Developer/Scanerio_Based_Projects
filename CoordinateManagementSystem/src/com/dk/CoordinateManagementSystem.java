package com.dk;

import java.util.Scanner;

public class CoordinateManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoordinateManger manager = new CoordinateManger();

        while (true) {
            System.out.println("\n--- Coordinate Management System ---");
            System.out.println("1. Add a Point");
            System.out.println("2. View All Points");
            System.out.println("3. Find Distance between Two Points");
            System.out.println("4. Find Nearest Point to Origin");
            System.out.println("5. Find Nearest Point to a Given Point");
            System.out.println("6. Find All Points within a Radius");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter X coordinate: ");
                    double x = sc.nextDouble();
                    System.out.print("Enter Y coordinate: ");
                    double y = sc.nextDouble();
                    manager.addPoints(x, y);
                    break;

                case 2:
                    manager.viewPoints();
                    break;

                case 3:
                    System.out.print("Enter Point1 ID: ");
                    int id1 = sc.nextInt();
                    System.out.print("Enter Point2 ID: ");
                    int id2 = sc.nextInt();
                    manager.findDistance(id1, id2);
                    break;

                case 4:
                    manager.findNearestToOrigin();
                    break;

                case 5:
                    System.out.print("Enter Reference Point ID: ");
                    int refId = sc.nextInt();
                    manager.findNearestToPoint(refId);
                    break;

                case 6:
                    System.out.print("Enter radius: ");
                    double r = sc.nextDouble();
                    manager.findWithinRadius(r);
                    break;

                case 7:
                    System.out.println("Exiting Coordinate Management System.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}