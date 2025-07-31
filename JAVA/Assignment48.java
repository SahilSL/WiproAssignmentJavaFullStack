package com.wipro.practice;

/*Create a functional interface EmployeeProcessor with a method:
void process(Employee e);
Use it to print:
Name and salary of employees
Bonus calculation (10% of salary)*/

import java.util.*;

//Functional interface
interface EmployeeProcessor {
 void process(Employe e);
}

class Employe {
 String name;
 double salary;

 Employe(String name, double salary) {
     this.name = name;
     this.salary = salary;
 }
}

public class Assignment48 {
 public static void main(String[] args) {
     List<Employe> employees = new ArrayList<>();
     employees.add(new Employe("Amit", 30000));
     employees.add(new Employe("Sita", 40000));
     employees.add(new Employe("Raj", 50000));

     EmployeeProcessor printDetails = (e) -> {
         System.out.println("Name: " + e.name);
         System.out.println("Salary: " + e.salary);
     };

     EmployeeProcessor printBonus = (e) -> {
         double bonus = e.salary * 0.10;
         System.out.println("Bonus: " + bonus);
         System.out.println();
     };

     for (Employe emp : employees) {
         printDetails.process(emp);
         printBonus.process(emp);
     }
 }
}

/*Name: Amit
Salary: 30000.0
Bonus: 3000.0

Name: Sita
Salary: 40000.0
Bonus: 4000.0

Name: Raj
Salary: 50000.0
Bonus: 5000.0

*/