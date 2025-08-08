package com.wipro.purchase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Purchase purchase = (Purchase) context.getBean("purchase");
        purchase.displayPurchase();
    }
}

/*
Default Product constructor called.
Purchase constructor (Product autowired) called.
Purchase ID: 201
Purchase Date: 2025-08-06
Product ID: 101
Product Name: Laptop
Price: 55000.0
*/