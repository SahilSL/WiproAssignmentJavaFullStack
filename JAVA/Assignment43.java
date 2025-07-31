package com.wipro.practice;
/*Write a Java program to read the contents of a text file using BufferedReader and try-with-resources. The program should handle exceptions gracefully using proper exception handling techniques.*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Assignment43 {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\sahil\\eclipse-workspace\\WiproAssignment\\src\\com\\wipro\\practice\\sample.txt"; // Change this to your file name

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            System.out.println("File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

/* File Content:
hello sample text
sahil
*/
