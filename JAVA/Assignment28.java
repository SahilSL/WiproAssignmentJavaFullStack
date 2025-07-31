package com.wipro.practice;
/*
 
Write the following methods that return a lambda expression performing a specified action:

PerformOperation isOdd(): The lambda expression must return true  if a number is odd or false  if it is even.
PerformOperation isPrime(): The lambda expression must return  true if a number is prime or false  if it is composite.
PerformOperation isPalindrome(): The lambda expression must return true   if a number is a palindrome or false  if it is not.
 */

interface PerformOperation {
    boolean check(int number);
}

public class Assignment28 {
    public static PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return n -> {
            if (n < 2) return false;
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return n -> {
            int original = n;
            int reverse = 0;
            while (n > 0) {
                int digit = n % 10;
                reverse = reverse * 10 + digit;
                n = n / 10;
            }
            return original == reverse;
        };
    }

    public static void main(String[] args) {
        int number = 121;

        PerformOperation oddCheck = isOdd();
        PerformOperation primeCheck = isPrime();
        PerformOperation palindromeCheck = isPalindrome();

        System.out.println("Number: " + number);
        System.out.println("Is Odd? " + oddCheck.check(number));
        System.out.println("Is Prime? " + primeCheck.check(number));
        System.out.println("Is Palindrome? " + palindromeCheck.check(number));
    }
}


/*Number: 121
Is Odd? true
Is Prime? false
Is Palindrome? true
*/