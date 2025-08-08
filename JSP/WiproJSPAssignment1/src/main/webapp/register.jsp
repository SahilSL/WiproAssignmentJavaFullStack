<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration Form</title>
</head>
<body>
    <h2 style="text-align:center;">User Registration</h2>
    <form action="success.jsp" method="post" style="width: 400px; margin: auto;">
        Full name: <input type="text" name="fullname" /><br/><br/>
        E-mail: <input type="email" name="email" /><br/><br/>
        Password: <input type="password" name="password" /><br/><br/>
        Birthday (yyyy-mm-dd): <input type="date" name="birthday" /><br/><br/>
        Gender:
        <input type="radio" name="gender" value="Male" /> Male
        <input type="radio" name="gender" value="Female" /> Female
        <br/><br/>
        Profession:
        <select name="profession">
            <option>Developer</option>
            <option>Tester</option>
            <option>Manager</option>
        </select>
        <br/><br/>
        Married? <input type="checkbox" name="married" /><br/><br/>
        Note:<br/>
        <textarea name="note" rows="4" cols="40"></textarea><br/><br/>
        <input type="submit" value="Register" />
    </form>
</body>
</html>
