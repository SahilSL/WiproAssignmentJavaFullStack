package com.wipro.practice;
/*
 Create an enum of the six types of paper currency. Loop through the values( ) and print each value. Write a switch statement for the enum.  For each case, output a description of that particular currency.
 */
public class Assignment27 {
	// Create an enum with 6 currency types
    enum Currency {
    	FIVEHUNDRED, FIVE, TEN, TWENTY, FIFTY, HUNDRED
    }

    public static void main(String[] args) {

        // Loop and print each currency with its description
        for (Currency c : Currency.values()) {
            System.out.println("Currency: " + c);

            // Use switch to print description
            switch (c) {
                case FIVEHUNDRED:
                    System.out.println("500 Rupee note");
                    break;
                case FIVE:
                    System.out.println("5 Rupee note");
                    break;
                case TEN:
                    System.out.println("10 Rupee note");
                    break;
                case TWENTY:
                    System.out.println("20 Rupee note");
                    break;
                case FIFTY:
                    System.out.println("50 Rupee note");
                    break;
                case HUNDRED:
                    System.out.println("100 Rupee note");
                    break;
            }

            System.out.println(); // blank line for better output
        }
    }

}

/*Currency: FIVEHUNDRED
500 Rupee note

Currency: FIVE
5 Rupee note

Currency: TEN
10 Rupee note

Currency: TWENTY
20 Rupee note

Currency: FIFTY
50 Rupee note

Currency: HUNDRED
100 Rupee note

*/