<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 尘封记忆
  Date: 2020/9/27
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.UUID"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
${massage}
<from action="<%=application.getContextPath()%>/admin" method="post">
    <input type="text" name="account" placeholder="请输入账号">
    <input type="password" name="password" placeholder="请输入密码">
    <input type="submit" value="登录">

</from>
</body>
</html>
