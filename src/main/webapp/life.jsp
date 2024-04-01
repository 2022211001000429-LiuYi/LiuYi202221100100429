<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024/3/30
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Life Cycle JSP</title>
</head>
<body>
<%System.out.println("i am in jspservice()");%>
</body>
<%
    public void jspDestroy(){
        System.out.println("i am in jspDestroy");
    }
%>
</html>
