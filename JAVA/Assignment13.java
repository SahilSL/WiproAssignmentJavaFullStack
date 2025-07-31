package com.wipro.practice;
/*
 Create a class called Worker. Write classes DailyWorker and SalariedWorker that inherit from
Worker. Every worker has a name and a salaryrate. Write method Pay (int hours) to compute 
the week pay of every worker.  A Daily worker is paid on the basis of the number of days 
she/he works. The salaried worker gets paid the wage for 40 hours a week no matter what the
actual hours are.  Test this program to calculate the pay of workers.
 */

class Worker {
 String name;
 double salaryRate;

 public Worker(String name, double salaryRate) {
     this.name = name;
     this.salaryRate = salaryRate;
 }

 public double Pay(int hours) {
     return 0.0;
 }

 // Method - worker details
 public void displayPay(int hours) {
     System.out.println("Worker Name: " + name);
     System.out.println("Weekly Pay: ₹" + Pay(hours));
     System.out.println();
 }
}

//DailyWorker
class DailyWorker extends Worker {

 public DailyWorker(String name, double salaryRate) {
     super(name, salaryRate);
 }

 @Override
 public double Pay(int hours) {
     return salaryRate * hours;
 }
}

//SalariedWorker
class SalariedWorker extends Worker {

 public SalariedWorker(String name, double salaryRate) {
     super(name, salaryRate);
 }

 @Override
 public double Pay(int hours) {
     return salaryRate * 40;
 }
}

public class Assignment13 {
 public static void main(String[] args) {
     // Create DailyWorker and SalariedWorker
     DailyWorker dWorker = new DailyWorker("Ravi", 500);  // ₹500 per hour
     SalariedWorker sWorker = new SalariedWorker("Anita", 700); // ₹700 per hour

     // Test with different hours
     dWorker.displayPay(35);     // 35 hours worked
     sWorker.displayPay(35);     // Only paid for 40 hours
 }
}

/*Worker Name: Ravi
Weekly Pay: ₹17500.0

Worker Name: Anita
Weekly Pay: ₹28000.0

*/