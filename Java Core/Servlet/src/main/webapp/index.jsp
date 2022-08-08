<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Hello</h1>
    <form action="/login" method="post">
        User name:<label>
        <input name="login" type="text">
    </label><br>
        Password:<label>
        <input name="pass" type="password">
    </label>
        <input type="submit">
    </form>
<a href="/new-user">new User</a>
</body>
</html>