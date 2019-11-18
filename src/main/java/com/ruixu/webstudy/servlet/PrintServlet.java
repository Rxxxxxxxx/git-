package com.ruixu.webstudy.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PrintServlet extends  HttpServlet{
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        String data = "the flash";
        PrintWriter print = response.getWriter();
        print.write(data);
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
