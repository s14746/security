<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <title>Users</title>
    <h2>Users</h2>
</head>
<body>
<h5>Users</h5>
<a href="/userProfile">User profile</a>

<table align="center">
    <tr>
        <th>Username</th>
        <th>E-Mail</th>
        <th>Role</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td align="center"><c:out value="${user.username}"/></td>
            <td align="center"><c:out value="${user.email}"/></td>
            <td align="center"><c:out value="${user.userRole}"/></td>
            <td align="center">
                <c:if test="${user.userRole == 'REGULAR'}">
                    <form action="/users/addPremiumUserRole" method="post">
                        <input type="hidden" name="username" value="${user.username}"/>
                        <input type="submit" value="Add"/>
                    </form>
                </c:if>
                <c:if test="${user.userRole == 'PREMIUM'}">
                    <form action="/users/removePremiumUserRole" method="post">
                        <input type="hidden" name="username" value="${user.username}"/>
                        <input type="submit" value="Remove"/>
                    </form>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>