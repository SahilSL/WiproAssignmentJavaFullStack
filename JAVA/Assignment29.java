package com.wipro.practice;
import java.util.*;

/*
 Read the Register Number and Mobile Number of a student. 
 If the Register Number does not contain exactly 9 characters or if the Mobile Number does not contain exactly 10 characters, 
 throw an IllegalArgumentException. If the Mobile Number contains any character other than a digit, raise a NumberFormatException. 
 If the Register Number contains any character other than digits and alphabets, throw a NoSuchElementException. 
 If they are valid, print the message ‘valid’ else ‘invalid’
 */

public class Assignment29 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Register Number: ");
        String regNo = sc.nextLine();

        System.out.print("Enter Mobile Number: ");
        String mobile = sc.nextLine();

        try {
            //  register number length
            if (regNo.length() != 9) {
                throw new IllegalArgumentException();
            }

            //  mobile number length
            if (mobile.length() != 10) {
                throw new IllegalArgumentException();
            }

            //  mobile number has only digits
            for (int i = 0; i < mobile.length(); i++) {
                if (!Character.isDigit(mobile.charAt(i))) {
                    throw new NumberFormatException();
                }
            }

            // check register number has only letters and digits
            for (int i = 0; i < regNo.length(); i++) {
                char ch = regNo.charAt(i);
                if (!Character.isLetterOrDigit(ch)) {
                    throw new NoSuchElementException();
                }
            }

            System.out.println("valid");

        } catch (Exception e) {
            System.out.println("invalid");
        }

        sc.close();
    }
	

}

/*
Enter Register Number: ACB123465
Enter Mobile Number: 5847966332
valid
 */
