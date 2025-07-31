package com.wipro.practice;
import java.util.Scanner;

/*
A student will not be allowed to sit in exam if his/her attendance is less than 70%.
Take following input from user
	Number of classes held
	Number of classes attended.
	And print percentage of class attended
Is student is allowed to sit in exam or not.
 */


public class Assignment7 {
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
            System.out.println(" NOT Allowed");
        }
    }
}
/*
 * Enter number of classes held: 5
Enter number of classes attended: 2
Attendance percent: 40.0%
 NOT Allowed

*/
 