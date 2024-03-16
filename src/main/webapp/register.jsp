<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024/3/11
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New User Registration !!</title>
</head>
<body>
<form method="post" action="register">
    New User Registration !!<br/>
    <input name="username" type="text" placeholder="Username" size="30" required/><br/>
    <input name="userpsd" type="password" placeholder="Password" size="30" minlength="8" required/><br/>

    <input name="useremail" type="text" placeholder="Email" size="30" required/><br/>
    Gender:
    <input name="Gender" type="radio" value="Male"/>Male
    <input name="Gender" type="radio" value="Female"/>Female<br/>
    Date of Birth: <input name="userbirth" type="date" required/><br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
