<%--
  User: jade
  Date: 2024. 11. 25.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
</head>
<body>
<h1>Shop Main</h1>
<h3>${version}</h3>
<ul>
    <c:forEach items="${keys}" var="k">
        <li>${k}</li>
    </c:forEach>
</ul>
</body>
</html>
