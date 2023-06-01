<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>

    <link rel="stylesheet" type="text/css" href="/CSS/index.css">

</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

<%--    <c:forEach var="ad" items="${ads}">--%>
<%--        <div class="col-md-6">--%>
<%--            <h2><a href=“ads/ad?id=${ad.id}“>${ad.title}</a></h2>--%>
<%--            <p>${ad.description}</p>--%>

<%--        </div>--%>
<%--    </c:forEach>--%>
<%--    <c:forEach var="ad" items="${ads}">--%>
<%--        <div class="col-md-6">--%>
<%--            <h2><a href="${"/WEB-INF/ads/ad"}?id=${ad.id}">${ad.title}</a></h2>--%>
<%--            <p>${ad.description}</p>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
<%--</div>--%>

        <c:forEach var="ad" items="${ads}">
        <div class="ad-card">
            <h2><a href="/ShowAdServlet?id=${ad.id}">${ad.title}</a></h2>
            <p>${ad.description}</p>
        </div>
        </c:forEach>

        <form action="/SearchAdsServlet" method="GET" class="search-form">
            <div class="form-group">
                <label for="user-search">Search Ads By Description or Title</label>
                <input id="user-search" name="user-search" class="form-control" type="text">
            </div>
            <input type="submit" class="btn" value="Search">
        </form>


</body>
</html>
