package com.wipro.practice;
import java.util.Scanner;

/*
 Write a interface method minimum3 that returns the smallest of three floating-point numbers. Use the Math.min method to implement minimum3. Incorporate the method into an application that reads three values from the user, determines the smallest value and displays the result. Use method references syntax.
 */

//interface
interface Minimum3 {
 double findMin(double a, double b, double c);
}

public class Assignment30 {

 public static double getMinimum(double a, double b, double c) {
     return Math.min(a, Math.min(b, c));
 }


 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     // floating-point numbers
     System.out.print("Enter first number: ");
     double num1 = sc.nextDouble();

     System.out.print("Enter second number: ");
     double num2 = sc.nextDouble();

     System.out.print("Enter third number: ");
     double num3 = sc.nextDouble();


     Minimum3 minFinder = Assignment30::getMinimum;
     double result = minFinder.findMin(num1, num2, num3);
     System.out.println("Smallest number is: " + result);
 }
}

/*
Enter first number: 58
Enter second number: 23
Enter third number: 85
Smallest number is: 23.0

*/