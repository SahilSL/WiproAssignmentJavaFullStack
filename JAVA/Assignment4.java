package com.wipro.practice;

import java.util.Scanner;


/*
 * Take name, 
 * roll number and 
 * field of interest from user and 
 * print in the format below :
Hey, my name is --- and my roll number is ----. My field of interest are ---.
*/


public class Assignment4 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your roll number: ");
        String rollNumber = sc.nextLine();

        System.out.print("Enter your field of interest: ");
        String interest = sc.nextLine();

        System.out.println("Hey, my name is " + name + " and my roll number is " + rollNumber + ". My field of interest are " + interest + ".");
    }

}


// Enter your name: Sahil
//Enter your roll number: 101
//Enter your field of interest: Computer Science
//Hey, my name is Sahil and my roll number is 101. My field of interest are Computer Science.
