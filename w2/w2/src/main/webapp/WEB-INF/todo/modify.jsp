<%--
  Created by IntelliJ IDEA.
  User: laze
  Date: 2024. 12. 15.
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form id="form1" action="/todo/modify" method="post">
        <div>
            <input type="text" name="tno" value="${todoDTO.tno}" readonly>
        </div>
        <div>
            <input type="text" name="title" value="${todoDTO.title}">
        </div>
        <div>
            <input type="date" name="dueDate" value="${todoDTO.dueDate}">
        </div>
        <div>
            <input type="checkbox" name="finished" value="${todoDTO.finished ? "checked" : ""}">
        </div>

        <div>
            <button type="submit">Modify</button>
        </div>
    </form>

    <form id="form2" action="/todo/remove" method="post">
        <input type="hidden" name="tno" value="${todoDTO.tno}" readonly>
        <div>
            <button type="submit">Remove</button>
        </div>
    </form>

</body>
</html>
