<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024/3/30
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(!(request.getAttribute("message")==null)){
        out.println((request.getAttribute("message")));
    }
%>
<form method="post" action="login">
    Username:<input type="text" name="username"><br/>
    Password:<input type="text" name="password"><br/>
    <input type="submit" value="Login"/>
</form>
<%@include file="footer.jsp"%>