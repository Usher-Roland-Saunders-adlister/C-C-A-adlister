<%--
  Created by IntelliJ IDEA.
  User: coleusher
  Date: 5/31/23
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Ad Page</title>
</head>
<body>

<jsp:include page="partials/navbar.jsp" />

<div class="container">
    <form action="/ads/delete" method="POST">
    <h1>Ad Successfully Deleted!</h1>
    </form>
</div>

</body>
</html>
