package com.wipro.shopping;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ShoppingService shoppingService = context.getBean("shoppingService", ShoppingService.class);

        shoppingService.addToCart("Laptop");
        shoppingService.makePayment(50000.00);
        shoppingService.placeOrder();

        context.close();
    }
}

/*[LOG] Method execution started...
Added item to cart: Laptop
[LOG] Execution time: 13 ms
[LOG] Method executed successfully.
[LOG] Method execution started...
Payment of Rs. 50000.0 successful.
[LOG] Execution time: 4 ms
[LOG] Method executed successfully.
[LOG] Method execution started...
Order placed successfully!
[LOG] Execution time: 0 ms
[LOG] Method executed successfully.
*/