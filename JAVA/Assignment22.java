package com.wipro.practice;

/*
 Create two interfaces namely Drawable and Fillable. Create class called Line, Circle, Square and implement following methods through interface.
<I>Drawable ------ drawingColor(), thickness ()
<I>Fillable ---------- fillingColor (), size () 
 */

//Drawable interface
interface Drawable {
 void drawingColor();
 void thickness();
}

//Fillable interface
interface Fillable {
 void fillingColor();
 void size();
}

//Line class - only implements Drawable
class Line implements Drawable {
 public void drawingColor() {
     System.out.println("Line drawing color is Black");
 }

 public void thickness() {
     System.out.println("Line thickness is 2");
 }
}

//Circle class - implements both interfaces
class Circle implements Drawable, Fillable {
 public void drawingColor() {
     System.out.println("Circle drawing color is Blue");
 }

 public void thickness() {
     System.out.println("Circle thickness is 3");
 }

 public void fillingColor() {
     System.out.println("Circle filling color is Light Blue");
 }

 public void size() {
     System.out.println("Circle size is Medium");
 }
}

//Square class - implements both interfaces
class Square implements Drawable, Fillable {
 public void drawingColor() {
     System.out.println("Square drawing color is Red");
 }

 public void thickness() {
     System.out.println("Square thickness is 4");
 }

 public void fillingColor() {
     System.out.println("Square filling color is Yellow");
 }

 public void size() {
     System.out.println("Square size is Large");
 }
}


public class Assignment22 {
 public static void main(String[] args) {
     Line line = new Line();
     Circle circle = new Circle();
     Square square = new Square();

     System.out.println("Line:");
     line.drawingColor();
     line.thickness();

     System.out.println("\nCircle:");
     circle.drawingColor();
     circle.thickness();
     circle.fillingColor();
     circle.size();

     System.out.println("\nSquare:");
     square.drawingColor();
     square.thickness();
     square.fillingColor();
     square.size();
 }
}


/*Line:
Line drawing color is Black
Line thickness is 2

Circle:
Circle drawing color is Blue
Circle thickness is 3
Circle filling color is Light Blue
Circle size is Medium

Square:
Square drawing color is Red
Square thickness is 4
Square filling color is Yellow
Square size is Large
*/