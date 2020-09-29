<%--
  Created by IntelliJ IDEA.
  User: 尘封记忆
  Date: 2020/9/26
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示商品信息</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/asserts/js/jquery-1.11.3.js"></script>
    <style>
        table{
            width: 400px;
            border-collapse: collapse;
            text-align: center;
        }
        table,td,th{
            border: 1px solid black;
        }
    </style>
    <script>
        $(function () {
            $("#btn").click(function () {
                // 直接利用ajax进行消息发送
                $.ajax({
                    url:"<%=application.getContextPath()%>/ajax?op=like",
                    type:"post",
                    data:{
                        "name":$("#name").val()
                    },
                    success:function (data) { // data是一个json格式字符串 转化为json对象
                        console.log("接收到的数据"+data); //在浏览器控制台输出
                        var arr = JSON.parse(data);
                        console.log("转换后的数据"+arr); //在浏览器控制台输出
                        //获取table中第一行tr进行保留
                        var tr = $("#myTb").find("tr").first();
                        // 清空table
                        $("#myTb").empty();
                        // 再把第一行内容加进去
                        $("#myTb").append(tr);
                        // 遍历objjson数组对象
                        $.each(arr,function(index,p){
                            console.log("遍历数据" + index+ "------" + p)

                            $("#myTb").append("<tr>" +
                                "<td>" + p.id + "</td>" +
                                "<td>" + p.name + "</td>" +
                                "<td>" + p.description + "</td>" +
                                "<td>" + p.price + "</td>" +
                                "<td>" + p.stock + "</td>" +
                                "<td>" + p.categoryLevel1Id + "</td>" +
                                "<td>" + p.categoryLevel2Id + "</td>" +
                                "<td>" + p.categoryLevel3Id + "</td>" +
                                "<td>" + p.fileName + "</td>" +
                                "<td>" + p.isDelete + "</td>" +
                                "<td>" + p.brand_id + "</td>" +
                                "</tr>");
                        })

                    },
                    error:function () {
                        alert("数据获取失败");
                    }
                });
            });
        });
    </script>
</head>
<body>
<input type="text" id="name" placeholder="请输入一个关键名称">
    <button id="btn">搜索</button>
    <table id="myTb">
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>描述</th>
            <th>价格</th>
            <th>库存</th>
            <th>分类1</th>
            <th>分类2</th>
            <th>分类3</th>
            <th>文件名称</th>
            <th>是否删除</th>
            <th>所属品牌</th>
        </tr>
    </table>

</body>
</html>
