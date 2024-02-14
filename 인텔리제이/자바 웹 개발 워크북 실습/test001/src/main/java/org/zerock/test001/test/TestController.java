package org.zerock.test001.test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestController", urlPatterns = "/todo/register")
public class TestController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String[] hobbies = req.getParameterValues("hobbies");
        String travel = req.getParameter("travel");
        String content = req.getParameter("content");

        req.setAttribute("name", name);
        req.setAttribute("id", id);
        req.setAttribute("password", password);
        req.setAttribute("age", age);
        req.setAttribute("gender", gender);
        req.setAttribute("hobbies", hobbies);
        req.setAttribute("travel", travel);
        req.setAttribute("content", content);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/list.jsp");
        dispatcher.forward(req, resp);
    }
}
