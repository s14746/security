<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <title>Registration</title>
    <h2>Registration</h2>
</head>
<body>

<c:if test="${error != null}">
    <p style="color: red;"><c:out value="${error}"/></p>
</c:if>

<form method="POST" action="/registerUser">
    <table>
        <tr>
            <td>Username</td>
            <td><input name="username" type="text" required="required" value="${registerUserRequest.username}"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input name="password" type="password" required="required" value="${registerUserRequest.password}"/></td>
        </tr>
        <td>Confirm password</td>
        <td><input name="confirmPassword" type="password" required="required" value="${registerUserRequest.confirmPassword}"/></td>
        <tr>
            <td>Email</td>
            <td><input name="email" type="email" required="required" value="${registerUserRequest.email}"/></td>
        </tr>
        <tr>
            <td>&nbsp</td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Sign up"/>
            </td>
        </tr>
    </table>
</form>
</form>
</body>
</html>