package com.wipro.practice;

/*
 * Create a class called shape with the following methods
1. area 	2. perimeter
Overload the area and perimeter method to calculate for both square and rectangle.
Create a main class and invoke the area method to calculate the area of the square and 
rectangle. Also invoke the perimeter method to calculate the perimeter of the square 
and rectangle.

 * */

class Shape {

    // square
    public void area(int side) {
        int result = side * side;
        System.out.println("Area of Square: " + result);
    }

    // rectangle
    public void area(int length, int breadth) {
        int result = length * breadth;
        System.out.println("Area of Rectangle: " + result);
    }

    // Perimeter of square
    public void perimeter(int side) {
        int result = 4 * side;
        System.out.println("Perimeter of Square: " + result);
    }

    // Perimeter of rectangle
    public void perimeter(int length, int breadth) {
        int result = 2 * (length + breadth);
        System.out.println("Perimeter of Rectangle: " + result);
    }
}

public class Assignment14 {
	public static void main(String[] args) {
        Shape shape = new Shape();

        shape.area(5);
        shape.perimeter(5);

        shape.area(4, 6);
        shape.perimeter(4, 6);
    }

}

/*Area of Square: 25
Perimeter of Square: 20
Area of Rectangle: 24
Perimeter of Rectangle: 20
*/