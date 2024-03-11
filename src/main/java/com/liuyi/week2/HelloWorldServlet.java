package com.liuyi.week2;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Date;

public class HelloWorldServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //get writer-java.io
        PrintWriter writer = response.getWriter();
        writer.println("Name:LiuYi");
        writer.println("ID:2022211001000429");
        writer.print("Date and Time :");

        Date date=new Date();
        writer.println(date);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){


    }

}
