package com.edu.controller;

import com.edu.consts.Const;
import com.edu.exception.MyException;
import com.edu.pojo.User;
import com.edu.service.IUserService;
import com.edu.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Autowired
    private IUserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    WebApplicationContext applicationContext= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

         userService = applicationContext.getBean(IUserService.class);
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = userService.login(username, password);
            HttpSession session = request.getSession();
            Cookie cookie_username=new Cookie(Const.COOKIE_USERNAME, username);
            cookie_username.setMaxAge(7*24*3600);
            Cookie cookie_password=new Cookie(Const.COOKIE_PASSWORD, password);
            cookie_password.setMaxAge(7*24*3600);
            response.addCookie(cookie_password);
            response.addCookie(cookie_username);
            session.setAttribute(Const.CURRENT_USER, user);
            request.getRequestDispatcher("login.jsp").forward(request, response);

        /*    *//**
             * url重写 如果客户关闭了cookie
             *//*
            String redictUl= response.encodeRedirectURL("login.jsp");
            response.sendRedirect(redictUl);*/
        } catch (MyException e) {
            String msg = e.getMessage();
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        String method = request.getParameter("method");
        if (method.equals("out")){
            HttpSession session = request.getSession();
            session.removeAttribute(Const.CURRENT_USER);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request, response);

    }
}
