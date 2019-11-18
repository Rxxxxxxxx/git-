package com.hbxy.webstudy.user.servlet;

import com.hbxy.webstudy.user.dao.UserDAO;
import com.hbxy.webstudy.user.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1、到数据查询所有用户
        //List userlist=new ArrayList();
        //TODO：数据库查询
        UserDAO dao=new UserDAO();
        List userlist=dao.findAll();
        request.setCharacterEncoding("utf-8");
        /*User user1 =new User();
        user1.setUserId(160001);
        user1.setUserName("张三");
        user1.setClazz("软件 1601");
        user1.setUserNo("160001");
        user1.setSex("0");
        user1.setBirthPlace("河北");
        user1.setAddress("黄骅市学院路 1 号");
        User user2 =new User();
        user2.setUserId(160002);
        user2.setUserName("李四");
        user2.setClazz("软件 1603");
        user2.setUserNo("160002");
        user2.setSex("1");
        user2.setBirthPlace("河北");
        user2.setAddress("黄骅市学院路 1 号");
        User user3 =new User();
        user3.setUserId(160003);
        user3.setUserName("王五");
        user3.setClazz("软件 1602");
        user3.setUserNo("160003");
        user3.setSex("0");
        user3.setBirthPlace("北京");
        user3.setAddress("长安街 1 号");
        userlist.add(user1);
        userlist.add(user2);
        userlist.add(user3);*/
        //2、把用户放进 request
        request.setAttribute("userlist",userlist);
        //3、forword 到用户列表 jsp 页面
        request.getRequestDispatcher("/jsp/user/userlist.jsp").
                forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
