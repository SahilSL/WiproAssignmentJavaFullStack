<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.wipro.model.BankAccount" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>Bank Account Input</title></head>
<body>
    <h2>Enter Bank Account Details</h2>
    <form action="display.jsp" method="post">
        Account No: <input type="text" name="accountNo" required><br><br>
        Name: <input type="text" name="name" required><br><br>
        Balance: <input type="number" step="0.01" name="balance" required><br><br>
        Account Type:
        <select name="accountType">
            <option value="Savings">Savings</option>
            <option value="Current">Current</option>
        </select><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
