package com.example.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*Create a Java program to connect to a MySQL database and retrieve all student records from a Student table using JDBC. 
 * Display each student's ID, name, age, course, and marks.

*/
public class StudentJDBCApp {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/wipro";
		String username = "root"; // change if you use a different user
		String password = "Sahil@2502"; // change according to your setup

		try {
			// Load MySQL JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded...");

			// Establish Connection
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to Database...");

			// Create Statement and Execute Query
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM Student";
			ResultSet rs = stmt.executeQuery(query);

			// Display Results
			System.out.println("Student Records:");
			System.out.println("ID\tName\tAge\tCourse\tMarks");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String course = rs.getString("course");
				int marks = rs.getInt("marks");

				System.out.println(id + "\t" + name + "\t" + age + "\t" + course + "\t" + marks);
			}

			// Close resources
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
