<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>

    <link rel="stylesheet" type="text/css" href="/CSS/login.css">
</head>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Please Log In</h1>
    <form action="${pageContext.request.contextPath}/login" method="POST">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="password">
        </div>
        <div>
            <input type="hidden" name="redirect" value="${redirect}">

            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </div>
    </form>
    <form action="${pageContext.request.contextPath}/register" method="GET">
        <input type="submit" class="btn btn-primary btn-block" value="register">
    </form>
</div>
</body>
</html>
