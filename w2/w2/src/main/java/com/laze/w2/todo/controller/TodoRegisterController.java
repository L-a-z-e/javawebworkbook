package com.laze.w2.todo.controller;

import com.laze.w2.todo.dto.TodoDTO;
import com.laze.w2.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")
@Log4j2
public class TodoRegisterController extends HttpServlet {

    private TodoService todoService;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("/todo/register doGet");

        HttpSession session = req.getSession();

        if (session.isNew()) {
            log.info("new JSESSIONID");
            resp.sendRedirect("/login");
        }

        if (session.getAttribute("loginInfo") == null) {
           log.info("loginInfo is null");
           resp.sendRedirect("/login");
           return;
        }

        req.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        TodoDTO todoDTO = TodoDTO.builder()
                        .title(req.getParameter("title"))
                        .dueDate(LocalDate.parse(req.getParameter("dueDate"), DATEFORMATTER))
                        .build();


        log.info("todoRegisterController > doPost");
        log.info(todoDTO);
        try{
            todoService.INSTANCE.register(todoDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect("/todo/list");
    }
}
