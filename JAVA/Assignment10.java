package com.wipro.practice;

/*
 * Consider user has N eggs. Then display the no of eggs in gross (144 eggs make one gross) and 
no of eggs in dozen (12 eggs make one dozen) and the no of eggs that is left out remaining. 
The total no of eggs can be got as input through command line. The program should display
how many gross, how many dozen, and how many left over eggs the user has.

Solution Guidance (if applicable): For example, if the input is 1342 eggs, then the program should respond with 
        Your number of eggs is 9 gross, 3 dozen, and 10
 * */


import java.util.Scanner;

public class Assignment10 {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the total np. of eggs:: ");
        int eggs = input.nextInt();
        int gross = eggs / 144;             // 144 eggs - 1 gross
        int EggsremainingAfterGross = eggs % 144;
        int dozen = EggsremainingAfterGross / 12;   // 1 dozen = 12 eggs
        int remaining = EggsremainingAfterGross % 12;

        System.out.println("You have: " +  gross + " gross " + dozen + " dozen " + remaining + " eggs left over");
    }

}


/*
Output---->
Enter the total np. of eggs:: 244
You have: 1 gross 8 dozen 4 eggs left over

*/