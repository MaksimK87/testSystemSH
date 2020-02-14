<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>updating</title>
    <style>
        .error {
            color: red
        }
    </style>
</head>
<body>
<form:form action="updateUser" modelAttribute="user">

    Login: <form:input placeholder="login" path="login" value="${user.login}"/>
    <form:errors path="login" cssClass="error"/>
    <br/>
    Password: <form:password placeholder="password" path="password" value="${user.password}"/>
    <form:errors path="password" cssClass="error"/>
    <br/>
    Email: <form:input placeholder="email" path="email" value="${user.email}"/>
    <form:errors path="email" cssClass="error"/>
    <br/>
    Name: <form:input placeholder="name" path="userDetails.name" value="${user.userDetails.name}"/>
    <form:errors path="userDetails.name" cssClass="error"/>
    <br/>
    Surname: <form:input placeholder="surname" path="userDetails.surName" value="${user.userDetails.surName}"/>
    <form:errors path="userDetails.surName" cssClass="error"/>
    <br/>
    Role: <form:input placeholder="role" path="userDetails.role" value="${user.userDetails.role}"/>
    <form:errors path="userDetails.surName" cssClass="error"/>
    <br/>
    <input type="submit" value="Update">

</form:form>
<br/>
<form:form action="/myspringmvc/login/processForm">
    <input type="submit" value="log out"/>
</form:form>


</body>
</html>