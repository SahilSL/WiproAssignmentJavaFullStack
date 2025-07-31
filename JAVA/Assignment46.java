package com.wipro.practice;
import java.util.*;

/*Create a generic class Repository<T, ID> with the following methods:
void save(ID id, T entity)
T findById(ID id)
List<T> findAll()
void deleteById(ID id)

Create an Employee class with fields:
int id
String name
double salary

Instantiate Repository<Employee, Integer> in main() and:
Add 3 employees
Retrieve and print all employees
Retrieve a specific employee by ID
Delete an employee and print remaining data
*/


//Generic class to store and manage data
//Generic Repository class
class Repository<T, ID> {
 private Map<ID, T> data = new HashMap<>();

 public void save(ID id, T value) {
     data.put(id, value);
 }

 public T findById(ID id) {
     return data.get(id);
 }

 public List<T> findAll() {
     return new ArrayList<>(data.values());
 }

 public void deleteById(ID id) {
     data.remove(id);
 }
}

class Emps {
 int id;
 String name;
 double salary;

 Emps(int id, String name, double salary) {
     this.id = id;
     this.name = name;
     this.salary = salary;
 }

 public String toString() {
     return name;
 }
}

public class Assignment46 {
    public static void main(String[] args) {
        Repository<Emps, Integer> repo = new Repository<>();
        repo.save(1, new Emps(1, "Ravi", 30000));
        repo.save(2, new Emps(2, "Sneha", 35000));
        repo.save(3, new Emps(3, "Aman", 32000));

        System.out.println("All employees:");
        for (Emps e : repo.findAll()) {
            System.out.println(e);
        }

        System.out.println("\nEmployee with ID 2:");
        System.out.println(repo.findById(2));

        // Delete 
        repo.deleteById(1);
        System.out.println("\nAfter deleting ID 1:");
        for (Emps e : repo.findAll()) {
            System.out.println(e);
        }
    }
}

/*All employees:
Ravi
Sneha
Aman

Employee with ID 2:
Sneha

After deleting ID 1:
Sneha
Aman*/