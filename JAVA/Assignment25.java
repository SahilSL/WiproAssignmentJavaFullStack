package com.wipro.practice;
import java.util.Scanner;
/*
 Create a class named MyTriangle that contains two static methods
a) public static double area(double a, double b, double c)
b) public static double perimeter(double a, double b, double c)
to compute area and perimeter of a triangle respectively given three valid
sides a, b and c.
And add a static method
/** Return true if the sum of any two sides is greater than the third side.
**/
/*
c) public static boolean isValid(double a, double b, double c)
In the main method of MyTriangle, test the three methods you write.
1) Get a, b and c from the Console
2) If a is -1, exit your program and print  Bye~ 
3) If a is not -1, use isValid to check the input
4) If the input is valid, compute the area and perimeter and print them
5) If the input is not valid, return false and print  The input is invalid. 
6) Go to 1)
*/


public class Assignment25 {
	 // Check if triangle is valid
    public static boolean isValid(double a, double b, double c) {
        if (a + b > c && a + c > b && b + c > a) {
            return true;
        } else {
            return false;
        }
    }

    //  perimeter
    public static double perimeter(double a, double b, double c) {
        return a + b + c;
    }

    //  area 
    public static double area(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter side a (-1 to exit): ");
            double a = input.nextDouble();

            if (a == -1) {
                System.out.println("Program End!!!");
                break;
            }

            System.out.print("Enter side b: ");
            double b = input.nextDouble();

            System.out.print("Enter side c: ");
            double c = input.nextDouble();

            if (isValid(a, b, c)) {
                System.out.println("Triangle is valid");
                System.out.println("Perimeter = " + perimeter(a, b, c));
                System.out.printf("Area = %.2f\n", area(a, b, c));
            } else {
                System.out.println("The input is invalid.");
            }
        }
    }

}


/*Enter side a (-1 to exit): 56
Enter side b: 58
Enter side c: 72
Triangle is valid
Perimeter = 186.0
Area = 1590.33
Enter side a (-1 to exit): -1
Program End!!!
*/