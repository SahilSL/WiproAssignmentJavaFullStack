package com.wipro.springassignment2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");
        Account acc = (Account) context.getBean("account");
        acc.displayAccountDetails();
        ((ClassPathXmlApplicationContext) context).close();
    }
}
