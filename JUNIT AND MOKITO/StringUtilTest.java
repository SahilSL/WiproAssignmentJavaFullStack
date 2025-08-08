package com.example.junit;
/*Test a method that reverses a string. Include test cases for null input, empty string, and a regular string.*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringUtilTest {

    @Test
    public void testReverseRegularString() {
        assertEquals("olleh", StringUtil.reverse("hello"));
        assertEquals("avaJ", StringUtil.reverse("Java"));
    }

    @Test
    public void testReverseEmptyString() {
        assertEquals("", StringUtil.reverse(""));
    }

    @Test
    public void testReverseNullStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtil.reverse(null);
        });
    }
}
