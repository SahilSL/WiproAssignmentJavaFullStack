package wipro.servletassignment3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String selected = request.getParameter("product"); //Phone-15000
        String[] parts = selected.split("-");
        //Phone-15000 here Phone--->index 0 and 15000--->index 1
        String productName = parts[0];
        double price = Double.parseDouble(parts[1]);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Enter Quantity for: " + productName + "</h2>");
        out.println("<form action='placeorder' method='post'>");
        out.println("Quantity: <input type='number' name='quantity' required><br><br>");
        // Hidden fields
        out.println("<input type='hidden' name='productName' value='" + productName + "'>");
        out.println("<input type='hidden' name='price' value='" + price + "'>");
        out.println("<input type='submit' value='Place Order'>");
        out.println("</form></body></html>");
    }
}
