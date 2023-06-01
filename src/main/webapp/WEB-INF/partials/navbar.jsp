<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Marketplace Connect</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <%-- Display login button if user is not logged in --%>
            <% if (session.getAttribute("user") == null) { %>
            <li><a href="/login">Login/Register</a></li>
            <% } %>

            <%-- Display logout button if user is logged in --%>
            <% if (session.getAttribute("user") != null) { %>
            <li><a href="/logout">Logout</a></li>
            <% } %>
        </ul>
    </div>
</nav>