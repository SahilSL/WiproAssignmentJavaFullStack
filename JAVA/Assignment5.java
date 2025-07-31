package com.wipro.practice;
import java.util.Scanner;
/*
 A company decided to give bonus of 10% to employee 
 if his/her year of service is more than 6 years.
Ask user for their salary and year of service and 
print the net bonus amount.
*/
public class Assignment5 {
	 public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        
	        System.out.print("Enter your salary: ");
	        double salary = input.nextDouble();

	        
	        System.out.print("Enter your years of service: ");
	        int years = input.nextInt();

	        double bonus = 0;

	        
	        if (years > 6) {
	            bonus = salary * 0.10; 
	            System.out.println("Congo! You get a bonus of Rs." + bonus);
	        } else {
	            System.out.println("No bonus.");
	        }

	    }

}
/*
 * Enter your salary: 98000
Enter your years of service: 15
Congo! You get a bonus of Rs.9800.0
*/
 