package com.wipro.practice;
import java.util.Scanner;

/*
 Write a program to read the employee details and validate the employee code.
 If the employee code is incorrect throw a user-defined exception"InvalidEmployeeCode" 
 else create the Employee object and display the details of the employee.
 */


//This is a Custom exception
class InvalidEmployeeCode extends Exception {
 public InvalidEmployeeCode(String message) {
     super(message);
 }
}

class Empees {
 String empCode;
 String name;
 int yearOfBirth;

 Empees(String empCode, String name, int yearOfBirth) {
     this.empCode = empCode;
     this.name = name;
     this.yearOfBirth = yearOfBirth;
 }

 void showDetails() {
     System.out.println("\n--- Employee Details ---");
     System.out.println("Code: " + empCode);
     System.out.println("Name: " + name);
     System.out.println("Year of Birth: " + yearOfBirth);
 }
}

public class Assignment35 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Employee Code: ");
            String code = sc.nextLine();

            // Simple validation: Check if '-' is present
            if (!code.contains("-")) {
                throw new InvalidEmployeeCode("Employee code must contain '-' (e.g. 25-SE-001)");
            }

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Year of Birth: ");
            int year = sc.nextInt();
            Empees emp = new Empees(code, name, year);
            emp.showDetails();

        } catch (InvalidEmployeeCode e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}

/*
 Enter Employee Code: 2168dsf5
Error: Employee code must contain '-' (e.g. 25-SE-001)


Enter Employee Code: 12-AB-1245
Enter Name: Sahil
Enter Year of Birth: 2002

--- Employee Details ---
Code: 12-AB-1245
Name: Sahil
Year of Birth: 2002
 */
 