<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="../../resources/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="../../resources/jquery/jquery-3.3.1.min.js"></script>
    <script src="../../resources/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../../resources/css/custom.css"/>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">LibApp</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/books">Catalog</a></li>
            <li><a href="${pageContext.request.contextPath}/admin">Admin board </a></li>
            <li><a href="${pageContext.request.contextPath}/">Add user(null)</a></li>
            <li><a href="${pageContext.request.contextPath}/requested-books">Requested books</a></li>
            <li><a href="${pageContext.request.contextPath}/returned-books">Returned books</a></li>
            <li><a href="${pageContext.request.contextPath}/addBook">Add book</a></li>

        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <span class="glyphicon glyphicon-user"></span>   ${user.name}<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="/profile"><i class="icon-envelope"></i> Edit profile</a></li>
                    <li class="divider"></li>
                    <li><a href="/auth/logout"><i class="icon-off"></i> Log out</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">EN<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="/"><i class="icon-envelope"></i>EN(null)</a></li>
                    <li><a href="/"><i class="icon-off"></i>RU(null)</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
</div>

</body>