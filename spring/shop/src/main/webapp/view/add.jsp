<%--
  User: jade
  Date: 2024. 11. 25.
  Time: 오후 3:20
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<%@ include file="./head.jsp" %>

<body>
<div class="container mx-auto">
    <h1 class="text-2xl text-green-800 mb-5" onclick="setDefault()">Add Cust</h1>

    <form id="frm" action="${pageContext.request.contextPath}/add" method="POST"
          class="flex flex-col space-y-3 w-96 items-center">
        <label for="name">Name:
            <input type="text" id="name" name="name" class="border rounded-md">
        </label>
        <label for="tel">Tel:
            <input type="tel" id="tel" name="tel" class="border rounded-md">
        </label>
        <label for="email">Email:
            <input type="email" id="email" name="email" class="border rounded-md">
        </label>

        <button type="submit" class="hover:text-blue-800 border rounded-md px-2 bg-slate-300 hover:bg-slate-200">
            Add Cust
        </button>
    </form>

    <script>
        function setDefault() {
            const name = document.getElementById('name');
            name.value = 'Hong';
            tel.value = '010-2222-3333';
        }
    </script>
</div>
</body>
</html>
