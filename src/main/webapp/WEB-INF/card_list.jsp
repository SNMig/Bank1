<%--
  Created by IntelliJ IDEA.
  User: 孙明
  Date: 2023/3/21
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
  <script>
    function update(id){
        location.href="card?opr=initUpdate&id="+id;
    }
    function delById(id){
        if (confirm("确认删除吗？")){
            location.href="card?opr=del&id="+id;
        }
    }
  </script>
</head>
<body>
<form action="card" method="post">
    <table border="1px">
        <tr align="center">
            <td><input type="checkbox" name="id"></td>
            <td>序号</td>
            <td>卡号</td>
            <td>余额</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${requestScope.cards}" var="card" varStatus="s">
            <tr align="center">
                <td><input type="checkbox" name="id" value="${card.id}"></td>
                <td>${s.count}</td>
                <td>${card.cardNum}</td>
                <td>${card.balance}</td>
                <td><button type="button" onclick="update(${card.id})">修改</button>
                <a href="javascript:void(0)" onclick="delById('${card.id}')">删除</a></td>
            </tr>

        </c:forEach>
    </table>
    <input type="submit" value="删除">
</form>
</body>
</html>
