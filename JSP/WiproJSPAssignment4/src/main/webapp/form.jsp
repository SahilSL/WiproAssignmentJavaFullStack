<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Product Entry</title>
</head>
<body>
    <h2>Enter Product Details</h2>
    <form action="display.jsp" method="post">
        Product ID: <input type="text" name="id" /><br/>
        Product Name: <input type="text" name="name" /><br/>
        Price: <input type="text" name="price" /><br/>
        Quantity: <input type="text" name="quantity" /><br/>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
