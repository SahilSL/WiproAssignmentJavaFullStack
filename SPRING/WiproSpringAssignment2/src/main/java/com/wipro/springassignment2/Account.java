package com.wipro.springassignment2;

public class Account {
    private long accountNumber;
    private String accountHolderName;
    private double balance;
    private Bank bank;

    public Account(long accountNumber, String accountHolderName, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.bank = bank;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println(bank.getBankDetails());
    }
}
