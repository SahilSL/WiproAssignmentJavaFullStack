package com.wipro.springassignment1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CredentialReader {

    @Value("${URL}")
    private String url;

    @Value("${usernames}")
    private String usernames;

    @Value("${password}")
    private String password;

    public void displayCredentials() {
        System.out.println("URL: " + url);
        System.out.println("Username: " + usernames);
        System.out.println("Password: " + password);
    }
}

