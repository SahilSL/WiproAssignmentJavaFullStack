package wipro.servletassignment3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/placeorder")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double total = price * quantity;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Receipt</h2>");
        out.println("Product: " + productName + "<br>");
        out.println("Price: " + price + "<br>");
        out.println("Quantity: " + quantity + "<br>");
        out.println("=================================<br>");
        out.println("<b>Total: " + total + "</b>");
        out.println("</body></html>");
    }
}
