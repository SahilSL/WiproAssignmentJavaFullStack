<%@ page language="java" %>
<html>
<head><title>Result - Fail</title></head>
<body>
  <h2>Better Luck Next Time!</h2>
  <p><b><%= request.getAttribute("studentName") %></b>, you failed with <%= request.getAttribute("studentMarks") %> marks.</p>
  <jsp:include page="footer.jsp" />
</body>
</html>
