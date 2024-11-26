<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>${data} Not Found$</title>
</head>
<body>
<h1 class="text-2xl text-red-500">${data} Not Found</h1>
<div class="text-center">
    <c:if test="${message != null}">
        <div>${message}</div>
    </c:if>

    <div>
        <a href="${pageContext.request.contextPath}/">Home</a>
    </div>
</div>
</body>
</html>
