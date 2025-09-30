package com.arise.dk;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Bank {

    Transactions transactions = new Transactions();
    Account accounts = new Account();
    private static Map<Integer,Account> accountDetails;
    private static List<Transactions> transactionsHistory;

    public Bank(){
        accountDetails = new HashMap<>();
        transactionsHistory = new ArrayList<>();
    }



    public void deposit(double amount,int  accountNumber){
        if(accountDetails.containsKey(accountNumber)){
            if(amount > 0){
                Account acc = accountDetails.get(accountNumber);
                double newBalance = acc.getBalance()+amount;
                acc.setBalance(newBalance);
                System.out.println("Amount deposited successfully!");
                Transactions transactions1 = new Transactions(accountNumber,"Withdraw",amount, LocalDateTime.now(),newBalance);
                transactionsHistory.add(transactions1);
            }else{
                System.out.println("Amount should Greater than zero");
            }
        }else{
            System.out.println("Account Number Not valid!");
        }
    }


    public void createAccount(String accountHolderName, int accountNumber, double balance, String accountType) {
        if (accountDetails.containsKey(accountNumber)) {
            System.out.println("Account with this number already exists!");
            return;
        }
        Account newAccount = new Account(accountHolderName, accountNumber, balance, accountType);
        accountDetails.put(accountNumber, newAccount);
        System.out.println("Account created successfully!");
    }

    public void viewAccountDetails(){
        if(!accountDetails.isEmpty()){
            System.out.println(accountDetails);
        }else{
            System.out.println("Account Details is Empty!");
        }
    }

    public void checkBalance(int accountNumber){
        if(accountDetails.containsKey(accountNumber)){
            Account acc = accountDetails.get(accountNumber);
            System.out.println("Balance :"+acc.getBalance());
        }else{
            System.out.println("Invalid AccountNumber!");
        }
    }


    public void withdraw(double amount,int accNumber){
        if(accountDetails.containsKey(accNumber)){
            Account acc = accountDetails.get(accNumber);
            if(amount >0 && amount < acc.getBalance()){

                double balance = acc.getBalance();
                double newBalance = balance-amount;
                acc.setBalance(newBalance);

                System.out.println("Withdraw Amount :"+amount+" success, remainingBalance: "+newBalance);
                Transactions transactions2 = new Transactions(accNumber,"Withdraw",amount,LocalDateTime.now(),newBalance);
                transactionsHistory.add(transactions2);
            }else{
                System.out.println("Insufficient Balance!");
            }
        }else{
            System.out.println("AccountNumber is Not Valid!");
        }
    }


    public void viewTransactionsHistory(){
        if(!transactionsHistory.isEmpty()){
            for(Transactions x : transactionsHistory){
                System.out.println(x);
            }
        }else{
            System.out.println("No Transactions has been done yet!");
        }
    }



}
