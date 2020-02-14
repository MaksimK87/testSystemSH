<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>registration</title>
    <style>
        .error {
            color: red
        }
    </style>
</head>
<body>
<form:form action="/myspringmvc/registration/processRegistration" modelAttribute="user">

    <br/>
    Enter Login: <form:input placeholder="login" path="login" />
    <form:errors path="login" cssClass="error" /> <span style="color: firebrick">${message}</span>
    <br/>

    Enter Password: <form:password placeholder="password" path="password"/>
    <form:errors path="password" cssClass="error"/><br/>

    Enter email: <form:input placeholder="email" path="email"/>
    <form:errors path="email" cssClass="error"/><br/>

    Enter name: <form:input placeholder="name" path="userDetails.name"/>
    <form:errors path="userDetails.name"/><br/>

    Enter surname: <form:input placeholder="surname" path="userDetails.surName"/>
    <form:errors path="userDetails.surName" cssClass="error"/><br/>

    <input type="submit" value="sign up">
</form:form>
</body>
</html>