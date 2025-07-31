package com.wipro.practice;

import java.util.Scanner;

public class Assignment15 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner input = new Scanner(System.in);

        // 10 elements from user
        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            arr[i] = input.nextInt();
        }

        // Count 
        boolean[] visited = new boolean[10]; // To avoid counting duplicates again

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                int count = 1;
                for (int j = i + 1; j < 10; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                        visited[j] = true;
                    }
                }
                System.out.println("Number " + arr[i] + " occurs " + count + " times");
            }
        }
    }
}

/*
 Enter 10 numbers:
58
58
41236
586
64
586
58
746
123
5862
Number 58 occurs 3 times
Number 41236 occurs 1 times
Number 586 occurs 2 times
Number 64 occurs 1 times
Number 746 occurs 1 times
Number 123 occurs 1 times
Number 5862 occurs 1 times

 */
