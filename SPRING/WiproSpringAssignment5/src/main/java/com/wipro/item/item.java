package com.wipro.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class item {
    private int id;
    private String name;
    private double price;

    @Autowired  
    private category category;

    public item() {
        this.id = 1;
        this.name = "Gaming Laptop";
        this.price = 56000.00;
    }

    public void displayDetails() {
        System.out.println("Item ID: " + id);
        System.out.println("Item Name: " + name);
        System.out.println("Item Price: " + price);
        System.out.println("Category ID: " + category.getCategoryId());
        System.out.println("Category Name: " + category.getCategoryName());
    }
}
