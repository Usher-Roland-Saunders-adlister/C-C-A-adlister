<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Page</title>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Update your Profile!" />
    </jsp:include>
</head>
<body>

<jsp:include page="partials/navbar.jsp" />
<form action="/delete" method="POST">
<h1>Successfully Deleted Your Profile!</h1>
    <br>
    <input type="submit" class="btn btn-primary btn-block" value="Return to Login">
</form>

</body>
</html>
