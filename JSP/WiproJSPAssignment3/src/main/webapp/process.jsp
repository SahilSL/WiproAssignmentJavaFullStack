<%@ page language="java" %>
<%
    String name = request.getParameter("studentName");
    int marks = Integer.parseInt(request.getParameter("studentMarks"));

    request.setAttribute("studentName", name);
    request.setAttribute("studentMarks", marks);

    if (marks >= 40) {
        RequestDispatcher rd = request.getRequestDispatcher("pass.jsp");
        rd.forward(request, response);
    } else {
        RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
        rd.forward(request, response);
    }
%>
