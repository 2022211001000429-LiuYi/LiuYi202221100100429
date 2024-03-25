<%@ page import="java.util.List" %>
<%@page import="com.liuyi.week3.emp" %>
<!-- WEEK 5 -->
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024/3/25
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有用户信息</title>
</head>
<body>
<table border="1" bordercolor="#000000">
    <caption>users information</caption>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Birthdate</th>
    </tr>
    <!-- week 5--->

    <%
        List<emp> list=(List<emp>) request.getAttribute("list");// WEEK 6
        if(list==null||list.size()<1){
            System.out.print("没有信息！");
        }else {
            for(emp info:list){

            %>
    <tr>
        <td><%=info.getId()%></td>
        <td><%=info.getUsername()%></td>
        <td><%=info.getPassword()%></td>
        <td><%=info.getEmail()%></td>
        <td><%=info.getGender()%></td>
        <td><%=info.getUserbirth()%></td>
    </tr>
    <%
        }//END OF FOR
        }//END OF ELSE
    %>
</table>
</body>
</html>
