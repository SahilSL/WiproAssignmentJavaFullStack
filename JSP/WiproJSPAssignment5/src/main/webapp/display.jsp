<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.wipro.model.BankAccount" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    // Create and populate JavaBean
    String accountNo = request.getParameter("accountNo");
    String name = request.getParameter("name");
    double balance = Double.parseDouble(request.getParameter("balance"));
    String accountType = request.getParameter("accountType");

    BankAccount acc = new BankAccount();
    acc.setAccountNo(accountNo);
    acc.setName(name);
    acc.setBalance(balance);

    // Set bean and accountType in scopes
    request.setAttribute("acc", acc);
    session.setAttribute("accountType", accountType);
%>

<html>
<head><title>Bank Account Details</title></head>
<body>
    <h2>Account Details</h2>
    Account Number: ${acc.accountNo}<br>
    Name: ${acc.name}<br>
    Balance: ${acc.balance}<br>
    Account Type: ${sessionScope.accountType}<br><br>

    <c:choose>
        <c:when test="${acc.balance >= 1000}">
            <b>Balance is sufficient.</b>
        </c:when>
        <c:otherwise>
            <b style="color:red;">Balance is insufficient.</b>
        </c:otherwise>
    </c:choose>
</body>
</html>
