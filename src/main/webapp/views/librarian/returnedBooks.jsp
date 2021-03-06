<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="../../resources/css/custom.css"/>

<html>
<head>
    <title>Librarian board</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<jsp:include page="../layout/_menu.jsp"></jsp:include>

<div class="container">
    <h2>Given books</h2>
    <table class="table table-striped">
        <thead>
        <tbody>
        <tr>
            <th>Order ID</th>
            <th>User ID</th>
            <th>Book ID</th>
            <th>Location</th>
            <th>Status</th>
            <th>Return book</th>
        </tr>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.userId}</td>
                <td>${order.bookId}</td>
                <td>${order.location}</td>
                <td>${order.status}</td>
                <td>
                    <form action="/return/${order.id}" method="POST">
                        <label class="switch">
                            <input type="checkbox"
                                   onchange="submit()">
                            <span class="slider round"></span>
                        </label>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
