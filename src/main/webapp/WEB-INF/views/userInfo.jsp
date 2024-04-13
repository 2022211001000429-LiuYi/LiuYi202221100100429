<%@ page import="com.liuyi.model.User" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024/4/8
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%
    User user=(User) request.getAttribute("user");
%>
<h1>
 User Info
</h1>

<table>
    <tr><td>Username:</td><td><%=user.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=user.getPassword()%></td></tr>
    <tr><td>Email:</td><td><%=user.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=user.getGender()%></td></tr>
    <tr><td>Birth Date:</td><td><%=user.getUserbirth()%></td></tr>
</table>
<!--
not mvc
<table>
    <tr><td>Username:</td><td><%//=request.getAttribute("username")%></td></tr>
    <tr><td>Password:</td><td><%//=request.getAttribute("password")%></td></tr>
    <tr><td>Email:</td><td><%//=request.getAttribute("email")%></td></tr>
    <tr><td>Gender:</td><td><%//=request.getAttribute("gender")%></td></tr>
    <tr><td>Birth Date:</td><td><%//=request.getAttribute("userbirth")%></td></tr>
</table>
-->
<%@include file="footer.jsp"%>
