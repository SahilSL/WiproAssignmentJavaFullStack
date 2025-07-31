package com.wipro.practice;

/*
 Write a Java program to create an abstract class Vehicle with abstract methods startEngine() and stopEngine(). Create subclasses Car and Motorcycle that extend the Vehicle class and implement the respective methods to start and stop the engines for each vehicle type.
 */

//Abstract class
abstract class Vehicle1 {
 // Abstract methods (no body)
 abstract void startEngine();
 abstract void stopEngine();
}

//Car
class Car1 extends Vehicle1 {
 @Override
 void startEngine() {
     System.out.println("Car engine started.");
 }

 @Override
 void stopEngine() {
     System.out.println("Car engine stopped.");
 }
}

//Motorcycle
class Motorcycle extends Vehicle1 {
 @Override
 void startEngine() {
     System.out.println("Motorcycle engine started.");
 }

 @Override
 void stopEngine() {
     System.out.println("Motorcycle engine stopped.");
 }
}

public class Assignment20 {
	 public static void main(String[] args) {
		 Car1 myCar = new Car1();
	        Motorcycle myBike = new Motorcycle();

	     	        System.out.println("Car:");
	        myCar.startEngine();
	        myCar.stopEngine();

	        System.out.println();

	     	        System.out.println("Motorcycle:");
	        myBike.startEngine();
	        myBike.stopEngine();
	    }

}


/*Car:
Car engine started.
Car engine stopped.

Motorcycle:
Motorcycle engine started.
Motorcycle engine stopped.
*/