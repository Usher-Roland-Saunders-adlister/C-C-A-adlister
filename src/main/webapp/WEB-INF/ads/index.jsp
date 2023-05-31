<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
                <%--THIS NEEDS TO BE ATTACHED TO EACH THE PROFILE ADs--%>
            <button onclick="window.location.href='/updateAd?adId=123'">Update</button>
            <button onclick="window.location.href='/deleteAd'">Delete</button>
        </div>

    </c:forEach>

</div>

</body>
</html>
