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
    ${todoList}
    <ul>
        <c:forEach var="dto" items="${todoList}">
            <li>${dto}</li>
        </c:forEach>
    </ul>
</body>
</html>
