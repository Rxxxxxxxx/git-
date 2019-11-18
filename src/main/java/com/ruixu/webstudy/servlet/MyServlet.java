package com.ruixu.webstudy.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("username", "admin");
        request.setAttribute("password", "123");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/myjsp.jsp");
        dispatcher.forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

