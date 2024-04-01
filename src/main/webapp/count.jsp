<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024/3/30
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
This is Count JSP page.<br>
<%!
    int getCount(){
        return ++count;
    }
%>
<%! int count=0;%>
The Page count is now(using count()):
<%out.println(getCount());%>
<!-- <%out.println(++count);%>  -->
</body>
</html>
