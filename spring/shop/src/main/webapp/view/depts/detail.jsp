<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<%@ include file="../head.jsp" %>

<body class="m-5">
<h1 class="text-2xl">
    Dept Manager - ${dept.dname}
    <a href="/depts" class="float-right mr-5">Go List</a>
</h1>

<form action="/depts/${dept.id}/save">
    <label for="pid">
        <select name="pid" id="pid" class="border">
            <option value="0">상위부서</option>
            <c:forEach var="pdept" items="${depts}">
                <option value="${pdept.id}">
                        ${'&nbsp;'.repeat(pdept.depth * 2)} ${pdept.dname}
                </option>
            </c:forEach>
        </select>
    </label>
    <label for=" dname">
        <input type="text" id="dname" name="dname" value="${dept.dname}">
    </label>
</form>
</body>
</html>
