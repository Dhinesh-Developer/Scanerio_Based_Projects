package com.arise.dk;

public class Account {

    private String accountHolderName;
    private int accountNumber;
    private double balance;
    private String accountType;

    public Account(String accountHolderName, int accountNumber, double balance, String accountType) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public Account() {
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
