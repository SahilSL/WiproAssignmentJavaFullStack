package com.wipro.practice;

/*
 Write a Java program to create an abstract class Person with abstract methods eat() and exercise(). Create subclasses Athlete and LazyPerson that extend the Person class and implement the respective methods to describe how each person eats and exercises. 
 */

abstract class Person {
 // Abstract methods (no body)
 abstract void eat();
 abstract void exercise();
}

//Athlete
class Athlete extends Person {
 @Override
 void eat() {
     System.out.println("Athlete eats a healthy diet with lots of protein.");
 }

 @Override
 void exercise() {
     System.out.println("Athlete exercises every day with intense workouts.");
 }
}

//LazyPerson
class LazyPerson extends Person {
 @Override
 void eat() {
     System.out.println("Lazy person eats junk food while watching TV.");
 }

 @Override
 void exercise() {
     System.out.println("Lazy person avoids exercise and prefers to sleep.");
 }
}

public class Assignment21 {
	public static void main(String[] args) {
        Person athlete = new Athlete();
        Person lazy = new LazyPerson();

        System.out.println("Athlete:");
        athlete.eat();
        athlete.exercise();

        System.out.println();

        System.out.println("Lazy Person:");
        lazy.eat();
        lazy.exercise();
    }
}


/*Athlete:
Athlete eats a healthy diet with lots of protein.
Athlete exercises every day with intense workouts.

Lazy Person:
Lazy person eats junk food while watching TV.
Lazy person avoids exercise and prefers to sleep.
*/