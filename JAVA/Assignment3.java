package com.wipro.practice;

/*
 * The total number of students in a class are 90 
 * out of which 45 are boys. 
 * If 50% of the total students secured grade 'A' out of which 20 are boys, 
 * then write a program to calculate the total number of girls getting grade 'A'.
 * 
 * 
 * */

//Total students = 90
//Total boys = 45
//So, Total girls = 90 - 45 = 45
//Students who got Grade A = 50% of 90 = 45
//Boys who got Grade A = 20
//So, Girls who got Grade A = 45 (Grade A students) - 20 (Grade A boys) = 25

public class Assignment3 {
	public static void main(String[] args) {
		 int totalStudents = 90;
		 //int totalBoys = 45;
		 int totalGradeA = totalStudents / 2;
		 int gradeABoys = 20;
		 int gradeAGirls = totalGradeA - gradeABoys;
		 System.out.println("Total number of girls getting Grade A: " + gradeAGirls);
		 
	}

}

//Total number of girls getting Grade A: 25

