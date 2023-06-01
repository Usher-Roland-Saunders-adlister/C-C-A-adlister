<%@ page import="com.codeup.adlister.models.Ad" %><%--
  Created by IntelliJ IDEA.
  User: coleusher
  Date: 5/31/23
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Ad Page</title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<form action="/updateAd" method="POST">
    <div class="form-group">
        <input type="hidden" name="adId" value="${adId}">

        <label for="title">Title</label>
        <input id="title" name="adTitle" class="form-control" type="text">
    </div>
    <div class="form-group">
        <label for="description">Description</label>
        <textarea id="description" name="adDescription" class="form-control" type="text"></textarea>
    </div>
    <input type="submit" class="btn btn-block btn-primary">
</form>

</body>
</html>
