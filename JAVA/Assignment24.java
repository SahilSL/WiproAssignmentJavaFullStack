package com.wipro.practice;
import java.util.Scanner;
/*
 Five Bikers Compete in a race such that they drive at a constant speed which may or may not be the same as the other. To qualify the race, the speed of a racer must be more than the average speed of all 5 racers. Take as input the speed of each racer and print back the speed of qualifying racers. 
 */
public class Assignment24 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s1, s2, s3, s4, s5;
        double avg;

  
        System.out.print("Enter speed of Biker 1: ");
        s1 = sc.nextInt();
        System.out.print("Enter speed of Biker 2: ");
        s2 = sc.nextInt();
        System.out.print("Enter speed of Biker 3: ");
        s3 = sc.nextInt();
        System.out.print("Enter speed of Biker 4: ");
        s4 = sc.nextInt();
        System.out.print("Enter speed of Biker 5: ");
        s5 = sc.nextInt();

        // average
        avg = (s1 + s2 + s3 + s4 + s5) / 5.0;
        System.out.println("Average speed: " + avg);

        // Check who qualifies
        System.out.println("Qualifying racers (speed > average):");
        if (s1 > avg) System.out.println("Biker 1: " + s1);
        if (s2 > avg) System.out.println("Biker 2: " + s2);
        if (s3 > avg) System.out.println("Biker 3: " + s3);
        if (s4 > avg) System.out.println("Biker 4: " + s4);
        if (s5 > avg) System.out.println("Biker 5: " + s5);
    }

}


/*Enter speed of Biker 1: 98
Enter speed of Biker 2: 52
Enter speed of Biker 3: 85
Enter speed of Biker 4: 75
Enter speed of Biker 5: 99
Average speed: 81.8
Qualifying racers (speed > average):
Biker 1: 98
Biker 3: 85
Biker 5: 99
*/