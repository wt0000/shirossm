<%--
  Created by IntelliJ IDEA.
  User: T440s
  Date: 2021/12/7
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<form action="login" method="post">
    ${map.message}<br/>
    账号：<input type="text" name="username"><br/>
    密码：<input type="password" name="password"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
