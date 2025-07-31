package com.wipro.practice;
/*
 Given integer array, remove the duplicate elements and print sum of even 
numbers in the array.
input 1={2,3,54,1,6,7,7} 
 */
public class Assignment26 {
	public static void main(String[] args) {
        int[] arr = {2, 3, 54, 1, 6, 7, 7};
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;

            // Check if current element already appeared before
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            // If not duplicate and even, add to sum ac
            if (!isDuplicate && arr[i] % 2 == 0) {
                sum = sum + arr[i];
            }
        }

        System.out.println("Sum of even numbers (no duplicates): " + sum);
    }

}

//Sum of even numbers (no duplicates): 62

