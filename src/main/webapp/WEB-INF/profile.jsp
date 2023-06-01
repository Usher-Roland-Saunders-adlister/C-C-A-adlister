<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here are all your ads ${sessionScope.user.username}!</h1>

    <c:forEach var="ad" items="${userAds}">
        <div class="col-md-6">
            <h2><a href="/ShowAdServlet?id=${ad.id}">${ad.title}</a></h2>
            <p>${ad.description}</p>
        </div>
    </c:forEach>


        <button onclick="window.location.href='/update'">Update</button>
        <button onclick="window.location.href='/delete'">Delete</button>
        <button onclick="window.location.href='/ads/create'">Create Ad</button>
</div>
</body>
</html>