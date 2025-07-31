package com.wipro.practice;

/*
 Write a program to add 8 to the number 2345 
 and then divide  it by 3. 
 Now, the modulus of the quotient is taken with 5 and 
 then multiply the resultant value by 5. 
 Display the final result. 
  */

public class Assignment1 {
	public static void main(String[] args) {
        int num = 2345;
        
        int n1 = num + 8;      
        int n2 = n1 / 3;       
        int n3 = n2 % 5;       
        int n5 = n3 * 5;       

        System.out.println("Final result is :: " + n5);
    }
}

/*
Output---->
Final result is :: 20
*/
