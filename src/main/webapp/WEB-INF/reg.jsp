<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="/js/laydate.js"></script>
    <script>
        laydate.render({
            elem:"#test1"
        })
    </script>
</head>
<body>
${msg}
<form action="user" method="get">
    <input type="hidden" name="opr" value="reg">
    账号：<input type="text" name="account" value="${newAccount.account}"><br>
    密码：<input type="password" name="password" id="pw" onblur="length()"><br>
    确认密码：<input type="password" name="cfmPassWord"><br>
    姓名：<input type="text" name="name"><br>
    出生年份：<input type="text" id="test1" name="birthdate" ><br>
    身份证：<input type="text" name="idNum"><br>
    手机号：<input type="text" name="tellNum"><br>
    <input type="submit" value="注册">
</form>

</body>
</html>