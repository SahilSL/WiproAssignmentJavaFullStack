<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>User Information</title></head>
<body>
    <h2>User Information</h2>
    <form action="success.jsp" method="post">
        User Name: <input type="text" name="username"/><br/><br/>
        Password: <input type="password" name="password"/><br/><br/>
        Address: <textarea name="address"></textarea><br/><br/>

        Subscribe Newsletter: <input type="checkbox" name="newsletter"/><br/><br/>

        Favorite Web Frameworks:
        <input type="checkbox" name="framework" value="Spring MVC"/> Spring MVC
        <input type="checkbox" name="framework" value="Struts 1"/> Struts 1
        <input type="checkbox" name="framework" value="Struts 2"/> Struts 2
        <input type="checkbox" name="framework" value="Apache Wicket"/> Apache Wicket<br/><br/>

        Gender:
        <input type="radio" name="gender" value="Male"/> Male
        <input type="radio" name="gender" value="Female"/> Female<br/><br/>

        Favorite Number:
        <input type="radio" name="number" value="1"/> 1
        <input type="radio" name="number" value="2"/> 2
        <input type="radio" name="number" value="3"/> 3
        <input type="radio" name="number" value="4"/> 4<br/><br/>

        <input type="submit" value="Submit"/>
    </form>
</body>
</html>
