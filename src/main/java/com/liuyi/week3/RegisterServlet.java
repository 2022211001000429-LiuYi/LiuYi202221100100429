package com.liuyi.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=request.getParameter("username" );
        String userpsd=request.getParameter("userpsd" );
        String useremail=request.getParameter("useremail" );
        String Gender=request.getParameter("Gender" );
        String userbirth=request.getParameter("userbirth" );

        PrintWriter writer= response.getWriter();
        writer.println("<br>username:"+username);
        writer.println("<br>userpsd:"+userpsd);
        writer.println("<br>useremail:"+useremail);
        writer.println("<br>Gender:"+Gender);
        writer.println("<br>userbirth:"+userbirth);
        writer.close();
    }
}
