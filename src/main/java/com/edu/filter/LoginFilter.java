package com.edu.filter;
import com.edu.consts.Const;
import com.edu.dao.IUserDao;
import com.edu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/user/*")
public class LoginFilter implements Filter {
    @Autowired
     private IUserDao service;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        //判断用户是否登录
       HttpSession session=request.getSession();
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user!=null){
        //用户已经登录不拦截
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        Cookie[] cookies = request.getCookies();
        if(cookies!=null&&cookies.length>0){
            String username=null;
            String password=null;
            for (Cookie c:cookies
                 ) {
                String name=c.getName();
            if(name.equals(Const.COOKIE_USERNAME)){
                username=c.getValue();
            }
            if(name.equals(Const.COOKIE_PASSWORD)){
                password=c.getValue();
            }

            }

        if(username==null||password==null){
        response.sendRedirect("index.jsp");
        return;
        }
                User user1=service.findUserAndPwd(username, password);
            if(user1==null){
                response.sendRedirect("index.jsp");
            }else{
                session.setAttribute(Const.CURRENT_USER, user1);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }

         }else {
            //没有cookies 重定向
            response.sendRedirect("index.jsp");
        }

    }

    @Override
    public void destroy() {

    }
}
