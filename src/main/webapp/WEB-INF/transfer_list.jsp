<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="transfer" method="get">
    <input type="hidden" name="opr" value="search"><br>
    查询账号：<select name="cardNum" id="">
    <c:forEach items="${cards}" var="card">
        <option>${card.cardNum}</option>
    </c:forEach>
</select><br>
    <input type="submit" value="查询">
</form>
<table border="1px">
    <tr align="center">
        <td>序号</td>
        <td>转出卡号</td>
        <td>转帐金额</td>
        <td>收款人名字</td>
        <td>收款人卡号</td>
        <td>转帐时间</td>
    </tr>
    <c:forEach items="${requestScope.transfers}" var="transfer" varStatus="s">
        <tr align="center">
            <td>${s.count}</td>
            <td>${transfer.transferOutNum}</td>
            <td>${transfer.amount}</td>
            <td>${transfer.name}</td>
            <td>${transfer.transferInNum}</td>
            <td>${transfer.transferTime}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
