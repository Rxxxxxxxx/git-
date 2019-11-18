package com.hbxy.webstudy.user.servlet;

import com.hbxy.webstudy.user.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //1、获得表单数据
            int userId=Integer.parseInt(request.getParameter("userId"));
            //2、到数据库删除用户
            //TODO:数据库代码
            UserDAO dao=new UserDAO();
            dao.delete(userId);
            //3、重定向到用户列表
            response.sendRedirect("/UserListServlet");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}