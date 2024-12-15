package com.laze.w2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sampleServlet", urlPatterns = "/sample")
public class SampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SampleServlet > doGet + this " + this);
    }

    @Override
    public void destroy() {
        System.out.println("SampleServlet > destroy");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("SampleServlet > init > config = " + config);
    }
}
