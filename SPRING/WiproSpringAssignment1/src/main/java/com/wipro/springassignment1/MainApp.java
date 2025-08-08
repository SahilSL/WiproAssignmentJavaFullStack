package com.wipro.springassignment1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CredentialReader reader = context.getBean(CredentialReader.class);
        reader.displayCredentials();
        context.close();
    }
}
