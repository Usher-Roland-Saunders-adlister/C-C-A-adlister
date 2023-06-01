<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: amir.saunders
  Date: 5/31/23
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>This is the view clicked Ad page</h1>

    <div class="col-md-6">
        <h2>${clickAd.title}</h2>
        <p>${clickAd.description}</p>
    </div>

</body>
</html>
