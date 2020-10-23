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
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/book?action=getBook&id=${book.id}">修改</a></td>
                <td>
                    <a href="manager/book?action=delete&id=${book.id}" class="deleteClass">删除</a>
                </td>
            </tr>
        </c:forEach>


        <tr>
            <%--6个td占位符--%>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
        </tr>
    </table>
    <div id="page_nav">
        <%--大于首页才显示--%>
        <c:if test="${requestScope.page.number > 1}">
            <a href="manager/book?action=paging&number=1">首页</a>
            <a href="manager/book?action=paging&number=${requestScope.page.number - 1}">上一页</a>
        </c:if>

        <a href="#">3</a>
        [${requestScope.page.number}]
        <a href="#">5</a>

        <%--最后一页则不显示--%>
        <c:if test="${requestScope.page.number < requestScope.page.totalNumber}">
            <a href="manager/book?action=paging&number=${requestScope.page.number + 1}">下一页</a>
            <a href="manager/book?action=paging&number=${requestScope.page.totalNumber}">末页</a>
        </c:if>

        共${requestScope.page.totalNumber}页，${requestScope.page.totalRecordsNumber}条记录
        到第<input value="${param.number}" name="pn" id="pn_input"/>页
        <input id="searchPageBtn" type="button" value="确定">
        <script>
            $(function () {
                $("#searchPageBtn").click(function () {
                    let number = $("#pn_input").val();
                    // 地址栏对象的href属性可以读写地址
                    let prefix = "http://localhost:8080/book/manager/book?action=paging&number=";
                    location.href = prefix + number;
                })
            })
        </script>
    </div>
</div>

<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>