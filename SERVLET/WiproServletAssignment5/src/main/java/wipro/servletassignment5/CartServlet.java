package wipro.servletassignment5;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String[] items = request.getParameterValues("item");

        if (items != null) {
            for (String item : items) {
                Cookie cookie = new Cookie(item, item);
                cookie.setMaxAge(60 * 60); // 1 hour
                response.addCookie(cookie);
            }
        }

        response.setContentType("text/html");
        response.getWriter().println("<h3>Items added to cart.</h3>");
        response.getWriter().println("<a href='viewcart'>View Cart</a>");
    }
}
