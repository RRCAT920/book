<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%@ include file="/pages/common/head.jsp" %>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">网上书城</span>
    <div>
        <a href="pages/user/login.jsp">登录</a> |
        <a href="pages/user/register.jsp">注册</a> &nbsp;&nbsp;
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="" method="get">
                价格：<input id="min" type="text" name="min" value=""> 元 -
                <input id="max" type="text" name="max" value=""> 元
                <input type="submit" value="查询"/>
            </form>
        </div>
        <div style="text-align: center">
            <span>您的购物车中有3件商品</span>
            <div>
                您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
            </div>
        </div>
        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.imgPath}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button>加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <div id="page_nav">
        <%--大于首页才显示--%>
        <c:if test="${requestScope.page.number > 1}">
            <a href="client/book?action=paging&number=1">首页</a>
            <a href="client/book?action=paging&number=${requestScope.page.number - 1}">上一页</a>
        </c:if>

        <%--页码输出开始--%>
        <c:choose>
            <%--总页码小于等于5，页码范围[1,总页码]--%>
            <c:when test="${requestScope.page.totalNumber <= 5}">
                <c:set var="begin" value="1"/>
                <c:set var="end" value="${requestScope.page.totalNumber}"/>
            </c:when>
            <%--总页码>5，页码范围[总页码-4,总页码]--%>
            <c:when test="${requestScope.page.totalNumber > 5}">
                <c:choose>
                    <%--当前页码1,2,3，页码范围[1,5]--%>
                    <c:when test="${requestScope.page.number <= 3}">
                        <c:set var="begin" value="1"/>
                        <c:set var="end" value="5"/>
                    </c:when>
                    <%--当前页码 总页码-2,总页码-1,总页码，页码范围[总页码-4,总页码]--%>
                    <c:when test="${requestScope.page.number > requestScope.page.totalNumber - 3}">
                        <c:set var="begin" value="${requestScope.page.totalNumber - 4}"/>
                        <c:set var="end" value="${requestScope.page.totalNumber}"/>
                    </c:when>
                    <%--其他(4,5,6,7,8)，页码范围[当前页码-2,当前页码+2]--%>
                    <c:otherwise>
                        <c:set var="begin" value="${requestScope.page.number - 2}"/>
                        <c:set var="end" value="${requestScope.page.number + 2}"/>
                    </c:otherwise>
                </c:choose>
            </c:when>
        </c:choose>

        <c:forEach begin="${begin}" end="${end}" var="i">
            <c:if test="${i == requestScope.page.number}">
                [${i}]
            </c:if>
            <c:if test="${i != requestScope.page.number}">
                <a href="client/book?action=paging&number=${i}">${i}</a>
            </c:if>
        </c:forEach>
        <%--页码输出结束--%>

        <%--最后一页则不显示--%>
        <c:if test="${requestScope.page.number < requestScope.page.totalNumber}">
            <a href="client/book?action=paging&number=${requestScope.page.number + 1}">下一页</a>
            <a href="client/book?action=paging&number=${requestScope.page.totalNumber}">末页</a>
        </c:if>

        共${requestScope.page.totalNumber}页，${requestScope.page.totalRecordsNumber}条记录
        到第<input value="${param.number}" name="pn" id="pn_input"/>页
        <input id="searchPageBtn" type="button" value="确定">
        <script>
            $(function () {
                // 危险：如果在地址栏输入url可以跳过此校验
                $("#searchPageBtn").click(function () {
                    let prefix = ${pageScope.basePath} +"client/book?action=paging&number=";
                    let number = $("#pn_input").val();
                    number = number < 1 ? 1 : number;
                    number = number > ${requestScope.page.totalNumber} ?
                        ${requestScope.page.totalNumber} : number;
                    // 地址栏对象的href属性可以读写地址
                    location.href = prefix + number;
                })
            })
        </script>
    </div>

</div>

<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>