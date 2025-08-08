package com.wipro.item;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        item item = context.getBean(item.class);
        item.displayDetails();
    }
}


/*
Item ID: 1
Item Name: Gaming Laptop
Item Price: 56000.0
Category ID: 1001
Category Name: Electronics Category
*/
 