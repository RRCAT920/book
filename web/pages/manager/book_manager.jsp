<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%@ include file="/pages/common/head.jsp" %>
    <script>
        $(function () {
            // a标签删除的确认提示
            $("a.deleteClass").click(function () {
                // 事件处理器中的this: 正在响应事件的dom对象

                // true: 确认
                // false: 取消
                return confirm("你确认要删除[" + $(this).parent().parent().find("td:first").text() + "]?");
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
    <%@ include file="/pages/common/manager_menu.jsp" %>

</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <%--        从request域获取图书信息--%>
        <%--        使用JSTL遍历输出--%>
        <c:forEach items="${requestScope.bookList}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="book_edit.jsp">修改</a></td>
                <td>
                    <a href="manager/book?action=delete&id=${book.id}" class="deleteClass">删除</a>
                </td>
            </tr>
        </c:forEach>


        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
        </tr>
    </table>
</div>

<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>