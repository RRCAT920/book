<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>会员登录页面</title>
    <base href="http://localhost:8080/book/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <div>
        <span>欢迎<span class="um_span">用户</span>来到书城</span>
        <a href="order/order.jsp">我的订单</a>
        <a href="index.jsp">注销</a>&nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </div>
</div>

<div id="main">

    <h1>欢迎回来 <a href="index.jsp">转到主页</a></h1>

</div>

<div id="bottom">
			<span>
				书城.Copyright &copy;2020
			</span>
</div>
</body>
</html>