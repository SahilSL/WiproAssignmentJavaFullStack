package com.wipro.practice;
import java.io.*;
import java.util.Scanner;

/*Write a program that creates a new file called batch mates and store your entire batch mates name in it and display the details.*/

public class Assignment37 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        FileWriter fw = new FileWriter("batchmates.txt");

        System.out.print("How many batch mates? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter name " + i + ": ");
            String name = sc.nextLine();
            fw.write(name + "\n");
        }

        fw.close();
        System.out.println("\n Names saved to batchmates.txt\n");

        BufferedReader br = new BufferedReader(new FileReader("batchmates.txt"));
        String line;
        System.out.println("Batch Mates:");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
        sc.close();
    }
}

/*
How many batch mates? 5
Enter name 1: Sahil
Enter name 2: Ravi
Enter name 3: Sandesh
Enter name 4: Shreyash
Enter name 5: Pranay

Names saved to batchmates.txt

Batch Mates:
Sahil
Ravi
Sandesh
Shreyash
Pranay

 */
