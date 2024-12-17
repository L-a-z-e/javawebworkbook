package com.laze.w2.todo.controller;

import com.laze.w2.todo.dto.TodoDTO;
import com.laze.w2.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
@Log4j2
public class TodoListController extends HttpServlet {

    private TodoService todoService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("/todo/list > TodoListController > doGet");

        ServletContext servletContext = req.getServletContext();

        log.info("appName : " + servletContext.getAttribute("appName"));

        List<TodoDTO> dtoList = null;
        try {
            dtoList = todoService.INSTANCE.listAll();
            req.setAttribute("todoList", dtoList);
            req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("list error");
        }

    }
}
