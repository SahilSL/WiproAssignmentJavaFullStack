package com.wipro.practice;
/*(Rethrowing Exceptions) Write a program that illustrates rethrowing an exception. 
Define methods someMethod and someMethod2. Method someMethod2 should initially 
throw an exception. Method someMethod should call someMethod2, catch the exception 
and rethrow it. Call someMethod from method main, and catch the rethrown exception. 
Print the stack trace of this exception.*/

public class Assignment42 {

    // Method  hrows an exception
    static void method2() throws Exception {
        throw new Exception("Something went wrong in method2");
    }

    // Method calls method2 and again throws the exception
    static void method1() throws Exception {
        try {
            method2();
        } catch (Exception e) {
            System.out.println("Caught in method1: " + e.getMessage());
            throw e; // trow
        }
    }

    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("Caught in main");
            e.printStackTrace(); // Show the full error trace
        }
    }
}


/*Caught in method1: Something went wrong in method2
Caught in main
java.lang.Exception: Something went wrong in method2
	at com.wipro.practice.Assignment42.method2(Assignment42.java:12)
	at com.wipro.practice.Assignment42.method1(Assignment42.java:18)
	at com.wipro.practice.Assignment42.main(Assignment42.java:28)
*/