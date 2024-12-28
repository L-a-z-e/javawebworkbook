<%--
  Created by IntelliJ IDEA.
  User: laze
  Date: 2024. 12. 23.
  Time: 14:02
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
    <form action="/todo/modify" method="post">
        <div class="input-group mb-3">
            <span class="input-group-text">Tno</span>
            <input type="text" name="tno" class="form-control" value=<c:out value="${dto.tno}"/> readonly>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">Title</span>
            <input type="text" name="title" class="form-control" value=<c:out value="${dto.title}"/> >
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">DueDate</span>
            <input type="date" name="dueDate" class="form-control" value=<c:out value="${dto.dueDate}"/> >
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">Writer</span>
            <input type="text" name="writer" class="form-control" value=<c:out value="${dto.writer}"/> readonly>
        </div>

        <div class="form-check">
            <label class="form-check-label">Finished &nbsp</label>
            <input class="form-check-input" type="checkbox" name="finished" ${dto.finished ? "checked" : "" } >
        </div>

        <div class="my-4">
            <div class="float-end">
                <button type="button" class="btn btn-danger">Remove</button>
                <button type="button" class="btn btn-primary">Modify</button>
                <button type="reset" class="btn btn-secondary">List</button>
            </div>
        </div>
<%--        <input type="hidden" name="page" value="${pageRequestDTO.page}"/>--%>
<%--        <input type="hidden" name="size" value="${pageRequestDTO.size}"/>--%>
    </form>

        <script>

            const formObj = document.querySelector("form")


            document.querySelector(".btn-danger").addEventListener("click", function(e){
                e.preventDefault()
                e.stopPropagation()
                formObj.action = `/todo/remove?${pageRequestDTO.link}`
                formObj.method = "post"
                formObj.submit()
            }, false)

            document.querySelector(".btn-primary").addEventListener("click", function(e) {
                e.preventDefault()
                e.stopPropagation()
                formObj.action = "/todo/modify"
                formObj.method = "post"
                formObj.submit()
            }, false)

            document.querySelector(".btn-secondary").addEventListener("click", function(e){
                self.location = `/todo/list?${pageRequestDTO.link}`;
            }, false)
        </script>

    </div>
    <script>
        const serverValidResult = {}
        <c:forEach items="${errors}" var="error">
            serverValidResult['${error.getField()}'] = '${error.defaultMessage}'
        </c:forEach>

        console.log(serverValidResult)
    </script>
</body>
</html>
