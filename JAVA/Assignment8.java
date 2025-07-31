package com.wipro.practice;
import java.util.Scanner;

/*
 * 
 * Modify the above question to allow student to sit if he/she has medical cause. 
 * Ask user if he/she has medical cause or not ( 'Y' or 'N' ) and 
 * print accordingly.
 * 
 * */

public class Assignment8 {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of classes held: ");
        int classesHeld = input.nextInt();

        System.out.print("Enter number of classes attended: ");
        int classesAttended = input.nextInt();

        double percent = (classesAttended * 100.0) / classesHeld;

        System.out.println("Attendance percent: " + percent + "%");

        if (percent >= 70) {
            System.out.println("Allowed");
        } else {
            System.out.print("Do you have a medical cause? (Yes = Y / No = N): ");
            char medicalCause = input.next().charAt(0);

            if (medicalCause == 'Y' || medicalCause == 'y') {
                System.out.println("Medical Cause :: Allowed");
            } else {
                System.out.println("NOT Allowed");
            }
        }
    }

}

/*Enter number of classes held: 10
Enter number of classes attended: 3
Attendance percent: 30.0%
Do you have a medical cause? (Yes = Y / No = N): Y
Medical Cause :: Allowed
*/