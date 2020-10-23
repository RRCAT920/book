<%--
  User: huzihao
  Date: 2020/10/24
  Time: 01:36
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <%--大于首页才显示--%>
    <c:if test="${requestScope.page.number > 1}">
        <a href="${requestScope.page.url}&number=1">首页</a>
        <a href="${requestScope.page.url}&number=${requestScope.page.number - 1}">上一页</a>
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
            <a href="${requestScope.page.url}&number=${i}">${i}</a>
        </c:if>
    </c:forEach>
    <%--页码输出结束--%>

    <%--最后一页则不显示--%>
    <c:if test="${requestScope.page.number < requestScope.page.totalNumber}">
        <a href="${requestScope.page.url}&number=${requestScope.page.number + 1}">下一页</a>
        <a href="${requestScope.page.url}&number=${requestScope.page.totalNumber}">末页</a>
    </c:if>

    共${requestScope.page.totalNumber}页，${requestScope.page.totalRecordsNumber}条记录
    到第<input value="${param.number}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
    <script>
        $(function () {
            // 危险：如果在地址栏输入url可以跳过此校验
            $("#searchPageBtn").click(function () {
                let prefix = "${pageScope.basePath}${requestScope.page.url}&number=";
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