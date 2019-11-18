package com.ruixu.webstudy.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ChineseServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String data = "中国";
        PrintWriter out = response.getWriter();
        out.println(data);
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
