package com.wipro.practice;

/*
 Create a class called BookStore with fields Bookid and Bookname.  Sort using comparator and display the output by sorting based on book name and book id.
 */

import java.util.*;

class BookStore {
 int bookId;
 String bookName;

 BookStore(int id, String name) {
     this.bookId = id;
     this.bookName = name;
 }

 public String toString() {
     return bookId + " - " + bookName;
 }
}

public class Assignment41 {
 public static void main(String[] args) {
     ArrayList<BookStore> books = new ArrayList<>();

     books.add(new BookStore(3, "Python"));
     books.add(new BookStore(1, "Java"));
     books.add(new BookStore(2, "C Language"));

     Collections.sort(books, new Comparator<BookStore>() {
         public int compare(BookStore b1, BookStore b2) {
             return b1.bookName.compareTo(b2.bookName);
         }
     });

     System.out.println(" Sorted by Book Name:");
     for (BookStore b : books) {
         System.out.println(b);
     }

     Collections.sort(books, new Comparator<BookStore>() {
         public int compare(BookStore b1, BookStore b2) {
             return b1.bookId - b2.bookId;
         }
     });

     System.out.println("\n Sorted by Book ID:");
     for (BookStore b : books) {
         System.out.println(b);
     }
 }
}

/* Sorted by Book Name:
2 - C Language
1 - Java
3 - Python

 Sorted by Book ID:
1 - Java
2 - C Language
3 - Python
*/
