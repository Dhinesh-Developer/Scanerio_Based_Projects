package com.arise.dk;

import java.time.LocalDateTime;

public class Transactions {

    private int accountNumber;
    private String typeOfTransactions;
    private double amount;
    private LocalDateTime dateTime;
    private double balanceAfterTransactions;

    public Transactions() {
    }

    public Transactions(int accountNumber, String typeOfTransactions, double amount, LocalDateTime dateTime, double balanceAfterTransactions) {
        this.accountNumber = accountNumber;
        this.typeOfTransactions = typeOfTransactions;
        this.amount = amount;
        this.dateTime = dateTime;
        this.balanceAfterTransactions = balanceAfterTransactions;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTypeOfTransactions() {
        return typeOfTransactions;
    }

    public void setTypeOfTransactions(String typeOfTransactions) {
        this.typeOfTransactions = typeOfTransactions;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getBalanceAfterTransactions() {
        return balanceAfterTransactions;
    }

    public void setBalanceAfterTransactions(double balanceAfterTransactions) {
        this.balanceAfterTransactions = balanceAfterTransactions;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "accountNumber=" + accountNumber +
                ", typeOfTransactions='" + typeOfTransactions + '\'' +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                ", balanceAfterTransactions=" + balanceAfterTransactions +
                '}';
    }
}
