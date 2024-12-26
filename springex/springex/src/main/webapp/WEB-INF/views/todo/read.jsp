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
        <div class="input-group mb-3">
            <span class="input-group-text">Tno</span>
            <input type="text" name="tno" class="form-control" value=<c:out value="${dto.tno}"/> readonly>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">Title</span>
            <input type="text" name="title" class="form-control" value=<c:out value="${dto.title}"/> readonly>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">DueDate</span>
            <input type="date" name="dueDte" class="form-control" value=<c:out value="${dto.dueDate}"/> readonly>
        </div>

        <div class="input-group mb-3">
            <span class="input-group-text">Writer</span>
            <input type="text" name="writer" class="form-control" value=<c:out value="${dto.writer}"/> readonly>
        </div>

        <div class="form-check">
            <label class="form-check-label">Finished &nbsp</label>
            <input class="form-check-input" type="checkbox" name="finished" ${dto.finished ? "checked" : "" } disabled>
        </div>

        <div class="my-4">
            <div class="float-end">
                <button type="submit" class="btn btn-primary">Modify</button>
                <button type="reset" class="btn btn-secondary">List</button>
            </div>
        </div>

        <script>
            document.querySelector(".btn-primary").addEventListener("click", function(e){
                self.location = `/todo/modify?tno=+${dto.tno}&${pageRequestDTO.link}`;
            }, false)

            document.querySelector(".btn-secondary").addEventListener("click", function(e){
                self.location = `/todo/list?${pageRequestDTO.link}`;
            }, false)
        </script>

    </div>
</body>
</html>