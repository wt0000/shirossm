<%--
  Created by IntelliJ IDEA.
  User: T440s
  Date: 2021/12/7
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>主界面</title>
</head>
<body>
<ul>
    <s:hasRole name="管理员">
        <li><a href="user/userList">用户管理</a></li>
    </s:hasRole>
    <s:hasPermission name="书本查询">
        <li>用户新增</li>
    </s:hasPermission>
    <li>用户删除</li>
    <li>用户修改</li>
</ul>
</body>
</html>
