package wipro.servletassignment4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String accNo = request.getParameter("accno");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Hardcoded credentials
        if (accNo.equals("Sahil") && password.equals("pass123")) {
            HttpSession session = request.getSession();
            session.setAttribute("name", "Sahil Lokhande");
            session.setAttribute("balance", 25000);
            response.sendRedirect("balance");
        } else {
            out.println("<h3>Invalid credentials!</h3>");
            out.println("<a href='login.html'>Try again</a>");
        }
    }
}
