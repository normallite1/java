<%--
  Created by IntelliJ IDEA.
  User: Java
  Date: 03.06.2022
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
<h1>Testing JSP</h1>
<%@ page import="logic.Cart" %>
<% Cart cart = (Cart)session.getAttribute("cart");%>
<p>Наименование: <%= cart.getName()%> </p>
<p>Количество: <%= cart.getQuantity()%> </p>
</body>
</html>
