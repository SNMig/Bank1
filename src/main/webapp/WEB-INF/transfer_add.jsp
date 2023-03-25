<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="transfer" method="get">
    <input type="hidden" name="opr" value="add">
    转出卡号：
    <select name="transferOutNum" id="">
    <c:forEach items="${cards}" var="card">
        <option>${card.cardNum}</option>
    </c:forEach>
</select>
    <br>
    转入卡号：<input type="text" name="transferInNum"><br>
    转账金额：<input type="text" name="money"><br>
    <input type="submit" value="转账">
</form>
</body>
</html>
