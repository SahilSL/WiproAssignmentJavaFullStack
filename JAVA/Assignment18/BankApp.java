package com.wipro.practice.Assignment18;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Bank[] customers = new Bank[5];
        customers[0] = new Saving("A001", "Ravi", 1, "Engineer", 10000, 0.04);
        customers[1] = new Current("A002", "Sita", 2, "Teacher", 15000, 0.03, true);
        customers[2] = new Saving("A003", "Arjun", 1, "Doctor", 20000, 0.05);
        customers[3] = new Current("A004", "Meena", 2, "Manager", 18000, 0.02, false);
        customers[4] = new Current("A005", "Karan", 1, "Analyst", 22000, 0.03, true);

        Scanner input = new Scanner(System.in);

        //Show balance for all
        System.out.println("Customer Balances:");
        for (Bank b : customers) {
            System.out.println("---------------------------");
            System.out.println(b);
            System.out.println("Balance with interest: RM " + b.calcBalance());
        }

        //Search by account number
        System.out.print("\nEnter account number to search: ");
        String accSearch = input.nextLine();
        boolean found = false;
        for (Bank b : customers) {
            if (b.accNo.equalsIgnoreCase(accSearch)) {
                System.out.println("\nCustomer Found:");
                System.out.println(b);
                System.out.println("Balance with interest: RM " + b.calcBalance());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Customer with account number " + accSearch + " not found.");
        }

        //Count current account holders and total balance
        int countCurrent = 0;
        double totalBalanceCurrent = 0;
        for (Bank b : customers) {
            if (b instanceof Current) {
                countCurrent++;
                totalBalanceCurrent += b.calcBalance();
            }
        }

        System.out.println("\nNumber of Current Account Holders: " + countCurrent);
        System.out.println("Total Balance in Current Accounts: RM " + totalBalanceCurrent);
    }
}

/*Customer Balances:
---------------------------
Account No: A001
Name: Ravi
Gender: Male
Job: Engineer
Current Balance: RM 10000.0
Balance with interest: RM 10400.0
---------------------------
Account No: A002
Name: Sita
Gender: Female
Job: Teacher
Current Balance: RM 15000.0
Balance with interest: RM 15300.0
---------------------------
Account No: A003
Name: Arjun
Gender: Male
Job: Doctor
Current Balance: RM 20000.0
Balance with interest: RM 21000.0
---------------------------
Account No: A004
Name: Meena
Gender: Female
Job: Manager
Current Balance: RM 18000.0
Balance with interest: RM 18360.0
---------------------------
Account No: A005
Name: Karan
Gender: Male
Job: Analyst
Current Balance: RM 22000.0
Balance with interest: RM 22510.0

Enter account number to search: */