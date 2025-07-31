package com.wipro.practice;

/*Custom Sorting with Comparator
Problem:
You are given a list of Employee objects with attributes: id, name, and salary.
Store them in a List<Employee>.
Sort by salary in descending order using Comparator.
Then sort by name alphabetically using a lambda expression.
*/

import java.util.*;

class EMPY {
 int id;
 String name;
 double salary;

 // Constructor
 EMPY(int id, String name, double salary) {
     this.id = id;
     this.name = name;
     this.salary = salary;
 }
}

public class Assignment44 {
 public static void main(String[] args) {
     ArrayList<EMPY> employees = new ArrayList<>();
     employees.add(new EMPY(101, "Ravi", 40000));
     employees.add(new EMPY(102, "Asha", 60000));
     employees.add(new EMPY(103, "Kiran", 50000));

     employees.sort((a, b) -> Double.compare(b.salary, a.salary));

     System.out.println("Sorted by Salary (High to Low):");
     for (EMPY emp : employees) {
         System.out.println(emp.id + " - " + emp.name + " - " + emp.salary);
     }

     employees.sort((a, b) -> a.name.compareTo(b.name));

     System.out.println("\nSorted by Name (A to Z):");
     for (EMPY emp : employees) {
         System.out.println(emp.id + " - " + emp.name + " - " + emp.salary);
     }
 }
}
/*Sorted by Salary (High to Low):
102 - Asha - 60000.0
103 - Kiran - 50000.0
101 - Ravi - 40000.0

Sorted by Name (A to Z):
102 - Asha - 60000.0
103 - Kiran - 50000.0
101 - Ravi - 40000.0
*/
