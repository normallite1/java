<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<form action="/hello-servlet" method="POST">
    <br/> Сколько тебе лет?
    <br/><label>
    <input type="radio" name="question1" value="More 20" />Больше 20
    </label>
    <br/><label>
    <input type="radio" name="question1" value="less 20" />Меньше 20
</label>
    <br/> Ты тупой?
    <br/><label>
    <input type="radio" name="question2" value="Yes" />Да
</label>
    <br/><label>
    <input type="radio" name="question2" value="No" />Нет
</label>

    <br/><input type="submit" />
</form>

</body>
</html>