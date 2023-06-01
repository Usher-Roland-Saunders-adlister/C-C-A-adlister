<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: amir.saunders
  Date: 5/30/23
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>Ads your looking for</h1>

    <h1>Search Results</h1>
<%--    <p>Search Results: ${searchResults}</p>--%>

<%--    <c:forEach var="result" items="${searchResults}">--%>
<%--        <div class="col-md-6">--%>
<%--            <h2>${result.title}</h2>--%>
<%--            <p>${result.description}</p>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
<%--    <form action="/ResultsServlet" method="GET">--%>
<%--        <div class="form-group">--%>
<%--            <p>View Ad</p>--%>
<%--        </div>--%>
<%--        <input type="submit" class="btn btn-primary btn-block">--%>
<%--    </form>--%>


    <c:forEach var="result" items="${searchResults}">
        <div class="col-md-6">
            <h2>${result.title}</h2>
            <p>${result.description}</p>
            <form action="/ResultsServlet" method="GET">
                <div class="form-group">
                    <input type="hidden" name="title" value="${result.title}">
                    <input type="hidden" name="description" value="${result.description}">
                </div>
            </form>
        </div>
    </c:forEach>
</body>
</html>
