package com.wipro.hibernate.main;

import com.wipro.hibernate.entity.Account;
import com.wipro.hibernate.entity.AccountTransaction;
import com.wipro.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;

public class MainApp {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Account with Transactions");
            System.out.println("2. View All Accounts");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 : addAccount();
                case 2 : viewAccounts();
                case 3 : System.out.println("Exiting...");
                default : System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }

    private static void addAccount() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Account acc = new Account();
        System.out.print("Enter Account Holder Name: ");
        acc.setAccountHolder(sc.next());
        System.out.print("Enter Initial Balance: ");
        acc.setBalance(sc.nextDouble());

        List<AccountTransaction> transactions = new ArrayList<>();
        System.out.print("How many transactions to add? ");
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            AccountTransaction at = new AccountTransaction();
            System.out.print("Enter Transaction Description: ");
            at.setDescription(sc.next());
            System.out.print("Enter Transaction Amount: ");
            at.setAmount(sc.nextDouble());
            at.setAccount(acc);
            transactions.add(at);
        }

        acc.setTransactions(transactions);
        session.save(acc);
        tx.commit();
        session.close();

        System.out.println("Account and transactions added successfully.");
    }

    private static void viewAccounts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Account> accounts = session.createQuery("from Account", Account.class).list();

        for (Account acc : accounts) {
            System.out.println("\nAccount ID: " + acc.getAccountId());
            System.out.println("Holder Name: " + acc.getAccountHolder());
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("Transactions:");
            for (AccountTransaction t : acc.getTransactions()) {
                System.out.println("  - " + t.getDescription() + " : " + t.getAmount());
            }
        }

        session.close();
    }
}
