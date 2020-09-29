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
            $("#btn3").click(function () {
                $.getJSON("<%=application.getContextPath()%>/jquery",function(data){
                    $("#myDiv").empty();
                    $.each(data,function (index,obj) {
                        $("#myDiv").append("<p>"+obj.ename+"---"+obj.sal+"</p>");
                    })
                });
            });
            $("#myForm").submit(function(){
                var data = $("#myForm").serializeArray();
                var s = JSON.stringify(data);
                $("#myDiv").empty().text(s);
                /*// param方法
                var s = $.param(data);
                $("#myDiv").empty().text(s);*/
                $.each(data,function (index,obj) {
                    $("#myDiv").append("<p>"+obj.name+"---"+obj.value+"</p>");
                })
                return false;
            })
        })
    </script>
</head>
<body>
<button id="btn">按钮</button>
<button id="btn2">按钮2</button>
<button id="btn3">按钮3</button>
<div id="myDiv"></div>
<form action="#" method="post" id="myForm">
    <input type="text" name="account" placeholder="请输入用户名"><br>
    <input type="password" name="password" placeholder="请输入密码"><br>
    <input type="datetime-local" name="time"><br>
    <input type="number" name="num" placeholder="请输入年龄"><br>
    <input type="radio" name="sex" value="男">男<br>
    <input type="radio" name="sex" value="女">女<br>
    <input type="checkbox" name="hobby" value="唱">唱
    <input type="checkbox" name="hobby" value="跳">跳
    <input type="checkbox" name="hobby" value="rap">rap
    <input type="submit" value="提交">

</form>
</body>
</html>
