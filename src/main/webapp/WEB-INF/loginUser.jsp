<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <title>Login</title>
    <h2>Login to the service</h2>
</head>
<body>

<c:if test="${error != null}">
    <p style="color: red;"><c:out value="${error}"/></p>
</c:if>

<form method="POST" action="/loginUser">
    <table>
        <tr>
            <td>Username</td>
            <td><input name="username" type="text" required="required"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input name="password" type="password" required="required"/></td>
        </tr>
        <tr>
            <td>&nbsp</td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Log in"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><a href="/registerUser">Sign up</a></td>
        </tr>
    </table>
</form>
</body>
</html>