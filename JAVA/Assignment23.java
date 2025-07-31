package com.wipro.practice;
import house.hall;
import house.Kitchen;
/*
 Create a Package called house. Create 2 classes namely Hall and Kitchen.
1.  In the Hall class print the message “This is the first room while entering the house” without using the class name System explicitly in the println statement.
2. In the Kitchen class create an array called appliances and initialize with values and print the same. 
3. After printing copy that array into a different array.
 */
public class Assignment23 {

	    public static void main(String[] args) {
	        hall hall = new hall();
	        hall.showMessage();

	        System.out.println(); // Just for spacing

	        Kitchen kitchen = new Kitchen();
	        kitchen.showAppliances();
	    }
	}


/*This is the first room while entering the house

Appliances in kitchen:
Fridge
Microwave
Oven
Mixer

Copied Appliances:
Fridge
Microwave
Oven
Mixer
*/