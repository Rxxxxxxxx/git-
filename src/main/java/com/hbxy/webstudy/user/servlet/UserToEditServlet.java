package com.hbxy.webstudy.user.servlet;

import com.hbxy.webstudy.user.dao.UserDAO;
import com.hbxy.webstudy.user.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class UserToEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //1、获得需要修改的用户 id
            int userId = Integer.parseInt(request.getParameter("userId"));
            //2、从数据库查询该用户信息
            //TODO:数据库代码
            UserDAO dao=new UserDAO();
            User user =dao.find(userId);
            request.setCharacterEncoding("utf-8");
            /*User user =new User();
            user.setUserId(160001);
            user.setUserName("张三");
            user.setClazz("软件 1601");
            user.setUserNo("160001");
            user.setSex("0");
            user.setBirthPlace("河北");
            user.setAddress("黄骅市学院路 1 号");*/
            //3、把 user 放进 request
            request.setAttribute("user", user);
            //4、forward 到修改用户信息页面
            request.getRequestDispatcher("/jsp/user/useredit.jsp").
                    forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}