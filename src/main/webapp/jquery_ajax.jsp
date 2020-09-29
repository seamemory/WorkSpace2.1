<%--
  Created by IntelliJ IDEA.
  User: 尘封记忆
  Date: 2020/9/27
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=application.getContextPath()%>/asserts/js/jquery-1.11.3.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.get("<%=application.getContextPath()%>/jquery",function(data){
                    alert(data);
                });
            });
            $("#btn2").click(function () {
                $.post("<%=application.getContextPath()%>/jquery",{"account":"admin","password":"12345"},function(data){
                    alert(data);
                });
            });
        })
    </script>
</head>
<body>
<button id="btn">按钮</button>
<button id="btn2">按钮1</button>
</body>
</html>
