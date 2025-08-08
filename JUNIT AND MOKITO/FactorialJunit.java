package com.example.junit;
/*Write a test class that checks if the method returns correct factorials for valid inputs and throws IllegalArgumentException for negative numbers.*/
public class FactorialJunit {
	public static long factorial(int n) {
	        if (n < 0) {
	            throw new IllegalArgumentException("Negative numbers not allowed");
	        }
	        long result = 1;
	        for (int i = 2; i <= n; i++) {
	            result *= i;
	        }
	        return result;
	    }
	}

