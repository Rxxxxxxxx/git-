package com.hbxy.webstudy.user.servlet;

import com.hbxy.webstudy.user.dao.UserDAO;
import com.hbxy.webstudy.user.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //1、获得表单数据
            String userName=request.getParameter("userName");
            String sex=request.getParameter("sex");
            String birthPlace=request.getParameter("birthPlace");
            String clazz=request.getParameter("clazz");
            String userNo=request.getParameter("userNo");
            String address=request.getParameter("address");
            //2、保存到数据库
            //TODO:保存到数据库代码
            User user =new User();
            user.setUserName(userName);
            user.setClazz(clazz);
            user.setUserNo(userNo);
            user.setSex(sex);
            user.setBirthPlace(birthPlace);
            user.setAddress(address);
//调用 dao 对象保存到数据库
            UserDAO dao=new UserDAO();
            dao.add(user);

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
