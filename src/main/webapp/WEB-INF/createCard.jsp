<%--
  Created by IntelliJ IDEA.
  User: 孙明
  Date: 2023/3/18
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
<form action="createCard" method="get">
    卡号：<input type="text" name="cardNum"><br>
    密码:<input type="password" name="password1"><br>
    确认密码：<input type="password" name="password2"><br>
    预存金额：<input  type="text" name="balance"><br>
    <input type="submit" value="开卡">
</form>

</body>
</html>
