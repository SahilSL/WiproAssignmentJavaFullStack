package com.example.junit;
/*6.Scenario: You have a method divide(int a, int b) which throws IllegalArgumentException if b == 0.
Use assertThrows to test this.*/
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


public class AssertthrowTest {
    @Test
    public void testDivideByZeroThrowsException() {
        Asserthrows mathUtils = new Asserthrows();

        // check if exception is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            mathUtils.divide(10, 0);
        });
    }}
//pass