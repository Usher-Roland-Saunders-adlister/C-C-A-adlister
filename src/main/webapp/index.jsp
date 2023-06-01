<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>

    <link rel="stylesheet" type="text/css" href="/CSS/home.css">

</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Welcome to Marketplace Connect!</h1>

        <button class="btn btn-primary" id="btn" onclick="window.location.href='/login'">Login</button>
    </div>
</body>
</html>
