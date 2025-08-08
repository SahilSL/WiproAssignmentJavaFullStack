package com.wipro.springassignment2;

public class Bank {
    private long bankId;
    private String bankName;

    public Bank(long bankId, String bankName) {
        this.bankId = bankId;
        this.bankName = bankName;
    }

    public String getBankDetails() {
        return "Bank ID: " + bankId + ", Bank Name: " + bankName;
    }
}
