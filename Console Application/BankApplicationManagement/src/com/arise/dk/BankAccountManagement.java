package com.arise.dk;

import java.util.Scanner;

public class BankAccountManagement {

    public static void main(String[] args) {
        Account acc = new Account();
        Bank bank = new Bank();
        Scanner in = new Scanner(System.in);


        while(true){
            System.out.println("----BankAccountManagementSystem----");
            System.out.println("1.CreateAccount");
            System.out.println("2.depositMoney");
            System.out.println("3.Account Details");
            System.out.println("4.Check Balance");
            System.out.println("5.withdraw");
            System.out.println("6.view Transactions History");
            System.out.println("8.Exit");

            System.out.println("Enter your choice: ");
            int choice = in.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the UserName:");
                    String name = in.nextLine();
                    in.nextLine();
                    System.out.println("Enter the AccountNumber:");
                    int accNumber = in.nextInt();
                    System.out.println("Enter the Balance:");
                    double balance = in.nextDouble();
                    in.nextLine();
                    System.out.println("Enter the AccountType (Savings/Current):");
                    String type=  in.nextLine();
                    bank.createAccount(name,accNumber,balance,type);
                    break;
                case 2:
                    System.out.println("Enter the amount to deposit:");
                    double amount = in.nextDouble();
                    System.out.println("Enter the Account Number: ");
                    int accountNumber = in.nextInt();
                    bank.deposit(amount,accountNumber);
                    break;
                case 3:
                    bank.viewAccountDetails();
                    break;
                case 4:
                    System.out.println("Enter the Account Number to Check Balance: ");
                    int checkBalanceAccountNumber = in.nextInt();
                    bank.checkBalance(checkBalanceAccountNumber);
                    break;
                case 5:
                    System.out.println("Enter the Amount to withdraw: ");
                    double withdrawAmount = in.nextDouble();
                    System.out.println("Enter the Account Number: ");
                    int withdrawAccountNumber = in.nextInt();
                    bank.withdraw(withdrawAmount,withdrawAccountNumber);
                    break;

                case 6:
                    bank.viewTransactionsHistory();
                    break;
                case 8:
                    System.exit(0);
                    return;
                default:
                    System.out.println("Invalid Choice!");
                    return;
            }
        }
    }
}
