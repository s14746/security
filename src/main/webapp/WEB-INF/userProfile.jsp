<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <title>User profile</title>
    <h2>User profile</h2>
</head>
<body>

<table>
    <tr>
        <td>Username</td>
        <td><c:out value="${userProfile.username}"/></td>
    </tr>
    <tr>
        <td>E-Mail</td>
        <td><c:out value="${userProfile.email}"/></td>
    </tr>
    <tr>
        <td>Role</td>
        <td><c:out value="${userProfile.userRole}"/></td>
    </tr>
    <tr>
        <td></td>
        <td><a href="/logoutUser">Logout</a></td>
    </tr>
    <c:if test="${userProfile.userRole != 'REGULAR'}">
        <tr>
            <td></td>
            <td><a href="/premium">Premium</a></td>
        </tr>
    </c:if>
    <c:if test="${userProfile.userRole == 'ADMIN'}">
        <tr>
            <td></td>
            <td><a href="/users">Users</a></td>
        </tr>
    </c:if>
</table>
</body>
</html>