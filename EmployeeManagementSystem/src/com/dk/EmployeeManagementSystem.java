package com.dk;

import java.util.Scanner;

public class EmployeeManagementSystem {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        EmployeeManagement sys = new EmployeeManagement();

        while(true){
            System.out.println("--------Employee Management System-----------");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit..");

            System.out.println("Enter your choice: ");
            int choice = in.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the Employee ID: ");
                    int id = in.nextInt();
                    System.out.println("Enter the Employee Name: ");
                    String name = in.nextLine();
                    in.nextLine();
                    System.out.println("Enter the Employee Age: ");
                    int age = in.nextInt();
                    System.out.println("Enter the Employee Department: ");
                    String dept = in.nextLine();
                    in.nextLine();
                    System.out.println("Enter the Employee Salary: ");
                    double salary = in.nextDouble();
                    sys.addEmployee(id,name,age,dept,salary);
                    break;

                case 2:
                    sys.viewEmployee();
                    break;

                case 3:
                    System.out.println("Enter the Employee ID to search: ");
                    int search = in.nextInt();
                    sys.searchEmployee(search);
                    break;

                case 4:
                    System.out.println("Enter the Employee ID to update: ");
                    int id1 = in.nextInt();
                    System.out.println("Enter the Employee Name: ");
                    String name1 = in.nextLine();
                    in.nextLine();
                    System.out.println("Enter the Employee Age: ");
                    int age1 = in.nextInt();
                    System.out.println("Enter the Employee Department: ");
                    String dept1 = in.nextLine();
                    in.nextLine();
                    System.out.println("Enter the Employee Salary: ");
                    double salary1 = in.nextDouble();
                    sys.updateEmployee(id1,name1,age1,dept1,salary1);
                    break;

                case 5:
                    System.out.println("Enter the ID to delete the Employee: ");
                    int ID = in.nextInt();
                    sys.deleteEmployee(ID);
                    break;

                case 6:
                    System.out.println("System Existing....");
                    System.exit(0);

                    in.close();
                    break;

                default:
                    System.out.println("Invalid choice please try again!");
                    break;
            }
        }

    }
}