<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Object admin = session.getAttribute("admin");
    if(admin==null){
        request.setAttribute("message","对不起，您好没有登录，无法直接访问，请先登录");
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
%>
<div style="...">
    <a href="<%=application.getContextPath()%>/addDept.jsp">添加类别</a>
    <a href="#">查询类别</a>
    <a href="<%=application.getContextPath()%>/dept?op=findAll">显示所有类别</a>
    <%--点击添加员工跳转到一个servlet帮我们查询所有员工领导以及所有部门信息 显示到jsp界面--%>
    <a href="<%=application.getContextPath()%>/emp?op=addFind">添加员工信息</a>
    <a href="<%=application.getContextPath()%>/emp?op=findAll">显示所有员工信息</a>

<c:if test="${empty sessionScope.admin}">
    <a href="<%=application.getContextPath()%>/login.jsp"><button>登录</button></a>
</c:if>
    <c:if test="${!empty sessionScope.admin}">
        ${admin.name}
    </c:if>
    当前已访问的人数:${applicationScope.num}
</div>