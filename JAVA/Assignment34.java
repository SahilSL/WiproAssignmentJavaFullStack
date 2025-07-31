package com.wipro.practice;
import java.util.Scanner;

/*
 Create a class by name Employee with members   Employee ID, Name and year of birth. The Employee ID is a string that contains the ID in the format year-designation-number. The year is represented with the last two digits. The designation is a single letter code - 'F' for faculty and 'S' for staff.
The number is a 3 digit number.(Example:81-F-112     79-S-254) 
 */

class Employee {
    String empId;
    String name;
    int yearOfBirth;

    Employee(String empId, String name, int yearOfBirth) {
        this.empId = empId;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    void displayDetails() {
        System.out.println("Employee ID     : " + empId);
        System.out.println("Name            : " + name);
        System.out.println("Year of Birth   : " + yearOfBirth);
    }
}

public class Assignment34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID (e.g., 81-F-112): ");
        String empId = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Year of Birth: ");
        int year = 0;

        try {
            year = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid year format!");
            sc.close();
            return;
        }

        Employee emp = new Employee(empId, name, year);
        System.out.println("\n--- Employee Details ---");
        emp.displayDetails();
        sc.close();
    }
}

/*
 Enter Employee ID (e.g., 81-F-112): 79-S-254
Enter Name: Sahil
Enter Year of Birth: 2002

--- Employee Details ---
Employee ID     : 79-S-254
Name            : Sahil
Year of Birth   : 2002
*/


 