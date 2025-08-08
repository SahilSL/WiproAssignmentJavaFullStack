package com.example.junit;
/*Test a method that reverses a string. Include test cases for null input, empty string, and a regular string.*/
public class StringUtil {
    public static String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        return new StringBuilder(input).reverse().toString();
    }
}
