package com.example.junit;
/*Test a login validation method
Validate correct username/password.
Test for empty, null, or invalid inputs.
*/
public class LoginUtil {
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "pasword123";

    public static boolean validateLogin(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username or password cannot be null");
        }

        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }

        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }
}