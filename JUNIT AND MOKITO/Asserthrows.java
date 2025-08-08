package com.example.junit;
/*6.Scenario: You have a method divide(int a, int b) which throws IllegalArgumentException if b == 0.
Use assertThrows to test this.*/
public class Asserthrows {
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}
