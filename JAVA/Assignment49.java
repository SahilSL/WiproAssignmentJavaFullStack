package com.wipro.practice;
import java.util.Optional;
/*
 Create a class Employee with optional fields for email and department. Use Optional to:
Safely access employee details.
Provide default values when data is absent.
Throw custom exceptions if required fields are missing. 
 */
//Custom Exception for missing required field
class MissingFieldException extends Exception {
 public MissingFieldException(String message) {
     super(message);
 }
}

class Employees {
 private int id;
 private String name;
 private Optional<String> email;        // Optional field
 private Optional<String> department;   

 public Employees(int id, String name, String email, String department) {
     this.id = id;
     this.name = name;
     this.email = Optional.ofNullable(email);              // Wrap in Optional
     this.department = Optional.ofNullable(department);
 }

 public void showDetails() {
     System.out.println("ID : " + id);
     System.out.println("Name : " + name);
     System.out.println("Email : " + email.orElse("Not Provided"));
     System.out.println("Department : " + department.orElse("General"));
 }

 // Validate email and department - throw exception if missing
 public void validateDetails() throws MissingFieldException {
     if (!email.isPresent()) {
         throw new MissingFieldException("Email is required.");
     }
     if (!department.isPresent()) {
         throw new MissingFieldException("Department is required.");
     }
 }
}

public class Assignment49 {
 public static void main(String[] args) {
	 Employees emp1 = new Employees(101, "Sita", "sita@mail.com", "HR");
	 Employees emp2 = new Employees(102, "Ram", null, null);

     System.out.println("\n--- Employee 1 ---");
     emp1.showDetails();
     try {
         emp1.validateDetails();
     } catch (MissingFieldException e) {
         System.out.println("Error: " + e.getMessage());
     }

     System.out.println("\n--- Employee 2 ---");
     emp2.showDetails();
     try {
         emp2.validateDetails();
     } catch (MissingFieldException e) {
         System.out.println("Error: " + e.getMessage());
     }
 }
}

/*
--- Employee 1 ---
ID        : 101
Name      : Sita
Email     : sita@mail.com
Department: HR

--- Employee 2 ---
ID        : 102
Name      : Ram
Email     : Not Provided
Department: General
Error: Email is required.
*/