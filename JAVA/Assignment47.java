package com.wipro.practice;

/*Create a custom checked exception class InvalidSalaryException that extends Exception.
Create a class EmployeeService with the following methods:

validateSalary(double salary) → throws InvalidSalaryException if salary is < 0
processSalary(Employee emp) → calls validateSalary()
startProcess(Employee emp) → calls processSalary()

The main method should:
Create an Employee object with negative salary
Call startProcess()
Catch and handle InvalidSalaryException using try-catch in main()*/

//Custom checked exception
class InvalidSalaryException extends Exception {
 public InvalidSalaryException(String message) {
     super(message);
 }
}

class Employeec {
 int id;
 String name;
 double salary;

 public Employeec(int id, String name, double salary) {
     this.id = id;
     this.name = name;
     this.salary = salary;
 }
}

//Service class to handle salary operations
class EmployeeService {

 public void validateSalary(double salary) throws InvalidSalaryException {
     if (salary < 0) {
         throw new InvalidSalaryException("Salary cannot be negative!");
     }
 }

 public void processSalary(Employeec emp) throws InvalidSalaryException {
     validateSalary(emp.salary);
     System.out.println("✅ Salary processed for: " + emp.name);
 }

 public void startProcess(Employeec emp) throws InvalidSalaryException {
     processSalary(emp);
 }
}

public class Assignment47 {
 public static void main(String[] args) {
     // error:  negative salary
	 Employeec emp = new Employeec(101, "Rahul", -5000);
     EmployeeService service = new EmployeeService();

     try {
         service.startProcess(emp);
     } catch (InvalidSalaryException e) {
         System.out.println("Error: " + e.getMessage());
     }
 }
}

// Error: Salary cannot be negative!
