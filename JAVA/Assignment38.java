package com.wipro.practice;

import java.io.*;
import java.util.Scanner;

// Employee class with Serializable
class Employee123 implements Serializable {
    int emp_id;
    String emp_name;

    // transient -> will not be saved during serialization
    transient double emp_sal;

    // Constructor
    public Employee123(int emp_id, String emp_name, double emp_sal) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_sal = emp_sal;
    }
}

public class Assignment38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        Employee123 emp = new Employee123(id, name, salary);

        try {
            FileOutputStream fileOut = new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emp);
            out.close();
            fileOut.close();
            System.out.println("\nEmployee object serialized successfully to employee.ser");
        } catch (IOException e) {
            System.out.println("❌ Serialization Error: " + e.getMessage());
        }
        
        try {
            FileInputStream fileIn = new FileInputStream("employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Employee123 empDeserialized = (Employee123) in.readObject();
            in.close();
            fileIn.close();

            System.out.println("\n Deserialized Employee Details:");
            System.out.println("Employee ID   : " + empDeserialized.emp_id);
            System.out.println("Employee Name : " + empDeserialized.emp_name);
            System.out.println("Employee Salary (transient): " + empDeserialized.emp_sal); // 0.0
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization Error: " + e.getMessage());
        }

        scanner.close();
    } 
}


/**
 Enter Employee ID: 105
Enter Employee Name: sahil
Enter Employee Salary: 452604

Employee object serialized successfully!

Deserialized Employee Details:
Employee ID   : 105
Employee Name : sahil
Employee Salary (transient): 0.0 
 */
 