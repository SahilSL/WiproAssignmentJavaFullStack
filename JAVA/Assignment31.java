package com.wipro.practice;
import java.util.*;


public class Assignment31 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // InputMismatchException 
        try {
            System.out.print("Enter a number: ");
            int num = sc.nextInt(); // if you enter text then --> this will exception
            System.out.println("You entered: " + num);
        } catch (InputMismatchException e) {
            System.out.println("Oops! Please enter a valid number.");
        }

        sc.nextLine();

        // StringIndexOutOfBoundsException 
        try {
            String word = "Java";
            System.out.print("Enter index to access in word 'Java': ");
            int index = sc.nextInt(); // if index is wrong then -----> this will throw exception
            System.out.println("Letter at index " + index + " is: " + word.charAt(index));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Oops! Index is out of range.");
        }

        System.out.println("Program finished.");
        sc.close();
    }

}

/*
Enter a number: fgf453
Oops! Please enter a valid number.
Enter index to access in word 'Java': dfs
Exception in thread "main" java.util.InputMismatchException
	at java.base/java.util.Scanner.throwFor(Scanner.java:947)
	at java.base/java.util.Scanner.next(Scanner.java:1602)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2267)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2221)
	at com.wipro.practice.Assignment31.main(Assignment31.java:24)



Enter a number: 58
You entered: 58
Enter index to access in word 'Java': 2
Letter at index 2 is: v
Program finished.


 */
