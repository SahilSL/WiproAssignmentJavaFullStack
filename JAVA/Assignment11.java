package com.wipro.practice;

/*
 * Create a class called Calculator which has 4 different methods add, diff, mul and div which 
accepts two numbers as parameters. Create an object to access these methods and invoke 
these methods with two numbers and display the result in the corresponding methods.
 * */

class Calculator {

    void add(int a, int b) {
        int result = a + b;
        System.out.println("Addition: " + result);
    }

    void diff(int a, int b) {
        int result = a - b;
        System.out.println("Subtraction: " + result);
    }

    void mul(int a, int b) {
        int result = a * b;
        System.out.println("Multiplication: " + result);
    }

    void div(int a, int b) {
        if (b != 0) {
            double result = (double) a / b;
            System.out.println("Division: " + result);
        } else {
            System.out.println("Division by zero is not allowed.");
        }
    }
}

public class Assignment11 {
	 public static void main(String[] args) {
	        Calculator calc = new Calculator();

	        int num1 = 20;
	        int num2 = 10;

	        calc.add(num1, num2);
	        calc.diff(num1, num2);
	        calc.mul(num1, num2);
	        calc.div(num1, num2);
	    }

}



/* 
Addition: 15
Subtraction: -5
Multiplication: 50
Division: 0.5
*/
