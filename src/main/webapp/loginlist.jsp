<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024/3/30
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>


<%@page import="com.liuyi.week3.emp" %>
<%@ page import="java.util.List" %>

<%@page import="com.liuyi.week5.LoginServlet" %>
<%@ page import="com.sun.glass.ui.Pixels" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录结果</title>
</head>
<body>
    <%

        //if(username.equals()&&password.equals()){
        //    response.getWriter().println("Login Success!!!");
        //    response.getWriter().println("Welcome"+info.getUsername());
        //}else {
        //    response.getWriter().println("Username or Password Error!!!");
        //}

        List<emp> list=(List<emp>) request.getAttribute("list");// WEEK 6
        if(list==null||list.size()<1){
            System.out.print("没有信息！");
        }else {
            for(emp info:list){
                info.getUsername();

    %>
    <%
            }//END OF FOR
        }//END OF ELSE
    %>
</body>
</html>
