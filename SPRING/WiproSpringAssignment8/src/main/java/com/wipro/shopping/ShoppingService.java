package com.wipro.shopping;

public class ShoppingService {

    public void addToCart(String item) {
        System.out.println("Added item to cart: " + item);
    }

    public void makePayment(double amount) {
        System.out.println("Payment of Rs. " + amount + " successful.");
    }

    public void placeOrder() {
        System.out.println("Order placed successfully!");
        // throw new RuntimeException("Payment gateway error!");
    }
}
