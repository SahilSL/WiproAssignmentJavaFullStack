<%@ page language="java" %>
<html>
<head><title>Result - Pass</title></head>
<body>
  <h2>Congratulations!</h2>
  <p><b><%= request.getAttribute("studentName") %></b>, you passed with <%= request.getAttribute("studentMarks") %> marks.</p>
  <jsp:include page="footer.jsp" />
</body>
</html>
