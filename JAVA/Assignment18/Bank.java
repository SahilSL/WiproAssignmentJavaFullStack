package com.wipro.practice.Assignment18;

public abstract class Bank {
    String accNo;
    String custName;
    int custGender; // 1 = Male, 2 = Female
    String custJob;
    double curBal;

    public Bank(String accNo, String custName, int custGender, String custJob, double curBal) {
        this.accNo = accNo;
        this.custName = custName;
        this.custGender = custGender;
        this.custJob = custJob;
        this.curBal = curBal;
    }

    public abstract double calcBalance();

    public String toString() {
        String gender = (custGender == 1) ? "Male" : "Female";
        return "Account No: " + accNo + "\nName: " + custName + "\nGender: " + gender +
                "\nJob: " + custJob + "\nCurrent Balance: RM " + curBal;
    }
}

