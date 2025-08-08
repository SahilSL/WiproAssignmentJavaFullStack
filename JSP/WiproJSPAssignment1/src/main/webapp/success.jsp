<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Success</title>
</head>
<body>
    <h2>Registration Successful!</h2>
    <p>Full Name: ${param.fullname}</p>
    <p>Email: ${param.email}</p>
    <p>Birthday: ${param.birthday}</p>
    <p>Gender: ${param.gender}</p>
    <p>Profession: ${param.profession}</p>
    <p>Married: ${param.married}</p>
    <p>Note: ${param.note}</p>
</body>
</html>
