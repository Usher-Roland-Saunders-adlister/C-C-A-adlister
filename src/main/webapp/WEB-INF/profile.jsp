<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <link rel="stylesheet" type="text/css" href="/CSS/profile.css">
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="profile-buttons" id="profile-buttons">
    <button onclick="window.location.href='/update'">Edit Profile</button>
    <button onclick="window.location.href='/delete'">Delete Profile</button>
    <button onclick="window.location.href='/ads/create'">Create New Ad</button>
</div>

<h1>Welcome ${sessionScope.user.username}! Here are all your ads</h1>


<div class="container">
    <c:forEach var="ad" items="${userAds}">
        <div class="col-md-6">

            <h2><a href="/ShowAdServlet?id=${ad.id}">${ad.title}</a></h2>
            <p>${ad.description}</p>

            <h2>${ad.getTitle()}</h2>
            <p>${ad.getDescription()}</p>
            <form action="/updateAd" method="GET">
                <button class="updateAd" id="updateBtn" name="updateBtn" value=${ad.id}>Edit</button>
                <button class="deleteAd" id="deleteBtn" name="deleteBtn" value=${ad.id}>Delete</button>
            </form>

        </div>
    </c:forEach>
</div>
</body>
</html>