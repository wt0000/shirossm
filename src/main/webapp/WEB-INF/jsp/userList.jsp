<%--
  Created by IntelliJ IDEA.
  User: T440s
  Date: 2021/12/8
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<a href="/shirossm/goEdit">新增</a>
<table width="50%" border="1" align="center">
    <tr>
        <td>用户编号</td>
        <td>用户名</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${users}" var="i">
        <tr>
            <td>${i.userid}</td>
            <td>${i.username}</td>
            <td>
                <a href="/shirossm/goUpd?userId=${i.userid}">修改</a>
                <a href="javascript:mya(${i.userid})">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<script>
    function mya(userid){
        var f=confirm("确认删除？")
        if(f){
            location.href="/shirossm/user/deluser?userId="+userid;
        }
    }
</script>
</body>
</html>
