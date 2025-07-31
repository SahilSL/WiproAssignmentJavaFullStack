package com.wipro.practice;
/*
 Create a Java program to connect to a MySQL database and retrieve all student records from a Student table using JDBC. Display each student's ID, name, age, course, and marks.

 */
import java.sql.*;

public class Assignment51 {
    public static void main(String[] args) {

        // connection
        String url = "jdbc:mysql://localhost:3306/wipro";
        String user = "root";
        String password = "Sahil@2502";

        String query = "SELECT * FROM Student"; //query

        try {
            //JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to mysql
            Connection conn = DriverManager.getConnection(url, user, password);

            // Create statement and execute query
            Statement statement = conn.createStatement();
            ResultSet resultset = statement.executeQuery(query);

 
            System.out.println("Student Records:");
            System.out.println("ID   Name   Age   Course   Marks");
            System.out.println("-------------------------------------");

            while (resultset.next()) {
                int id = resultset.getInt("id");
                String name = resultset.getString("name");
                int age = resultset.getInt("age");
                String course = resultset.getString("course");
                double marks = resultset.getDouble("marks");

                System.out.println(id + "   " + name + "   " + age + "   " + course + "   " + marks);
            }

            resultset.close();
            statement.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error!");
            e.printStackTrace();
        }
    }
}

/*
 Student Records:
ID   Name   Age   Course   Marks
-------------------------------------
1  Rahul  20   Java   85.5
2  Sneha  21   Python   92.0
3  Amit  22   C++   78.0
*/
 