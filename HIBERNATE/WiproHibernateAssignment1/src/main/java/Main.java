

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import wipro.hibernateassignment1.model.Item;
import wipro.hibernateassignment1.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n-------------------------------");
            System.out.println("Hibernate Item CRUD");
            System.out.println("-------------------------------");
            System.out.println("1. Add");
            System.out.println("2. View All");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Get by ID");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: addItem(scanner); break;
                case 2: viewAllItems(); break;
                case 3: updateItem(scanner); break;
                case 4: deleteItem(scanner); break;
                case 5: getItemById(scanner); break;
                case 0: 
                    System.out.println("Exiting...");
                    HibernateUtil.getSessionFactory().close();
                    break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void addItem(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        Item item = new Item(name, price);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(item);
        tx.commit();
        session.close();

        System.out.println("Item added.");
    }

    private static void viewAllItems() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Item> items = session.createQuery("from Item", Item.class).list();
        items.forEach(System.out::println);
        session.close();
    }

    private static void updateItem(Scanner scanner) {
        System.out.print("Enter item ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        Session session = HibernateUtil.getSessionFactory().openSession();
        Item item = session.get(Item.class, id);
        if (item != null) {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();  // ✅ Accepts full name with spaces

            System.out.print("Enter new price: ");
            double newPrice = 0;
            try {
                newPrice = Double.parseDouble(scanner.nextLine()); // ✅ safely parse string to double
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format!");
                session.close();
                return;
            }

            item.setName(newName);
            item.setPrice(newPrice);

            Transaction tx = session.beginTransaction();
            session.update(item);
            tx.commit();
            System.out.println("Item updated.");
        } else {
            System.out.println("Item not found.");
        }
        session.close();
    }


    private static void deleteItem(Scanner scanner) {
        System.out.print("Enter item ID to delete: ");
        int id = scanner.nextInt();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Item item = session.get(Item.class, id);
        if (item != null) {
            Transaction tx = session.beginTransaction();
            session.delete(item);
            tx.commit();
            System.out.println("Item deleted.");
        } else {
            System.out.println("Item not found.");
        }
        session.close();
    }

    private static void getItemById(Scanner scanner) {
        System.out.print("Enter item ID: ");
        int id = scanner.nextInt();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Item item = session.get(Item.class, id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Item not found.");
        }
        session.close();
    }
}
