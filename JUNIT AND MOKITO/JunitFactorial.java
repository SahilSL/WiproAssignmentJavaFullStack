package com.example.junit;
/*Write a test class that checks if the method returns correct factorials for valid inputs and throws IllegalArgumentException for negative numbers.*/
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class JunitFactorial {


    @Test
    public void testValidFactorials() {
        assertEquals(1, FactorialJunit.factorial(0));
        assertEquals(1, FactorialJunit.factorial(1));
        assertEquals(2, FactorialJunit.factorial(2));
        assertEquals(6, FactorialJunit.factorial(3));
        assertEquals(24, FactorialJunit.factorial(4));
        assertEquals(120, FactorialJunit.factorial(5));
    }

    @Test
    public void testNegativeFactorialThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
        	FactorialJunit.factorial(-5);
        });
    }

}
