package com.wipro.practice;
/*
 Create a class called Vehicle. Create subclasses like Truck, Bus, Car etc. Add common methods 
in the base class and specific methods in the corresponding class. Create a class called Road 
and create objects for the Truck, Car, Bus etc and display the appropriate message. 

In the Vehicle class constructor initialize few variables like color, no of 
wheels, model etc. Give appropriate values for these variables from the invoking subclass.
 */

class Vehicle {
    String color;
    int wheels;
    String model;

    public Vehicle(String color, int wheels, String model) {
        this.color = color;
        this.wheels = wheels;
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Color: " + color);
        System.out.println("Wheels: " + wheels);
        System.out.println("Model: " + model);
    }
}

// Truck
class Truck extends Vehicle {
    public Truck(String color, int wheels, String model) {
        super(color, wheels, model);
    }

    public void loadGoods() {
        System.out.println("Truck is loading goods.");
    }
}

//Bus
class Bus extends Vehicle {
    public Bus(String color, int wheels, String model) {
        super(color, wheels, model);
    }

    public void carryPassengers() {
        System.out.println("Bus is carrying passengers.");
    }
}

// Car
class Car extends Vehicle {
    public Car(String color, int wheels, String model) {
        super(color, wheels, model);
    }

    public void playMusic() {
        System.out.println("Car is playing music.");
    }
}

public class Assignment17 {
	public static void main(String[] args) {
        Truck truck = new Truck("Red", 6, "Tata Heavy");
        System.out.println("Truck Info:");
        truck.displayInfo();
        truck.loadGoods();
        System.out.println();

        Bus bus = new Bus("Yellow", 4, "Volvo");
        System.out.println("Bus Info:");
        bus.displayInfo();
        bus.carryPassengers();
        System.out.println();
        
        Car car = new Car("Black", 4, "Honda City");
        System.out.println("Car Info:");
        car.displayInfo();
        car.playMusic();
    }

}

/*Truck Info:
Color: Red
Wheels: 6
Model: Tata Heavy
Truck is loading goods.

Bus Info:
Color: Yellow
Wheels: 4
Model: Volvo
Bus is carrying passengers.

Car Info:
Color: Black
Wheels: 4
Model: Honda City
Car is playing music.
*/
