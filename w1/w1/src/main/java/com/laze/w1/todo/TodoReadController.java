package com.laze.w1.todo;

import com.laze.w1.todo.dto.TodoDTO;
import com.laze.w1.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TodoReadController > doGet");

        Long tno = Long.parseLong(req.getParameter("tno"));

        TodoDTO todoDTO = TodoService.INSTANCE.get(tno);

        req.setAttribute("todoDTO", todoDTO);

        req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);
    }
}
