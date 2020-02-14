<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List of users</title>
</head>
<body>
<h2>List of users:</h2>

<br/>

<table>
    <tr>
        <th>Login</th>
        <th>Email</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Role</th>
    </tr>

    <c:forEach var="user" items="${users}">


        <c:url var="getUser" value="/admin/getUser">
            <c:param name="userId" value="${user.id}" />
        </c:url>

        <c:url var="deleteUser" value="/admin/deleteUser">
            <c:param name="userId" value="${user.id}" />
        </c:url>


        <tr>
            <td>${user.login}</td>
            <td>${user.email}</td>
            <td>${user.userDetails.name}</td>
            <td>${user.userDetails.surName}</td>
            <td>${user.userDetails.role}</td>

            <td>

                <a href="${getUser}">Edit</a>
                |

            </td>
            <td>

                <a href="${deleteUser}">Delete</a>
                |

            </td>

        </tr>

    </c:forEach>

</table>
<br/>

<form:form action="/myspringmvc/login/processForm">
    <input type="submit" value="log out"/>
</form:form>

</body>
</html>