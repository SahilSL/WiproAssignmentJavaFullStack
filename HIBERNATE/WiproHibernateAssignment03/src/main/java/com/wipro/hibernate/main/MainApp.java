package com.wipro.hibernate.main;

import com.wipro.hibernate03.entity.Author;
import com.wipro.hibernate03.entity.Book;
import com.wipro.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Book with Authors\n2. View Books\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 : addBook();
                case 2 : viewBooks();
                case 3 : System.exit(0);
                default : System.out.println("Invalid choice");
            }
        }
    }

    static void addBook() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        Book book = new Book(title);

        System.out.print("How many authors? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter Author Name: ");
            String name = scanner.nextLine();
            Author author = new Author(name);
            book.addAuthor(author);
        }

        session.save(book);
        tx.commit();
        session.close();
        System.out.println("Book and Authors saved successfully.");
    }

    static void viewBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> books = session.createQuery("from Book", Book.class).list();
        for (Book b : books) {
            System.out.println(b);
            for (Author a : b.getAuthors()) {
                System.out.println("   - " + a);
            }
        }
        session.close();
    }
}
