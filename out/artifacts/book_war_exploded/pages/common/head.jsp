<%--
  User: huzihao
  Date: 2020/10/22
  Time: 21:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort() + "/"
            + request.getContextPath() + "/";
%>
<!-- base的href属性最佳实践 -->
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script src="static/script/jquery-3.5.1.min.js"></script>