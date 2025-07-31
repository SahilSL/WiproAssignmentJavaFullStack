package com.wipro.practice;

/*Design a class that acts as a library for the following kinds of media: book, video, and newspaper. Provide one version of the class that uses generics and one that does not.
The class should be with add and retrieve methods in order to add and retrieve values 
from the library.*/


//Generic --->
/*
//Media types
class Book {
 String title;
 Book(String title) { this.title = title; }
}

class Video {
 String title;
 Video(String title) { this.title = title; }
}

class Newspaper {
 String title;
 Newspaper(String title) { this.title = title; }
}

//Library without generics
class SimpleLibrary {
 Book book;
 Video video;
 Newspaper newspaper;

 void addBook(Book b) { book = b; }
 void addVideo(Video v) { video = v; }
 void addNewspaper(Newspaper n) { newspaper = n; }

 void showItems() {
     System.out.println("Book: " + book.title);
     System.out.println("Video: " + video.title);
     System.out.println("Newspaper: " + newspaper.title);
 }
}

public class Assignment39 {
 public static void main(String[] args) {
     SimpleLibrary lib = new SimpleLibrary();
     lib.addBook(new Book("Java Book"));
     lib.addVideo(new Video("Java Video"));
     lib.addNewspaper(new Newspaper("Daily News"));

     lib.showItems();
 }
}
*/


// Non Generic ---->
//Generic Library
class GenericLibrary<T> {
 T item;

 void addItem(T item) {
     this.item = item;
 }

 void showItem() {
     System.out.println("Item: " + item);
 }
}

//Media types
class Book {
 String title;
 Book(String title) { this.title = title; }
 public String toString() { return "Book - " + title; }
}

class Video {
 String title;
 Video(String title) { this.title = title; }
 public String toString() { return "Video - " + title; }
}

class Newspaper {
 String title;
 Newspaper(String title) { this.title = title; }
 public String toString() { return "Newspaper - " + title; }
}

public class Assignment39 {
 public static void main(String[] args) {
     GenericLibrary<Book> bookLib = new GenericLibrary<>();
     GenericLibrary<Video> videoLib = new GenericLibrary<>();
     GenericLibrary<Newspaper> newsLib = new GenericLibrary<>();

     bookLib.addItem(new Book("Easy Java"));
     videoLib.addItem(new Video("Intro to Java"));
     newsLib.addItem(new Newspaper("Morning Times"));

     bookLib.showItem();
     videoLib.showItem();
     newsLib.showItem();
 }
}

/*

 
 
 
 Non Genric---->
 Item: Book - Easy Java
Item: Video - Intro to Java
Item: Newspaper - Morning Times
 
 */
 