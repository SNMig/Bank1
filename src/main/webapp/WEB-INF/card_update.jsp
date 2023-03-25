<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="card" method="post">
    <input type="hidden" name="opr" value="doUpdate">
    <input type="hidden" name="id" value="${card.id}"><br>
    <input type="text" name="cardNum" value="${card.cardNum}"><br>
    <input type="text" name="balance" value="${card.balance}"><br>
    <input type="text" name="password" value="${card.password}"><br>
    <input type="submit" value="修改"><br>
</form>
</body>
</html>
