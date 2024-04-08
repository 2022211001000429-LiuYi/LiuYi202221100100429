package com.liuyi.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", urlPatterns = {"/redirect"})
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("before redirect");
        //response.sendRedirect("index.jsp");
        System.out.println("after redirect");
        //response.sendRedirect("/index.jsp");//http://localhost:8080/index.jsp
        //response.sendRedirect("/LiuYi202221100100429_war_exploded//index.jsp");
        response.sendRedirect("https://www.baidu.com/?/");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
