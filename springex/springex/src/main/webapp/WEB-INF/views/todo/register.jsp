<%--
  Created by IntelliJ IDEA.
  User: laze
  Date: 2024. 12. 21.
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="card-body">
        <form action="/todo/register" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">Title</span>
                <input type="text" name="title" class="form-control" placeholder="Title">
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text">DueDate</span>
                <input type="date" name="dueDate" class="form-control" placeholder="DueDate">
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text">Writer</span>
                <input type="text" name="writer" class="form-control" placeholder="Writer">
            </div>

            <div class="my-4">
                <div class="float-end">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button type="reset" class="btn btn-secondary">Reset</button>
                </div>
            </div>
            <script>
                const serverValidResult = {}

                <c:forEach items="${errors}" var="error">
                    serverValidResult['${error.getField()}'] = '${error.defaultMessage}'
                </c:forEach>

                console.log(serverValidResult)
            </script>
        </form>
    </div>
</body>
</html>
