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

        <h1>Welcome, ${sessionScope.user.username}!</h1>

        <c:forEach var="ad" items="${ads}">
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>
        <form action="/updateAd" method="POST">
                <%--THIS NEEDS TO BE ATTACHED TO EACH THE PROFILE ADs--%>
            <button name="update" id="update" value="${ad.id}">Update</button>
            <button name="delete" id="delete" value="${ad.title}">Delete</button>
        </form>

            </div>

        </c:forEach>
        <button onclick="window.location.href='/update'">Update</button>
        <button onclick="window.location.href='/delete'">Delete</button>
        <button onclick="window.location.href='/ads/create'">Create Ad</button>



</body>
</html>
