<%--
  Created by IntelliJ IDEA.
  User: T440s
  Date: 2021/12/8
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑用户</title>
</head>
<body>
<form action="/shirossm/user/doEdit" method="post">
    <input type="hidden" name="userid" value="${u.userid}">
    用户名:<input type="text" name="username" value="${u.username}"><br/>
    密码:<input type="password" name="password" value="${u.password}"><br/>
    <input type="submit"/>
</form>
</body>
</html>
