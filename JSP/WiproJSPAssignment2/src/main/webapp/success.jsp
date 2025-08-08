<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Submitted Info</title></head>
<body>
    <h2>Submitted User Info</h2>
    <p>User Name: ${param.username}</p>
    <p>Password: ${param.password}</p>
    <p>Address: ${param.address}</p>
    <p>Newsletter Subscribed: ${param.newsletter}</p>

    <p>Favorite Frameworks:</p>
    <ul>
        <c:forEach var="fw" items="${paramValues.framework}">
            <li>${fw}</li>
        </c:forEach>
    </ul>

    <p>Gender: ${param.gender}</p>
    <p>Favorite Number: ${param.number}</p>
</body>
</html>
