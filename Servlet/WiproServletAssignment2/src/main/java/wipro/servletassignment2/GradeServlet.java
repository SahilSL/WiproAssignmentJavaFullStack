package wipro.servletassignment2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/grade")
public class GradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String name = (String) request.getAttribute("name");
        int marks = (Integer) request.getAttribute("marks");

        String grade;
        if (marks >= 90) {
            grade = "A";
        } else if (marks >= 75) {
            grade = "B";
        } else if (marks >= 60) {
            grade = "C";
        } else {
            grade = "D";
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Result</h2>");
        out.println("Name: " + name + "<br>");
        out.println("Marks: " + marks + "<br>");
        out.println("Grade: " + grade);
    }
}
