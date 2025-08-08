package wipro.servletassignment5;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ViewCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html");

        response.getWriter().println("<h3>Your Cart Items:</h3><ul>");
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (!c.getName().equals("JSESSIONID"))
                    response.getWriter().println("<li>" + c.getValue() + "</li>");
            }
        } else {
            response.getWriter().println("<li>No items in cart</li>");
        }
        response.getWriter().println("</ul>");
    }
}
