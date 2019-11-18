package com.ruixu.webstudy.c01;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RefreshServlet extends  HttpServlet{
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        response.setHeader("Refresh", "2;URL=http://www.bjtuhbxy.cn");
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
