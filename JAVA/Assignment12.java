package com.wipro.practice;
import java.util.*;
/*
 
Create a class called Student with the following details: RollNo, StudName, MarksInEng, 
MarksInMaths and MarksInScience. Write getters and setters for the all variables. RollNo
should be automatically generated whenever a new student is added.

Create a class called Standard with 8 students’ details and write separate method for each of the following tasks and invoke the same.
1. To display the entire roll no and the name of the students in the class in the ascending order of roll no.
2. To display the roll no and the name of the student who has got the highest percentage.
3. To display the roll no and the name of the student who scored highest mark in mathematics.
4. To display the roll no and the name of the student in the ascending order of the total marks in mathematics and science alone.
5. To display the roll no, name, total marks, percentage and rank of all the students in the descending order of rank.
  
 */

class Student {
    private static int rollCounter = 1;
    private int rollNo;
    private String studName;
    private int marksInEng;
    private int marksInMaths;
    private int marksInScience;

    public Student(String studName, int marksInEng, int marksInMaths, int marksInScience) {
        this.rollNo = rollCounter++;
        this.studName = studName;
        this.marksInEng = marksInEng;
        this.marksInMaths = marksInMaths;
        this.marksInScience = marksInScience;
    }

    // Getters
    public int getRollNo() {
        return rollNo;
    }

    public String getStudName() {
        return studName;
    }

    public int getMarksInEng() {
        return marksInEng;
    }

    public int getMarksInMaths() {
        return marksInMaths;
    }

    public int getMarksInScience() {
        return marksInScience;
    }

    public int getTotalMarks() {
        return marksInEng + marksInMaths + marksInScience;
    }

    public double getPercentage() {
        return getTotalMarks() / 3.0;
    }

    public int getMathsScienceTotal() {
        return marksInMaths + marksInScience;
    }
}

class Standard {
    private List<Student> students;
    public Standard() {
        students = new ArrayList<>();
        students.add(new Student("Vaidehi", 78, 88, 92));
        students.add(new Student("Shreyash", 85, 91, 89));
        students.add(new Student("Arpith", 60, 70, 75));
        students.add(new Student("Sahil", 90, 95, 94));
        students.add(new Student("Ravi", 70, 80, 85));
        students.add(new Student("Apurva", 88, 77, 66));
        students.add(new Student("Apurva", 68, 72, 78));
        students.add(new Student("Sanjana", 95, 99, 100));
    }

    // Display roll no and name in ascending order of roll no
    public void displayStudentsByRollNo() {
        System.out.println("\nStudents by Roll No:");
        students.stream()
            .sorted(Comparator.comparingInt(Student::getRollNo))
            .forEach(s -> System.out.println("Roll No: " + s.getRollNo() + ", Name: " + s.getStudName()));
    }

    // Student with highest percentage
    public void displayTopperByPercentage() {
        Student topStudent = Collections.max(students, Comparator.comparingDouble(Student::getPercentage));
        System.out.println("\nTopper by Percentage:");
        System.out.println("Roll No: " + topStudent.getRollNo() + ", Name: " + topStudent.getStudName());
    }

    // Student with highest marks in maths
    public void displayTopperInMaths() {
        Student topMath = Collections.max(students, Comparator.comparingInt(Student::getMarksInMaths));
        System.out.println("\nTopper in Maths:");
        System.out.println("Roll No: " + topMath.getRollNo() + ", Name: " + topMath.getStudName());
    }

    // Students sorted by total marks in maths + science
    public void displayStudentsByMathsScienceTotal() {
        System.out.println("\nStudents by Maths + Science Total:");
        students.stream()
            .sorted(Comparator.comparingInt(Student::getMathsScienceTotal))
            .forEach(s -> System.out.println("Roll No: " + s.getRollNo() + ", Name: " + s.getStudName()));
    }

    // Display roll no, name, total marks, percentage, rank (descending order of rank)
    public void displayAllWithRank() {
        System.out.println("\nStudents with Rank:");
        students.sort((s1, s2) -> Double.compare(s2.getPercentage(), s1.getPercentage()));

        int rank = 1;
        for (Student s : students) {
            System.out.println("Rank: " + rank++ + ", Roll No: " + s.getRollNo() +
                ", Name: " + s.getStudName() +
                ", Total Marks: " + s.getTotalMarks() +
                ", Percentage: " + String.format("%.2f", s.getPercentage()));
        }
    }
}

public class Assignment12 {
	public static void main(String[] args) {
        Standard std = new Standard();

        std.displayStudentsByRollNo();
        std.displayTopperByPercentage();
        std.displayTopperInMaths();
        std.displayStudentsByMathsScienceTotal();
        std.displayAllWithRank();
    }

}

/*
Students by Roll No:
Roll No: 1, Name: Vaidehi
Roll No: 2, Name: Shreyash
Roll No: 3, Name: Arpith
Roll No: 4, Name: Sahil
Roll No: 5, Name: Ravi
Roll No: 6, Name: Apurva
Roll No: 7, Name: Apurva
Roll No: 8, Name: Sanjana

Topper by Percentage:
Roll No: 8, Name: Sanjana

Topper in Maths:
Roll No: 8, Name: Sanjana

Students by Maths + Science Total:
Roll No: 6, Name: Apurva
Roll No: 3, Name: Arpith
Roll No: 7, Name: Apurva
Roll No: 5, Name: Ravi
Roll No: 1, Name: Vaidehi
Roll No: 2, Name: Shreyash
Roll No: 4, Name: Sahil
Roll No: 8, Name: Sanjana

Students with Rank:
Rank: 1, Roll No: 8, Name: Sanjana, Total Marks: 294, Percentage: 98.00
Rank: 2, Roll No: 4, Name: Sahil, Total Marks: 279, Percentage: 93.00
Rank: 3, Roll No: 2, Name: Shreyash, Total Marks: 265, Percentage: 88.33
Rank: 4, Roll No: 1, Name: Vaidehi, Total Marks: 258, Percentage: 86.00
Rank: 5, Roll No: 5, Name: Ravi, Total Marks: 235, Percentage: 78.33
Rank: 6, Roll No: 6, Name: Apurva, Total Marks: 231, Percentage: 77.00
Rank: 7, Roll No: 7, Name: Apurva, Total Marks: 218, Percentage: 72.67
Rank: 8, Roll No: 3, Name: Arpith, Total Marks: 205, Percentage: 68.33
*/