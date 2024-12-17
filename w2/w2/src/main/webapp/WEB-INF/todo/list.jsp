<%--
  Created by IntelliJ IDEA.
  User: laze
  Date: 2024. 12. 12.
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>List Page</h1>
    <h2>${appName}</h2>
    <h3>${loginInfo}</h3>
    <ul>
        <c:forEach items="${todoList}" var="todoDto">
            <li>
                <apan><a href="/todo/read?tno=${todoDto.tno}">${todoDto.tno}</a></apan>
                <span>${todoDto.title}</span>
                <span>${todoDto.dueDate}</span>
                <span>${todoDto.finished ? "DONE" : "NOT YET"}</span>
            </li>
        </c:forEach>
    </ul>

    <form action="/logout" method="post">
        <button>LOGOUT</button>
    </form>
</body>
</html>
