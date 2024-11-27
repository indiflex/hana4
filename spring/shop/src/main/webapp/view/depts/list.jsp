<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<%@ include file="../head.jsp" %>

<body class="m-5">
<h1 class="text-2xl">Dept Manager</h1>
<ul class="border p-5">
    <c:forEach var="dept" items="${depts}">
        <li class="pl-${dept.depth * 3} <c:if test="${dept.isTop}">text-green-600 font-bold</c:if>">
            <c:if test="${dept.pid != 0}">
                <span class="text-slate-400">Ḻ</span>
            </c:if>
                ${dept.dname}
        </li>
    </c:forEach>
</ul>
</body>
</html>
