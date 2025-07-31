package com.wipro.practice;
import java.util.Scanner;
/*
 Write a program that prompts user for the mark (between 0-100 in int) of 3 students; computes the average (in double); and prints the result rounded to 2 decimal places. Your program needs to perform input validation. For examples,

Enter the mark (0-100) for student 1: 56
Enter the mark (0-100) for student 2: 101
Invalid input, try again...
Enter the mark (0-100) for student 2: -1
Invalid input, try again...
Enter the mark (0-100) for student 2: 99
Enter the mark (0-100) for student 3: 45
The average is: 66.67 
 */

public class Assignment16 {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int marks;
        int total = 0;
        int count = 0;

        while (count < 3) {
            System.out.print("Enter the mark (0-100) for student " + (count + 1) + ": ");
            marks = input.nextInt();

            if (marks >= 0 && marks <= 100) {
                total += marks;
                count++;
            } else {
                System.out.println("Invalid input, try again...");
            }
        }

        double average = total / 3.0;

        // rounded to 2 decimal places
        System.out.printf("The average is: %.2f\n", average);
    }

}

/*Enter the mark (0-100) for student 1: 86
Enter the mark (0-100) for student 2: 84
Enter the mark (0-100) for student 3: 89
The average is: 86.33
*/
