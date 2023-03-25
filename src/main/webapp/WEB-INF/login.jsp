<%--
  Created by IntelliJ IDEA.
  User: 孙明
  Date: 2023/3/18
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="user" method="get">
    <input type="hidden" name="opr" value="login">
    账号：<input type="text" name="account"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
