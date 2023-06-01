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
            <h2>${ad.getTitle()}</h2>
            <p>${ad.getDescription()}</p>
            <form action="/updateAd" method="GET">
                <button class="updateAd" id="updateBtn" name="updateBtn" value=${ad.id}>Edit</button>
                <button class="deleteAd" id="deleteBtn" name="deleteBtn" value=${ad.id}>Delete</button>
            </form>
        </div>
    </c:forEach>

<div class="profile-buttons" id="profile-buttons">
        <button onclick="window.location.href='/update'">Edit</button>
        <button onclick="window.location.href='/delete'">Delete</button>
        <button onclick="window.location.href='/ads/create'">Create Ad</button>
</div>

</div>
</body>
</html>