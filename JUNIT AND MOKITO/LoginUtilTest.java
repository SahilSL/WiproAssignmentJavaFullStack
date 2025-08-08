package com.example.junit;
/*Test a login validation method
Validate correct username/password.
Test for empty, null, or invalid inputs.
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LoginUtilTest {

    @Test
    public void testValidLogin() {
        assertTrue(LoginUtil.validateLogin("admin", "password123"));
    }

    @Test
    public void testInvalidLogin() {
        assertFalse(LoginUtil.validateLogin("admin", "wrongpass"));
        assertFalse(LoginUtil.validateLogin("user", "password123"));
        assertFalse(LoginUtil.validateLogin("wronguser", "wrongpass"));
    }

    @Test
    public void testEmptyUsernameOrPassword() {
        assertFalse(LoginUtil.validateLogin("", "password123"));
        assertFalse(LoginUtil.validateLogin("admin", ""));
        assertFalse(LoginUtil.validateLogin("", ""));
    }

    @Test
    public void testNullUsernameOrPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            LoginUtil.validateLogin(null, "password123");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            LoginUtil.validateLogin("admin", null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            LoginUtil.validateLogin(null, null);
        });
    }
}