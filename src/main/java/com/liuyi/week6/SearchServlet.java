package com.liuyi.week6;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/search" )
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text1 = request.getParameter("text");
        String search1 = request.getParameter("search");
        //System.out.println(text1);
        //System.out.println(search1);

        if(text1.equals("")){
            response.sendRedirect("index.jsp");
        }else {
            if(search1.equals("baidu")){
                response.sendRedirect("https://www.baidu.com/?/"+text1);
            }else if(search1.equals("bing")){
                response.sendRedirect("https://cn.bing.com/?FORM=Z9FD1"+text1);
            }else if(search1.equals("google")){
                response.sendRedirect("https://www.google.com.hk/index.html"+text1);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
