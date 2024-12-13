<%--
  Created by IntelliJ IDEA.
  User: laze
  Date: 2024. 12. 12.
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/calc/makeResult" method="post">
        <input type="number" name="num1"/>
        <input type="number" name="num2"/>
        <button type="submit">SEND</button>
    </form>
</body>
</html>
